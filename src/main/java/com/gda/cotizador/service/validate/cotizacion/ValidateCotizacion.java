package com.gda.cotizador.service.validate.cotizacion;

import com.gda.cotizador.dto.cotizador.RequestCotizacionDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;

public interface ValidateCotizacion {

	void validateCotizacion(RequestCotizacionDto serviceRequest) throws Exception;

	void validateRequestConvenio(RequestConvenioDto serviceRequest) throws Exception;

}
