package com.gda.cotizador.dao.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gda.cotizador.dao.interfaz.IConsultaCotizacionDao;
import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dao.mapper.AccesoClienteMapper;
import com.gda.cotizador.dao.mapper.PerfilMapper;
import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.cotizasion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.dto.seguridad.UssersDTO;

@Repository("consultasDaoCotizacionImpl")
public class ConsultaDaoCotizacionImpl extends JdbcDaoSupport implements IConsultaCotizacionDao{
	
	@Autowired
    @Qualifier("jdbcSlave")
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ExamenDto> getListCExamenDto2(String sclavesinonimo, Integer cconvenio){
		List<ExamenDto> list ;
		return null;
	}
	
	@Override
	public String getSSucursal(Integer csucursal) {
		logger.info("ejecutando getSSucursal");
		String ssucursal = null;
		
		String query = "select ssucursal from c_sucursal where csucursal = ?;" ;
	
		ssucursal = this.getJdbcTemplate().queryForObject(query, new Object[] {csucursal}, String.class);

		logger.info("getSSucursal ejecutado: " + ssucursal);
		return ssucursal;
	}
	@Override
	public Integer getCmarcaOfConvenio(Integer cconvenio) {
		logger.info("ejecutando getCmarcaOfConvenio");
		Integer marca = null;
		
		String query = "select cmarca from e_convenio where cconvenio = ?" ;
	
		marca = this.getJdbcTemplate().queryForObject(query, new Object[] {cconvenio}, Integer.class);

		logger.info("getCmarcaOfConvenio ejecutado: " + marca);
		return marca;
	}
	
