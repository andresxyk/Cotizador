package com.gda.cotizador.service.dominio;

import com.gda.cotizador.dto.comercial.RequestComercialDto;
import com.gda.cotizador.dto.comercial.RequestTipoComercialDto;
import com.gda.cotizador.dto.cotizacion.CotizacionDto;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.dto.requestMarca.RequestMarcaDto;
import com.gda.cotizador.dto.requestPerfil.RequestPerfilDto;
import com.gda.cotizador.dto.requestSucursal.RequestSucursalDto;

public interface Cotizador {

	RequestConvenioDto procesarRequestConvenio(RequestConvenioDto request) throws Exception;

	RequestExamenDto procesarRequestExamen(RequestExamenDto request) throws Exception;
	
	RequestSucursalDto procesarRequestSucursal(RequestSucursalDto request) throws Exception;

	RequestCotizacionDto procesarRequestCotizacion(RequestCotizacionDto request) throws Exception;
	
	RequestMarcaDto procesarRequestMarca(RequestMarcaDto request) throws Exception;
	

	 RequestPerfilDto procesarRequestPerfil(RequestPerfilDto request) throws Exception;
	
	/**
	 * Funcion para procesar una nueva cotizasion y guardarla en la bd
	 * @param request objeto del tipo CotizacionDto
	 * @return CotizacionDto
	 * @throws Exception
	 */
	CotizacionDto procesarNewCotizacion(CotizacionDto request) throws Exception;

	RequestComercialDto procesarRequestComercial(RequestComercialDto request) throws Exception;

	RequestTipoComercialDto procesarRequestTipoComercial(RequestTipoComercialDto request) throws Exception;

}
