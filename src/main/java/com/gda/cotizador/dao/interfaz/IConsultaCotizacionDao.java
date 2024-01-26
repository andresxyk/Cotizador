package com.gda.cotizador.dao.interfaz;

import java.math.BigDecimal;
import java.util.List;

import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.cotizacion.CExamenDto;
import com.gda.cotizador.dto.cotizacion.CodingCotizacionDto;
import com.gda.cotizador.dto.cotizacion.RequisitionCotizacion;
import com.gda.cotizador.dto.cotizacion.Subject;
import com.gda.cotizador.dto.cotizacion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizacion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.requestPacienteMembresia.FiltroPacienteMembresiaDto;
import com.gda.cotizador.dto.requestPacienteMembresia.PacienteMembresiaDto;
import com.gda.cotizador.dto.seguridad.UssersDTO;

public interface IConsultaCotizacionDao {

	List<CExamenDto> getListCExamenDto2(String sclavesinonimo, Integer cconvenio);

	Integer insertTOrdenSucursalCotizacion(TOrdenSucursalCotizacionDto dto)throws Exception;
	
	String getSSucursal(Integer csucursal);
	
	Integer getCmarcaOfConvenio(Integer cconvenio); 
	
	Integer insertTOrdenExamenSucursalCotizacion(TOrdenExamenSucursalCotizacionDto dto)throws Exception;
	
	List<PerfilDto> getListExamenesPerfil(Integer cperfil, Integer cconvenio);

	List<AccesoClienteDto> getListAccesoCliente(UssersDTO user) throws Exception;
	/**
	 * Funcion para consular en la bd que el convenio este en la marca
	 * @param marca
	 * @param conveion
	 * @return Integer 1 = existe, 0 = no existe
	 */
	Integer validationConvIndiseBran(Integer marca, Integer conveion);

	/**
	 * Funcion para validar en la bd que el examen pertenesca al convenio
	 * @param conveion
	 * @param cexamen
	 * @return Integer 1 = existe, 0 = no existe
	 */
	Integer validationConvIndiseExamn(Integer conveion, String cexamen);
	
	boolean validarExamenConvenio(CodingCotizacionDto codingdto);
	
	boolean validarPacienteMarca(Integer marca,String patient);

	Integer updateTOrdenSucursalCotizacion(Integer kordensucursalcotizacion, BigDecimal mpuntosorden);

	List<PacienteMembresiaDto> getListSearchMembresiaDto(FiltroPacienteMembresiaDto filtro, Integer cmarca);

	String[] getListSucursalesProcesa(Integer cexamen);

}
