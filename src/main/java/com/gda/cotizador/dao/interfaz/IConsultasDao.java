/**
 * 
 */
package com.gda.cotizador.dao.interfaz;

import java.util.List;

import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.requestExamen.FiltroExamenConveniosDto;

/**
 * 
 */
public interface IConsultasDao {
	
	  List<ExamenConfigDto> getListSearchExamenConveniosDto(FiltroExamenConveniosDto paramFiltroExamenConveniosDto, Integer paramInteger);
	  
	  

}
