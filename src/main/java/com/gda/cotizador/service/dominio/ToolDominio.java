package com.gda.cotizador.service.dominio;

import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.cotizasion.CotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;

public interface ToolDominio {

	RequestCotizacionDto addConvenioDetalle(RequestCotizacionDto request);
	TOrdenSucursalCotizacionDto saveTOrdenSucursalCotizacion(CotizacionDto cotizacionDto) throws Exception;
	CotizacionDto saveTordenExamenSucursalCotizacion(CotizacionDto cotizacionDto,
			TOrdenSucursalCotizacionDto ordenCotizacionDto) throws Exception;
}
