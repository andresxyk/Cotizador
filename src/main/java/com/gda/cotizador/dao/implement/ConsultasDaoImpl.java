package com.gda.cotizador.dao.implement;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dao.mapper.ConvenioMapper;
import com.gda.cotizador.dao.mapper.ExamenConfigMapper;
import com.gda.cotizador.dao.mapper.PerfilMapper;
import com.gda.cotizador.dao.mapper.SucursalMapper;
import com.gda.cotizador.dao.mapper.db.EConvenioDetalleMapper;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.db.EConvenioDetalleDto;
import com.gda.cotizador.dto.requestConvenio.ConvenioDto;
import com.gda.cotizador.dto.requestConvenio.FiltroDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;

@Repository("consultasDaoImpl")
public class ConsultasDaoImpl extends JdbcDaoSupport implements IConsultasDao{
	
	
	@Autowired 
	DataSource dataSource;
	
	@Autowired
	Environment env;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<ConvenioDto> getListConvenioDto(FiltroDto filtro){
		List<ConvenioDto> list;		
		logger.info("ejecutando getListConvenioDto");
		logger.info(filtro.toString());
		String complemento = "";
		if(filtro.getCconvenio() != null && filtro.getCconvenio()>-1) {
			complemento = "cc.cconvenio = "+filtro.getCconvenio()+"\r\n";
		}else {
			complemento = "cc.sconvenio like '%"+filtro.getSconvenio()+"%'\r\n";
		}
		String query = "select cc.cconvenio, cc.sconvenio, cc.ctipoconvenio, ctc.cdescripciontipoconvenio\r\n"
				+ "from cotizador.c_convenio cc\r\n"
				+ "inner join cotizador.c_tipo_convenio ctc on cc.ctipoconvenio = ctc.ctipoconvenio\r\n"
				+ "where "+complemento ;
		list = this.getJdbcTemplate().query(query, new Object[] {}, new ConvenioMapper());		
		return list;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<ExamenConfigDto> getListSearchExamenDto(com.gda.cotizador.dto.requestExamen.FiltroDto filtro){
		List<ExamenConfigDto> list;
		logger.info("ejecutando getListSearchExamenDto");	
		logger.info(filtro.toString());
		String complemento = "";
		if(filtro.getSexamen()!=null) {
			if(filtro.getSexamen().length()>0) {
				complemento = "and ce.sexamen like '%"+filtro.getSexamen()+"%' ";
			}
		}
		String query = "select elcd.cexamen, ce.sexamen, elcd.mprecio, eec.scondicionpreanalitica,\r\n"
				+ "eec.blunes, eec.bmartes, eec.bmiercoles, eec.bjueves, eec.bviernes, eec.bsabado,\r\n"
				+ "eec.bdomingo, eec.utiemporespuestadiasprint, elcd.mpreciosiniva, ce.cdepartamento, cd.sdepartamento	\r\n"
				+ "from cotizador.e_lista_corporativa_detalle elcd\r\n"
				+ "inner join cotizador.c_examen ce on elcd.cexamen = ce.cexamen\r\n"
				+ "inner join cotizador.e_convenio ec on ec.clistacorporativa = elcd.clistacorporativa\r\n"
				+ "inner join cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen\r\n"
				+ "inner join cotizador.c_departamento cd on ce.cdepartamento = cd.cdepartamento\r\n"
				+ "where ec.cconvenio = ? \r\n"
				+ complemento;
		list = this.getJdbcTemplate().query(query, new Object[] {filtro.getCconvenio()}, new ExamenConfigMapper());		
		return list;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<ExamenConfigDto> getListSearchExamenDto(Integer cexamen, Integer cconvenio){
		List<ExamenConfigDto> list;
		logger.info("ejecutando getListSearchExamenDto");	
		logger.info(cexamen);
		logger.info(cconvenio);
		String query = "select elcd.cexamen, ce.sexamen, elcd.mprecio, eec.scondicionpreanalitica,\r\n"
				+ "eec.blunes, eec.bmartes, eec.bmiercoles, eec.bjueves, eec.bviernes, eec.bsabado,\r\n"
				+ "eec.bdomingo, eec.utiemporespuestadiasprint , elcd.mpreciosiniva, ce.cdepartamento, cd.sdepartamento	\r\n"
				+ "from cotizador.e_lista_corporativa_detalle elcd\r\n"
				+ "inner join cotizador.c_examen ce on elcd.cexamen = ce.cexamen\r\n"
				+ "inner join cotizador.e_convenio ec on ec.clistacorporativa = elcd.clistacorporativa\r\n"
				+ "inner join cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen\r\n"
				+ "inner join cotizador.c_departamento cd on ce.cdepartamento = cd.cdepartamento\r\n"
				+ "where ce.cexamen = ?\r\n"
				+ "and ec.cconvenio = ? " ;
		list = this.getJdbcTemplate().query(query, new Object[] {cexamen,cconvenio}, new ExamenConfigMapper());		
		return list;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<SucursalDto> getListSearchSucursalDto(com.gda.cotizador.dto.requestSucursal.FiltroDto filtro, Integer cmarca){
		List<SucursalDto> list;
		logger.info("ejecutando getListSearchSucursalDto");	
		logger.info(filtro.toString());
		String complemento = "";
		if(filtro.getCsucursal()!="") {
			complemento += "and csucursal in ("+filtro.getCsucursal()+") \r\n";
		}
		if(filtro.getSsucursal()!="") {
			complemento += "and snombresucursal like '%"+filtro.getSsucursal()+"%' \r\n";
		}
		
		String query = "select csucursal, ssucursal, snombresucursal \r\n"
				+ "from cotizador.c_sucursal\r\n"
				+ "where cmarca = ?\r\n"
				+ complemento;
		list = this.getJdbcTemplate().query(query, new Object[] {cmarca}, new SucursalMapper());		
		return list;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<EConvenioDetalleDto> getListEConvenioDetalle(Integer cconvenio, Integer cexamen){
		List<EConvenioDetalleDto> list;
		logger.info("ejecutando getListEConvenioDetalle");
		String query = "select * from cotizador.e_convenio_detalle \r\n"
				+ "where cconvenio = ?\r\n"
				+ "and cexamen = ?" ;
		list = this.getJdbcTemplate().query(query, new Object[] {cconvenio,cexamen}, new EConvenioDetalleMapper());		
		return list;
	}
	@Override
	public Integer insertTOrdenSucursalCotizacion(SucursalDto dto)throws Exception{
		logger.info("entra insertTOrdenSucursalCotizacion");
		
		Integer insert = 0;
		return insert;
	}
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
	
}
