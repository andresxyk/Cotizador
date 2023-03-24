package com.gda.cotizador.dao.interfaz;

import java.util.List;

import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.cotizasion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizasion.CExamenDto;
import com.gda.cotizador.dto.cotizasion.CodingDto;
import com.gda.cotizador.dto.seguridad.UssersDTO;

public interface IConsultaCotizacionDao {

	List<CExamenDto> getListCExamenDto2(String sclavesinonimo, Integer cconvenio);

	Integer insertTOrdenSucursalCotizacion(TOrdenSucursalCotizacionDto dto)throws Exception;
	
	String getSSucursal(Integer csucursal);
	
	
	Integer getCmarcaOfConvenio(Integer cconvenio); 
	
	Integer insertTOrdenExamenSucursalCotizacion(TOrdenExamenSucursalCotizacionDto dto)throws Exception;
	
	List<PerfilDto> getListExamenesPerfil(Integer cperfil, Integer cconvenio);

	List<AccesoClienteDto> getListAccesoCliente(UssersDTO user) throws Exception;
	
	boolean validarExamenConvenio(CodingDto codingdto);
}
