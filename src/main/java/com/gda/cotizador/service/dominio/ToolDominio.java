package com.gda.cotizador.service.dominio;

import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.cotizacion.CotizacionDto;
import com.gda.cotizador.dto.cotizacion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;

public interface ToolDominio {

	RequestCotizacionDto addConvenioDetalle(RequestCotizacionDto request);
	TOrdenSucursalCotizacionDto saveTOrdenSucursalCotizacion(CotizacionDto cotizacionDto,AccesoClienteDto accesoClienteDto) throws Exception;
	CotizacionDto saveTordenExamenSucursalCotizacion(CotizacionDto cotizacionDto,
			TOrdenSucursalCotizacionDto ordenCotizacionDto) throws Exception;
}
