package com.gda.cotizador.service.impl.validate.cotizacion;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.cotizasion.CotizacionDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;
import com.gda.cotizador.service.validate.cotizacion.ValidateCotizacion;
import com.gda.cotizador.utils.Validacion;

@Service
public class ValidateCotizacionServiceImpl implements ValidateCotizacion{
	
	final static Logger logger = LogManager.getLogger(ValidateCotizacionServiceImpl.class);
	
	@Override
	public void validateCotizacion(RequestCotizacionDto serviceRequest) throws Exception{
		Set<ConstraintViolation<Object>> constraintViolations = Validacion.validatObject(serviceRequest);
		if(!constraintViolations.isEmpty()){
			String violations = Validacion.getViolationsObject(constraintViolations);
			throw new Exception(violations);
		}
	}
	
	@Override
	public void validateRequestConvenio(RequestConvenioDto serviceRequest) throws Exception{
		Set<ConstraintViolation<Object>> constraintViolations = Validacion.validatObject(serviceRequest);
		if(!constraintViolations.isEmpty()){
			String violations = Validacion.getViolationsObject(constraintViolations);
			throw new Exception(violations);
		}
	}

	/**
	 * Funcion para la validacion del objeto dto CotizacionDto
	 * 
	 * @param serviceRequest objeto del tipo CotizacionDto
	 * @throws Exception
	 */
	@Override
	public void validateCotizacion(CotizacionDto serviceRequest) throws Exception{
		Set<ConstraintViolation<Object>> constraintViolations = Validacion.validatObject(serviceRequest);
		if(!constraintViolations.isEmpty()){
			String violations = Validacion.getViolationsObject(constraintViolations);
			throw new Exception(violations);
		}
	}

}
