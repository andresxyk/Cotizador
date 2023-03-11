package com.gda.cotizador.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dao.mapper.AccesoClienteMapper;
import com.gda.cotizador.dao.mapper.ConvenioMapper;
import com.gda.cotizador.dao.mapper.ExamenConfigMapper;
import com.gda.cotizador.dao.mapper.PerfilMapper;
import com.gda.cotizador.dao.mapper.SucursalMapper;
import com.gda.cotizador.dao.mapper.db.EConvenioDetalleMapper;
import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.cotizasion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.db.EConvenioDetalleDto;
import com.gda.cotizador.dto.requestConvenio.ConvenioDto;
import com.gda.cotizador.dto.requestConvenio.FiltroDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;
import com.gda.cotizador.dto.seguridad.UssersDTO;
import com.gda.cotizador.utils.EdbExecutor;

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
	
	@Autowired
    @Qualifier("jdbcMaster")
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Connection getConnectionJDBC() throws Exception{
		logger.debug("ejecutando getConnectionJDBC");
		EdbExecutor edbExecutor;
		edbExecutor = new EdbExecutor();
		return edbExecutor.getConnetion(env.getProperty("spring.datasource.jdbc-url").replace("postgresql", "edb"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
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
	
	
}
