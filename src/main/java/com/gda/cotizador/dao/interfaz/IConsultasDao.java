package com.gda.cotizador.dao.interfaz;
import java.sql.Connection;
import java.util.List;


import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.cotizasion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.db.EConvenioDetalleDto;
import com.gda.cotizador.dto.requestConvenio.ConvenioDto;
import com.gda.cotizador.dto.requestConvenio.FiltroDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;
import com.gda.cotizador.dto.seguridad.UssersDTO;

public interface IConsultasDao {

	List<ConvenioDto> getListConvenioDto(FiltroDto filtro);

	List<ExamenConfigDto> getListSearchExamenDto(com.gda.cotizador.dto.requestExamen.FiltroDto filtro);

	List<SucursalDto> getListSearchSucursalDto(com.gda.cotizador.dto.requestSucursal.FiltroDto filtro,
			Integer cmarca);

	List<ExamenConfigDto> getListSearchExamenDto(Integer cexamen, Integer cconvenio);

	List<EConvenioDetalleDto> getListEConvenioDetalle(Integer cconvenio, Integer cexamen);
	
}
