package com.gda.cotizador.service.dominio;

import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.dto.requestSucursal.RequestSucursalDto;

public interface Cotizador {

	RequestConvenioDto procesarRequestConvenio(RequestConvenioDto request) throws Exception;

	RequestExamenDto procesarRequestExamen(RequestExamenDto request) throws Exception;

	RequestSucursalDto procesarRequestSucursal(RequestSucursalDto request) throws Exception;

	RequestCotizacionDto procesarRequestCotizacion(RequestCotizacionDto request) throws Exception;
	
	RequestCotizacionDto procesarNewCotizacion(RequestCotizacionDto request) throws Exception;

}