	@Override
	public Integer insertTOrdenSucursalCotizacion(TOrdenSucursalCotizacionDto dto)throws Exception{
		logger.info("entra insertTOrdenSucursalCotizacion");
		
		Integer insert = 0;
		String query = "INSERT INTO public.t_orden_sucursal_cotizacion(\r\n"
				+ "	kordensucursalcotizacion, kordensucursal, cmarca, ssucursal, \r\n"
				+ "	csucursal, kpaciente, cmedico, smedico, \r\n"
				+ "	msubtotal, mdescuentopromocion, mdescuentoempresa, mdescuentomedico, \r\n"
				+ "	mfacturaempresa, mpagopaciente, miva, piva, \r\n"
				+ "	mtotal, user_id, cestadoregistro, dregistro, \r\n"
				+ "	sobservacion, cconvenio, user_id_change, csucursaldestino)\r\n"
				+ "	VALUES (tordensucursalcotizacion_sequence.nextval, ?, ?, ?, \r\n"
				+ "			?, ?, ?, ?, \r\n"
				+ "			?, ?, ?, ?, \r\n"
				+ "			?, ?, ?, ?, \r\n"
				+ "			?, ?, ?, ?, \r\n"
				+ "			?, ?, ?, ?) RETURNING kordensucursalcotizacion; " ;
		
		try {
			insert = this.getJdbcTemplate().queryForObject(query, new Object[]{
					dto.getKordensucursal(), dto.getCmarca(), dto.getSsucursal(),
					dto.getCsucursal(), dto.getKpaciente(), dto.getCmedico(), dto.getSmedico(),
					dto.getMsubtotal(), dto.getMdescuentopromocion(), dto.getMdescuentoempresa(), dto.getMdescuentomedico(),
					dto.getMfacturaempresa(), dto.getMpagopaciente(), dto.getMiva(), dto.getPiva(),
					dto.getMtotal(), dto.getUserid(), dto.getCestadoregistro(), dto.getDregistro(), 
					dto.getSobservacion(), dto.getCconvenio(), dto.getUseridchange(), dto.getCsucursaldestino()
			},Integer.class);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		logger.info("insertTOrdenSucursalCotizacion ejecutado");
		return insert;
	}	
	@Override
	public Integer insertTOrdenExamenSucursalCotizacion(TOrdenExamenSucursalCotizacionDto dto)throws Exception{
		logger.info("entra insertTOrdenExamenSucursalCotizacion");
		
		Integer insert = 0;
		String query = "INSERT INTO public.t_orden_examen_sucursal_cotizacion(\r\n"
				+ "	kordenexamensucursalcotizacion, kordensucursalcotizacion, cexamen, sexamen, \r\n"
				+ "	msubtotal, mdescuentopromocion, mdescuentoempresa, mdescuentomedico, \r\n"
				+ "	mfacturaempresa, mpagopaciente, miva, mtotal, \r\n"
				+ "	user_id, cestadoregistro, dregistro, cconvenio, \r\n"
				+ "	smotivocancelacion, cperfil, uvolumenexamen)\r\n"
				+ "	VALUES (tordenexamensucursalcotizacion_sequence.nextval, ?, ?, ?, \r\n"
				+ "			?, ?, ?, ?, \r\n"
				+ "			?, ?, ?, ?, \r\n"
				+ "			?, ?, ?, ?, \r\n"
				+ "			?, ?, ?) RETURNING kordenexamensucursalcotizacion; " ;
		
		try {
			insert = this.getJdbcTemplate().queryForObject(query, new Object[]{
					dto.getKordensucursalcotizacion(), dto.getCexamen(), dto.getSexamen(),
					dto.getMsubtotal(), dto.getMdescuentopromocion(), dto.getMdescuentoempresa(), dto.getMdescuentomedico(),
					dto.getMfacturaempresa(), dto.getMpagopaciente(), dto.getMiva(), dto.getMtotal(),
					dto.getUserid(), dto.getCestadoregistro(), dto.getDregistro(), dto.getCconvenio(),
					dto.getSmotivocancelacion(), dto.getCperfil(), dto.getUvolumenexamen()
			},Integer.class);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		logger.info("insertTOrdenExamenSucursalCotizacion ejecutado");
		return insert;
	}	
	@Override
	public List<PerfilDto> getListExamenesPerfil(Integer cperfil, Integer cconvenio){
		logger.info("ejecutando getListExamenesPerfil");
		List<PerfilDto> list;
		String query = "SELECT cp.cperfil, cp.sperfil,  ecp.cconvenio,\r\n"
				+ "ce.cexamen, ce.sexamen ,\r\n"
				+ "uvolumenexamen, ecp.ncantidadexamen,  \r\n"
				+ "elcd.mprecio subtotal , ecp.mpreciofacturarconiva ,\r\n"
				+ "round ((ecp.mpreciofacturarconiva / ecp.ncantidadexamen), 2) mpagopacienteytotal\r\n"
				+ "FROM  \r\n"
				+ "c_perfil cp \r\n"
				+ "inner join e_convenio_perfil ecp ON ecp.cperfil=cp.cperfil\r\n"
				+ "inner join e_perfil_examen epe on epe.cperfil = cp.cperfil\r\n"
				+ "inner join c_convenio cc ON ecp.cconvenio=cc.cconvenio	\r\n"
				+ "INNER JOIN e_convenio ec ON ec.cconvenio=cc.cconvenio and cp.cmarca = ec.cmarca\r\n"
				+ "inner join c_lista_corporativa clc on clc.clistacorporativa = ec.clistacorporativa\r\n"
				+ "INNER JOIN web2lablis.c_examen ce ON ce.cexamen=epe.cexamen	\r\n"
				+ "inner join e_lista_corporativa_Detalle elcd \r\n"
				+ "	on clc.clistacorporativa = elcd.clistacorporativa and ce.cexamen = elcd.cexamen\r\n"
				+ "WHERE cp.cperfil = ? \r\n"
				+ "and cc.cconvenio= ? " ;
		list = this.getJdbcTemplate().query(query, new Object[]{cperfil, cconvenio},new PerfilMapper());
		logger.info("getListExamenesPerfil ejecutado:"+list.size());
		return list;
	}
	
	@Override
	public List<AccesoClienteDto> getListAccesoCliente(UssersDTO user) throws Exception{
		List<AccesoClienteDto> list;
		logger.info("ejecutando getListAccesoCliente");
		try {
			String query = "select * from clientes.c_acceso_cliente_ws where sidusuariows = ? AND spasswordws = ? " ;
			list = this.getJdbcTemplate().query(query, new Object[] {
				user.getUser(),
				user.getPassword()
			}, new AccesoClienteMapper());
			logger.info("getListAccesoCliente ejecutado: " + list.size());
			return list;			
		} catch (Exception e) {
			throw e;
		}
	}
}
