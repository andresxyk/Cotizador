package com.gda.cotizador.service.impl.dominio;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.cotizador.RequestCotizacionDto;
import com.gda.cotizador.dto.requestConvenio.ConvenioDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.dto.requestSucursal.RequestSucursalDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.service.validate.cotizacion.ValidateCotizacion;
import com.gda.cotizador.utils.GeneralUtil;

@Service
public class CotizadorServiceImpl implements Cotizador{

	final static Logger logger = LogManager.getLogger(CotizadorServiceImpl.class);
	
	@Autowired
	private GeneralUtil generalUtil;
	@Autowired
	private IConsultasDao consultasDao;
	@Autowired
	private ToolServiceImpl toolServiceImpl;
	@Autowired
	private ValidateCotizacion validateCotizacion;
	@Autowired
	private Environment env;
	
	@Override
	public RequestConvenioDto procesarRequestConvenio(RequestConvenioDto request) throws Exception {
		validateCotizacion.validateRequestConvenio(request);
		if(env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
			List<ConvenioDto> list = consultasDao.getListConvenioDto(request.getFiltro());
			request.setConvenios(list);			
		}else {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
		return request;
	}
	
	@Override
	public RequestExamenDto procesarRequestExamen(RequestExamenDto request) throws Exception {
		if(env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
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
		}else {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
		return request;
	}
	
	@Override
	public RequestSucursalDto procesarRequestSucursal(RequestSucursalDto request) throws Exception {
		if(env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
			List<SucursalDto> list = consultasDao.getListSearchSucursalDto(request.getFiltro(), request.getHeader().getMarca());
			request.setSucursales(list);			
		}else {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
		return request;
	}
	
	@Override
	public RequestCotizacionDto procesarRequestCotizacion(RequestCotizacionDto request) throws Exception {
		validateCotizacion.validateCotizacion(request);
		if(env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
			request = toolServiceImpl.addConvenioDetalle(request);			
		}else {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
		return request;
	}
	
}
