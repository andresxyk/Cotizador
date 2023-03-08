package com.gda.cotizador.service.dominio;

import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;

public interface ToolDominio {

	RequestCotizacionDto addConvenioDetalle(RequestCotizacionDto request);
	TOrdenSucursalCotizacionDto saveTOrdenSucursalCotizacion(RequestCotizacionDto cotizacionDto,
			AccesoClienteDto accesoClienteDto) throws Exception;
	RequestCotizacionDto saveTordenExamenSucursalCotizacion(RequestCotizacionDto cotizacionDto,
			TOrdenSucursalCotizacionDto ordenCotizacionDto) throws Exception;
}
