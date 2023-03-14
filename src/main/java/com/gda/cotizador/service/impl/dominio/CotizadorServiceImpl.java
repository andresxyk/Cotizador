package com.gda.cotizador.service.impl.dominio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dao.interfaz.IConsultaCotizacionDao;
import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.cotizasion.CodingDto;

import com.gda.cotizador.dto.cotizadorRequest.Coding;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.cotizasion.CotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.general.Base64Const;
import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.requestConvenio.ConvenioDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.dto.cotizasion.CExamenDto;
import com.gda.cotizador.dto.requestSucursal.RequestSucursalDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;
import com.gda.cotizador.seguridad.Seguridad;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.service.validate.cotizacion.ValidateCotizacion;
import com.gda.cotizador.utils.GeneralUtil;
import com.gda.cotizador.utils.GenerateReportPDF;

@Service
public class CotizadorServiceImpl implements Cotizador {

	final static Logger logger = LogManager.getLogger(CotizadorServiceImpl.class);

	@Autowired
	private GeneralUtil generalUtil;
	@Autowired
	private IConsultasDao consultasDao;
	@Autowired
	private IConsultaCotizacionDao consultasCotizacionDao;
	@Autowired
	private ToolServiceImpl toolServiceImpl;
	@Autowired
	private ValidateCotizacion validateCotizacion;
	@Autowired
	private Environment env;
	@Autowired
	private SetsDtosImpl setsDtosImpl;
	@Autowired
	private Base64Const base64;
	@Autowired
	private Seguridad seguridad;
	@Autowired
	private GenerateReportPDF generateReport;

	@Override
	public RequestConvenioDto procesarRequestConvenio(RequestConvenioDto request) throws Exception {
		validateCotizacion.validateRequestConvenio(request);
		if (env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
			List<ConvenioDto> list = consultasDao.getListConvenioDto(request.getFiltro());
			request.setConvenios(list);
		} else {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
		return request;
	}

	@Override
	public RequestExamenDto procesarRequestExamen(RequestExamenDto request) throws Exception {
		if (env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
			List<ExamenDto> examenes = new ArrayList<>();
			List<ExamenConfigDto> list = consultasDao.getListSearchExamenDto(request.getFiltro());
			for (ExamenConfigDto examenConfigDto : list) {
				ExamenDto examenDto = new ExamenDto();
				examenDto.setCexamen(examenConfigDto.getCexamen());
				examenDto.setSexamen(examenConfigDto.getSexamen());
				examenDto.setPrecio(examenConfigDto.getMprecio());
				examenDto.setIndicacionespaciente(examenConfigDto.getScondicionpreanalitica());
				examenDto.setFechaentrega(generalUtil.calcularFechaPromesa(examenConfigDto));
				examenDto.setCdepartamento(examenConfigDto.getCdepartamento());
				examenDto.setSdepartamento(examenConfigDto.getSdepartamento());
				examenes.add(examenDto);
			}
			request.setExamenes(examenes);
		} else {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
		return request;
	}

	@Override
	public RequestSucursalDto procesarRequestSucursal(RequestSucursalDto request) throws Exception {
		if (env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
			List<SucursalDto> list = consultasDao.getListSearchSucursalDto(request.getFiltro(),
					request.getHeader().getMarca());
			request.setSucursales(list);
		} else {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
		return request;
	}

	@Override
	public RequestCotizacionDto procesarRequestCotizacion(RequestCotizacionDto request) throws Exception {
		validateCotizacion.validateCotizacion(request);
		if (!(env.getProperty("access.token.api").equals(request.getHeader().getToken()))) {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
			request.setStatus("completed");
			request.setBase64(base64.base64);
			request = toolServiceImpl.addConvenioDetalle(request);	
		return request;
	}

	@Override
	public CotizacionDto procesarNewCotizacion(CotizacionDto request) throws Exception {
		validateCotizacion.validateCotizacion(request);
		try {
			// if
			// (!env.getProperty("access.token.api").equals(request.getHeader().getToken()))
			// {
			// throw new Exception("El token es incorrecto, favor de validar el acceso.");
			// }
			List<AccesoClienteDto> listAcceso = seguridad.accesoCliente(request.getHeader().getToken());
			logger.info(listAcceso);
			if (listAcceso.size() > 0) {
				if (request.getRequisition().getMarca() == 16) {
					Boolean procesarOrden = false;
					for (CodingDto coding : request.getCode().getCoding()) {
						List<CExamenDto> listCExamen = consultasCotizacionDao.getListCExamenDto2(coding.getCode(),
								request.getRequisition().getConvenio());
						if (listCExamen != null && listCExamen.size() > 0) {
							procesarOrden = true;
							logger.info("El estudio SI se encuentra en convenio: [" + coding.getCode() + "]");
						} else {
							logger.info("El estudio NO se encuentra en convenio: [" + coding.getCode() + "]");
						}
					}
					if (procesarOrden) {
						TOrdenSucursalCotizacionDto tosc = toolServiceImpl.saveTOrdenSucursalCotizacion(request,listAcceso.get(0));
						logger.info("Marca: " + tosc.getCmarca());
						generateReport.doIndicaciones(tosc);
						request = toolServiceImpl.saveTordenExamenSucursalCotizacion(request, tosc);
						request.setId(tosc.getKordensucursalcotizacion());
						request.setStatus("completed");
						request.setBase64(base64.base64);
						request.setGDA_menssage(setsDtosImpl.setForGdaMessage(HttpStatus.OK.value(), "success",
								"La transacción fue exitosa." + request.getGDA_menssage()));
					} else {
						request.setGDA_menssage(setsDtosImpl.setForGdaMessage(HttpStatus.CREATED.value(), "success",
								"Los estudios de la cotizacion no estan en convenio"));
					}
					return request;
				}
				TOrdenSucursalCotizacionDto tosc = toolServiceImpl.saveTOrdenSucursalCotizacion(request,listAcceso.get(0));
				request = toolServiceImpl.saveTordenExamenSucursalCotizacion(request, tosc);
				request.setId(tosc.getKordensucursalcotizacion());
				request.setStatus("completed");
				request.setBase64(base64.base64);
				request.setGDA_menssage(setsDtosImpl.setForGdaMessage(HttpStatus.CREATED.value(), "success",
						"La transacción fue exitosa."));
				// logger.info(gson.toJson(request));
				return request;
			}
			throw new Exception("No se tiene acceso con el convenio " + request.getRequisition().getConvenio());

		} catch (Exception e) {
			throw e;
		}

	}
}
