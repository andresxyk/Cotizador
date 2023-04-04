package com.gda.cotizador.dao.implement;

import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gda.cotizador.dao.interfaz.IConsultaCotizacionDao;
import com.gda.cotizador.dao.mapper.AccesoClienteMapper;
import com.gda.cotizador.dao.mapper.CExamenMapper;
import com.gda.cotizador.dao.mapper.PerfilMapper;
import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.cotizacion.CExamenDto;
import com.gda.cotizador.dto.cotizacion.CodingCotizacionDto;
import com.gda.cotizador.dto.cotizacion.RequisitionCotizacion;
import com.gda.cotizador.dto.cotizacion.Subject;
import com.gda.cotizador.dto.cotizacion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizacion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.seguridad.UssersDTO;

@Repository("ConsultaDaoCotizacionImpl")
public class ConsultaDaoCotizacionImpl implements IConsultaCotizacionDao{
	final static Logger logger = LogManager.getLogger(ConsultaDaoCotizacionImpl.class);


	@Autowired
	DataSource dataSource;
	
	@Autowired
    @Qualifier("jdbcSlave")
    private JdbcTemplate jdbcTemplate;
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean validarExamenConvenio(CodingCotizacionDto codingdto){
		logger.info("Validando el Examen con el Convenio");
		boolean validacion = false;
		String query =
					"select exists(select cconvenio, cexamen from e_convenio_detalle where cconvenio = ? and cexamen = ?)";
		validacion = jdbcTemplate.queryForObject(query, new Object[]{codingdto.getConvenio(), codingdto.getCode()},
	  			Boolean.class);
		return validacion;
		  			
	}
	public boolean validarPacienteMarca(Integer marca,String patient) {
		logger.info("Validando el Examen con el Convenio");
		boolean validacion = false;
		String query = 
				"select exists(select cmarca, kpaciente\r\n"
				+ "from t_paciente where cmarca = ? and kpaciente = ?)\r\n";
		validacion = jdbcTemplate.queryForObject(query, new Object[]{marca, patient},
			  			Boolean.class);
		return validacion;
	}
		
	
	@Override
	public List<CExamenDto> getListCExamenDto2(String sclavesinonimo, Integer cconvenio){
		List<CExamenDto> list ;
		logger.info("ejecutando getListCExamenDto");
		String query = 	"SELECT  ce.cexamen, ce.sexamen, ce.snemonico, ce.blistapublico, ce.sexamenweb, ce.bentregausb,ce.bregistrarconsumo, ce.cmarca, ce.cexamenazteca, ce.sexamenlabcore, ce.cexamenproceso "+
		"FROM c_examen_convenio_sinonimo cexs INNER JOIN web2lablis.c_examen ce on cexs.cexamen = ce.cexamen "+      
		"									  INNER JOIN e_convenio_detalle ecd on ecd.cexamen = ce.cexamen and ecd.cconvenio=cexs.cconvenio "+      
		"WHERE cexs.sclavesinonimo = ? and cexs.cconvenio = ? "; 
		list = jdbcTemplate.query(query, new Object[] {
			sclavesinonimo,cconvenio
			}, new CExamenMapper());

		logger.info("getListCExamenDto ejecutado: " + list.size());
	return list;
	}
	
	@Override
	public String getSSucursal(Integer csucursal) {
		logger.info("ejecutando getSSucursal");
		String ssucursal = null;
		
		String query = "select ssucursal from c_sucursal where csucursal = ?;" ;
	
		ssucursal = jdbcTemplate.queryForObject(query, new Object[] {csucursal}, String.class);

		logger.info("getSSucursal ejecutado: " + ssucursal);
		return ssucursal;
	}
	@Override
	public Integer getCmarcaOfConvenio(Integer cconvenio) {
		logger.info("ejecutando getCmarcaOfConvenio");
		Integer marca = null;
		
		String query = "select cmarca from e_convenio where cconvenio = ?" ;
	
		marca = jdbcTemplate.queryForObject(query, new Object[] {cconvenio}, Integer.class);

		logger.info("getCmarcaOfConvenio ejecutado: " + marca);
		return marca;
	}
	
	@SuppressWarnings("deprecation")
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
			insert = jdbcTemplate.queryForObject(query, new Object[]{
					dto.getKordensucursal(), dto.getCmarca(), dto.getSsucursal(),
					dto.getCsucursal(), dto.getKpaciente(), dto.getCmedico(), dto.getSmedico(),
					dto.getMsubtotal(), dto.getMdescuentopromocion(), dto.getMdescuentoempresa(), dto.getMdescuentomedico(),
					dto.getMfacturaempresa(), dto.getMpagopaciente(), dto.getMiva(), 16,
					dto.getMtotal(), dto.getUserid(), dto.getCestadoregistro(), dto.getDregistro(), 
					dto.getSobservacion(), dto.getCconvenio(), dto.getUseridchange(), dto.getCsucursaldestino()
			},Integer.class);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return insert;
	}	
	@Override
	public Integer insertTOrdenExamenSucursalCotizacion(TOrdenExamenSucursalCotizacionDto dto)throws Exception{
		logger.info("insertTOrdenExamenSucursalCotizacion");
		
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
			insert = jdbcTemplate.queryForObject(query, new Object[]{
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
		return insert;
	}	
	@Override
	public List<PerfilDto> getListExamenesPerfil(Integer cperfil, Integer cconvenio){
		logger.info(" getListExamenesPerfil");
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
		list = jdbcTemplate.query(query, new Object[]{cperfil, cconvenio},new PerfilMapper());
		// logger.info("getListExamenesPerfil ejecutado:"+list.size());
		return list;
	}
	
	@Override
	public List<AccesoClienteDto> getListAccesoCliente(UssersDTO user) throws Exception{
		List<AccesoClienteDto> list;
		logger.info("ejecutando getListAccesoCliente");
		try {
			String query = "select * from clientes.c_acceso_cliente_ws where sidusuariows = ? AND spasswordws = ? " ;
			list = jdbcTemplate.query(query, new Object[] {
				user.getUser(),
				user.getPassword()
			}, new AccesoClienteMapper());
			// logger.info("getListAccesoCliente ejecutado: " + list.size());
			return list;			
		} catch (Exception e) {
			throw e;
		}
	}

	/*Validaciones para las cotizasiones */
	@Override
    @SuppressWarnings("deprecation")
	public Integer validationConvIndiseBran(Integer marca, Integer conveion){
		return jdbcTemplate.queryForObject(
			"select Count(*) from c_convenio ccon inner join e_convenio econ on ccon.cconvenio = econ.cconvenio where econ.cmarca = ? and econ.cconvenio = ?"
		, new Object[] {marca,conveion},
		Integer.class);
	}

	@Override
    @SuppressWarnings("deprecation")
	public Integer validationConvIndiseExamn(Integer conveion, String cexamen){
		return jdbcTemplate.queryForObject(
			"select Count(*) from c_convenio ctc inner join e_convenio_detalle ectd on ctc.cconvenio = ectd.cconvenio where ectd.cexamen = ? and ctc.cconvenio = ?"
		, new Object[] {cexamen,conveion},
		Integer.class);
	}
}
