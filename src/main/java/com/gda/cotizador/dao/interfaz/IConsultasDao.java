package com.gda.cotizador.dao.interfaz;

import java.util.List;

import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.requestConvenio.ConvenioDto;
import com.gda.cotizador.dto.requestConvenio.FiltroDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;

public interface IConsultasDao {

	List<ConvenioDto> getListConvenioDto(FiltroDto filtro);

	List<ExamenConfigDto> getListSearchExamenDto(com.gda.cotizador.dto.requestExamen.FiltroDto filtro);

	List<SucursalDto> getListSearchSucursalDto(com.gda.cotizador.dto.requestSucursal.FiltroDto filtro,
			Integer cmarca);

	List<ExamenConfigDto> getListSearchExamenDto(Integer cexamen, Integer cconvenio);

}
