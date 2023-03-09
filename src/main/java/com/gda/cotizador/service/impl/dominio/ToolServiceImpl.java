package com.gda.cotizador.service.impl.dominio;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.cotizadorRequest.Coding;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.cotizasion.CodingDto;
import com.gda.cotizador.dto.cotizasion.CotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalDto;
import com.gda.cotizador.dto.db.EConvenioDetalleDto;
import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.service.dominio.ToolDominio;
import com.gda.cotizador.utils.GeneralUtil;


@Service
public class ToolServiceImpl implements ToolDominio{

	final static Logger logger = LogManager.getLogger(ToolServiceImpl.class);
	
	@Autowired
	private IConsultasDao consultasDao;
	@Autowired
	private GeneralUtil generalUtil;
	@Autowired
	private SetsDtosImpl setsDtosImpl;
	@Override
		public RequestCotizacionDto addConvenioDetalle(RequestCotizacionDto request) {
			List<Coding> lisCodings = new ArrayList<>();
			BigDecimal ttotal= BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal tsubtotal= BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
			for (Coding coding : request.getCode().getCoding()) {
				List<ExamenConfigDto> list = consultasDao.getListSearchExamenDto(Integer.parseInt(coding.getCode()), coding.getConvenio());
				List<EConvenioDetalleDto> listECD = consultasDao.getListEConvenioDetalle(coding.getConvenio(), Integer.parseInt(coding.getCode()));
				if(list.size()>0) {
					if(listECD.size()>0) {
						coding.setPreciolistamadretotal(list.get(0).getMprecio());
						coding.setIndicacionespaciente(list.get(0).getScondicionpreanalitica());
						coding.setSubtotal(listECD.get(0).getMpreciofacturarsiniva());
						coding.setTotal(listECD.get(0).getMpreciofacturarconiva());
						coding.setDescuentopromocion(BigDecimal.ZERO);
						coding.setPagopaciente(listECD.get(0).getMpreciofacturarconiva());
						coding.setFechaentrega(generalUtil.calcularFechaPromesa(list.get(0)));
						ttotal = ttotal.add(listECD.get(0).getMpreciofacturarconiva().setScale(2, BigDecimal.ROUND_HALF_UP));
						tsubtotal = tsubtotal.add(listECD.get(0).getMpreciofacturarsiniva().setScale(2, BigDecimal.ROUND_HALF_UP));
					}else {
						coding.setPreciolistamadretotal(list.get(0).getMprecio());
						coding.setIndicacionespaciente(list.get(0).getScondicionpreanalitica());
						coding.setSubtotal(list.get(0).getMpreciosiniva());
						coding.setTotal(list.get(0).getMprecio());
						coding.setDescuentopromocion(BigDecimal.ZERO);
						coding.setPagopaciente(list.get(0).getMprecio());
						coding.setFechaentrega(generalUtil.calcularFechaPromesa(list.get(0)));
						ttotal = ttotal.add(list.get(0).getMprecio().setScale(2, BigDecimal.ROUND_HALF_UP));
						tsubtotal = tsubtotal.add(list.get(0).getMpreciosiniva().setScale(2, BigDecimal.ROUND_HALF_UP));					
					}
				}
			lisCodings.add(coding);
		}
		request.getCode().setCoding(lisCodings);
		request.getRequisition().setDescuentopromocion(BigDecimal.ZERO);
		request.getRequisition().setPagopaciente(ttotal);
		request.getRequisition().setTotal(ttotal);
		request.getRequisition().setSubtotal(tsubtotal);
		request.getRequisition().setFechaentrega("");
		return request;
	}
	@Override
	public TOrdenSucursalCotizacionDto saveTOrdenSucursalCotizacion(CotizacionDto cotizacionDto) throws Exception {
		TOrdenSucursalCotizacionDto ordenCotizacionDto = new TOrdenSucursalCotizacionDto();
		ordenCotizacionDto.setKordensucursal(0);
		ordenCotizacionDto.setCmarca(cotizacionDto.getRequisition().getMarca());
		// ordenCotizacionDto.setSsucursal(consultaDao.getSSucursal(accesoClienteDto.getCsucursal()));
		// ordenCotizacionDto.setCsucursal(accesoClienteDto.getCsucursal());
		// ordenCotizacionDto.setCsucursaldestino(accesoClienteDto.getCsucursal());
		
		/*String patient = cotizacionDto.getSubject().getReference().substring(
				cotizacionDto.getSubject().getReference().indexOf("/") + 1,
				cotizacionDto.getSubject().getReference().length());
		ordenCotizacionDto.setKpaciente(Integer.parseInt(patient));
		String practitioner = cotizacionDto.getRequester().getReference().substring(
				cotizacionDto.getRequester().getReference().indexOf("/") + 1,
				cotizacionDto.getRequester().getReference().length());*/
				// ordenCotizacionDto.setCmedico(Integer.parseInt(practitioner));
				ordenCotizacionDto.setSmedico(cotizacionDto.getRequester().getDisplay());
				ordenCotizacionDto.setMsubtotal(cotizacionDto.getRequisition().getSubtotal());
				ordenCotizacionDto.setMdescuentopromocion(cotizacionDto.getRequisition().getDescuentopromocion());
				ordenCotizacionDto.setMdescuentoempresa(BigDecimal.ZERO);
				ordenCotizacionDto.setMdescuentomedico(BigDecimal.ZERO);
				ordenCotizacionDto.setMfacturaempresa(BigDecimal.ZERO);
				ordenCotizacionDto.setMpagopaciente(cotizacionDto.getRequisition().getPagopaciente());
				ordenCotizacionDto.setMiva(BigDecimal.ZERO);
				ordenCotizacionDto.setPiva(BigDecimal.ZERO);
				ordenCotizacionDto.setMtotal(BigDecimal.ZERO);
				ordenCotizacionDto.setUserid(1);
				ordenCotizacionDto.setCestadoregistro(173);
				ordenCotizacionDto.setDregistro(new Date());
				ordenCotizacionDto.setSobservacion("");
				Integer cconvenio = cotizacionDto.getCode().getCoding().get(0).getConvenio();
				ordenCotizacionDto.setCconvenio(cconvenio);
				ordenCotizacionDto.setUseridchange(1);

		Integer idCotizacion = consultasDao.insertTOrdenSucursalCotizacion(ordenCotizacionDto);
		ordenCotizacionDto.setKordensucursalcotizacion(idCotizacion);
		return ordenCotizacionDto;
	}
	@Override
	public CotizacionDto saveTordenExamenSucursalCotizacion(CotizacionDto cotizacionDto,
			TOrdenSucursalCotizacionDto ordenCotizacionDto) throws Exception {
		for (CodingDto coding : cotizacionDto.getCode().getCoding()) {
			try {
				if (cotizacionDto.getRequisition().getMarca() == 16) {
					List<ExamenDto> examenDto = consultasDao.getListCExamenDto2(coding.getCode(),
							cotizacionDto.getRequisition().getConvenio());
					if (examenDto != null && examenDto.size() > 0) {
						consultasDao.insertTOrdenExamenSucursalCotizacion(setsDtosImpl.setForTOrdenExamenSucursalCotizacionDto(ordenCotizacionDto.getKordensucursalcotizacion(),examenDto.get(0).getCexamen(),examenDto.get(0).getSexamen(),
									coding.getSubtotal(),coding.getDescuentopromocion(),BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,coding.getPagopaciente(),BigDecimal.ZERO,
									coding.getTotal(),1,13,coding.getConvenio(),"",-1,1));
					} else {
						logger.error("ERROR:El estudio no se encuentra en convenio");
						cotizacionDto.setGDA_menssage(setsDtosImpl.setForGdaMessage(200,"success",cotizacionDto.getGDA_menssage() + "\nEl estudio " + coding.getCode()+ " no se encuentra en convenio."));
					}
				} else {
					consultasDao.insertTOrdenExamenSucursalCotizacion(setsDtosImpl.setForTOrdenExamenSucursalCotizacionDto(ordenCotizacionDto.getKordensucursalcotizacion(),Integer.parseInt(coding.getCode()),
					coding.getDisplay(),coding.getSubtotal(),coding.getDescuentopromocion(),BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,coding.getPagopaciente(),BigDecimal.ZERO,
					coding.getTotal(),1,13,coding.getConvenio(),"",-1,1));
				}
			} catch (DataIntegrityViolationException e) {
				if (cotizacionDto.getRequisition().getMarca() != 16) {
					List<PerfilDto> listExamenesPerfil = consultasDao
							.getListExamenesPerfil(Integer.parseInt(coding.getCode()), coding.getConvenio());
					if (listExamenesPerfil.size() > 0) {
						BigDecimal bdSubtotal = BigDecimal.ZERO;
						for (PerfilDto perfilDto : listExamenesPerfil) {
							bdSubtotal = bdSubtotal.add(perfilDto.getSubtotal());
						}
						BigDecimal bdSubtotalTotal = bdSubtotal.divide(
								new BigDecimal(listExamenesPerfil.get(0).getNcantidadexamen()), 2,
								RoundingMode.HALF_UP);
						BigDecimal bdDescuentoPromocion = bdSubtotalTotal
								.subtract(listExamenesPerfil.get(0).getMpagopacienteytotal());
						for (PerfilDto perfilDto : listExamenesPerfil) {
							consultasDao.insertTOrdenExamenSucursalCotizacion(setsDtosImpl.setForTOrdenExamenSucursalCotizacionDto(ordenCotizacionDto.getKordensucursalcotizacion(),perfilDto.getCexamen(),
							perfilDto.getSexamen(),bdSubtotalTotal,bdDescuentoPromocion,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,perfilDto.getMpagopacienteytotal(),
							BigDecimal.ZERO,perfilDto.getMpagopacienteytotal(),1,13,perfilDto.getCconvenio(),"",perfilDto.getCperfil(),perfilDto.getUvolumenexamen()));
						}
					} else {
						throw new Exception("No se encontraron registros con el perfil " + coding.getCode()
								+ " en el convenio " + coding.getConvenio());
					}
				}
			}
		}
		return cotizacionDto;
	}
}
