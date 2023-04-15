package com.gda.cotizador.dao.interfaz;
import java.util.List;

import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.comercial.FiltroComercialDto;
import com.gda.cotizador.dto.comercial.FiltroTipoComercialDto;
import com.gda.cotizador.dto.comercial.TipoComercialDto;
import com.gda.cotizador.dto.db.EConvenioDetalleDto;
import com.gda.cotizador.dto.requestConvenio.ConvenioDto;
import com.gda.cotizador.dto.requestConvenio.FiltroConvenioDto;
import com.gda.cotizador.dto.requestMarca.MarcaDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;

public interface IConsultasDao {

	List<ConvenioDto> getListConvenioDto(FiltroConvenioDto filtro);

	List<SucursalDto> getListSearchSucursalDto(com.gda.cotizador.dto.requestSucursal.FiltroSucursalDto filtro,
			Integer cmarca);

	List<ExamenConfigDto> getListSearchExamenDto(Integer cexamen, Integer cconvenio);

	List<EConvenioDetalleDto> getListEConvenioDetalle(Integer cconvenio, Integer cexamen);

	List<MarcaDto> getListSearchMarcaDto(com.gda.cotizador.dto.requestMarca.FiltroMarcaDto filtro);

	List<com.gda.cotizador.dto.requestPerfil.PerfilDto> getListSearchPerfilDto(com.gda.cotizador.dto.requestPerfil.FiltroPerfilDto filtro, Integer cmarca);
	
	List<ExamenConfigDto> getListSearchExamenDto(com.gda.cotizador.dto.requestExamen.FiltroExamenDto filtro, Integer cmarca);

	List<ExamenConfigDto> getListSearchExamenDtoComercial(FiltroComercialDto filtro, Integer cmarca);

	List<TipoComercialDto> getListSearchTipoComercialDto(FiltroTipoComercialDto filtro, Integer cmarca);

	
}
