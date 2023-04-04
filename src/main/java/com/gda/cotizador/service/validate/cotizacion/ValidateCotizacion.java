package com.gda.cotizador.service.validate.cotizacion;

import com.gda.cotizador.dto.cotizacion.CotizacionDto;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;

public interface ValidateCotizacion {

	void validateCotizacion(RequestCotizacionDto serviceRequest) throws Exception;
 	void validateCotizacion(CotizacionDto serviceRequest) throws Exception;

	void validateRequestConvenio(RequestConvenioDto serviceRequest) throws Exception;

}
