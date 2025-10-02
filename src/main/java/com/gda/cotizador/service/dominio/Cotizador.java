package com.gda.cotizador.service.dominio;

import com.gda.cotizador.dto.requestExamen.RequestExamenConveniosDto;

public interface Cotizador {
	
	RequestExamenConveniosDto procesarRequestExamenConvenios(RequestExamenConveniosDto paramRequestExamenConveniosDto) throws Exception;

}
