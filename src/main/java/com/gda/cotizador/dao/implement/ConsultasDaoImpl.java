package com.gda.cotizador.dao.implement;

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
import com.gda.cotizador.dao.mapper.BusquedaPerfilMapper;
import com.gda.cotizador.dao.mapper.ConvenioMapper;
import com.gda.cotizador.dao.mapper.ExamenConfigMapper;
import com.gda.cotizador.dao.mapper.MarcaMapper;
import com.gda.cotizador.dao.mapper.SucursalMapper;
import com.gda.cotizador.dao.mapper.TipoComercialMapper;
import com.gda.cotizador.dao.mapper.db.EConvenioDetalleMapper;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.comercial.FiltroComercialDto;
import com.gda.cotizador.dto.comercial.FiltroTipoComercialDto;
import com.gda.cotizador.dto.comercial.TipoComercialDto;
import com.gda.cotizador.dto.db.EConvenioDetalleDto;
import com.gda.cotizador.dto.requestConvenio.ConvenioDto;
import com.gda.cotizador.dto.requestConvenio.FiltroConvenioDto;
import com.gda.cotizador.dto.requestMarca.MarcaDto;
import com.gda.cotizador.dto.requestPerfil.PerfilDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;

@Repository("consultasDaoImpl")
public class ConsultasDaoImpl extends JdbcDaoSupport implements IConsultasDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	Environment env;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public List<ConvenioDto> getListConvenioDto(FiltroConvenioDto filtro) {
		List<ConvenioDto> list = null;
		String complemento = "ec.cmarca = " + filtro.getCmarca() + " and ";
		// if (filtro.getCconvenio() > 0 || filtro.getSconvenio().isEmpty()) {
		if (filtro.getCconvenio() != null && filtro.getCconvenio() > -1) {
			complemento += "cc.cconvenio = " + filtro.getCconvenio() + "\r\n";
		} else {
			complemento += "cc.sconvenio like '%" + filtro.getSconvenio() + "%'\r\n";
		}

		String query = "select cc.cconvenio, cc.sconvenio, cc.ctipoconvenio, ctc.cdescripciontipoconvenio, ec.cmarca\r\n"
				+ "FROM cotizador.c_convenio cc\r\n"
				+ "INNER JOIN cotizador.c_tipo_convenio ctc on cc.ctipoconvenio = ctc.ctipoconvenio\r\n"
				+ "inner join cotizador.e_convenio ec on ec.cconvenio = cc.cconvenio \r\n" + "WHERE " + complemento;
		list = jdbcTemplate.query(query, new Object[] {}, new ConvenioMapper());
		// }
		return list;

	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ExamenConfigDto> getListSearchExamenDto(com.gda.cotizador.dto.requestExamen.FiltroExamenDto filtro,Integer cmarca) {
		List<ExamenConfigDto> list;
		String complemento = "";
		String complementoperfiles = "";

		
		if (filtro.getCexamen() > 0) {
			complemento = " and ce.cexamen = " + filtro.getCexamen() + " ";
			complementoperfiles = " and cp.cperfil = " + filtro.getCexamen() + " ";
		}
		
		if (filtro.getSexamen() != null) {
			if (filtro.getSexamen().length() > 0) {
				complemento = " and ce.sexamen like '%" + filtro.getSexamen().replaceAll(" ", "%") + "%' ";
				complementoperfiles = " and sperfil like '%" + filtro.getSexamen().replaceAll(" ", "%") + "%' ";
			}
		}
		if (filtro.getSexamenweb() != null) {
			if (filtro.getSexamenweb().length() > 0) {
				complemento = " and ce.sexamenweb like '%" + filtro.getSexamenweb().replaceAll(" ", "%") + "%' ";
				complementoperfiles = " and sperfil like '%" + filtro.getSexamenweb().replaceAll(" ", "%") + "%' ";
			}
		}
		
		logger.info(this.getQueryFilter(cmarca.intValue(), complemento, complementoperfiles));
		list = jdbcTemplate.query(this.getQueryFilter(cmarca.intValue(), complemento, complementoperfiles), new Object[] { filtro.getCconvenio(), filtro.getCconvenio(), filtro.getCconvenio() }, new ExamenConfigMapper());
		return list;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public List<ExamenConfigDto> getListSearchExamenDtoComercial(FiltroComercialDto filtro,Integer cmarca) {
		List<ExamenConfigDto> list;
		String complemento = "";

		if (filtro.getCtipocomercial() != null) {
			if (filtro.getCtipocomercial() > 0) {
				complemento = " and ctc.ctipocomercial = " + filtro.getCtipocomercial() + " ";
			}
		}						
		logger.info(this.getQueryFilter(cmarca.intValue(), complemento, complemento));
		list = jdbcTemplate.query(this.getQueryFilter(cmarca.intValue(), complemento, complemento), new Object[] { filtro.getCconvenio(), filtro.getCconvenio(), filtro.getCconvenio() }, new ExamenConfigMapper());
		return list;
	}
	
	private String getQueryFilter(int cmarca, String complemento, String complementoperfiles) {
		return  "SELECT elcd.cexamen,																													\r\n" + 
		  		"       ce.sexamen,									    																				\r\n" + 
		  		"       ce.sexamenweb,																													\r\n" + 
		  		"       elcd.mprecio mprecio, 																											\r\n" + 
		  		"       eec.scondicionpreanalitica,   																									\r\n" + 
		  		"       eec.blunes,  																													\r\n" + 
		  		"       eec.bmartes, 																													\r\n" + 
		  		"       eec.bmiercoles, 																												\r\n" + 
		  		"       eec.bjueves,   																													\r\n" + 
		  		"       eec.bviernes, 																													\r\n" + 
		  		"       eec.bsabado,  																													\r\n" + 
		  		"       eec.bdomingo, 																													\r\n" + 
		  		"       eec.utiemporespuestadiasprint,      																							\r\n" + 
		  		"       elcd.mpreciosiniva,    																											\r\n" + 
		  		"       ce.cdepartamento,      																											\r\n" + 
		  		"       cd.sdepartamento,      																											\r\n" + 
		  		"       ce.ctipocomercial,     																											\r\n" + 
		  		"       ctc.sdescripcioncomercial, 																										\r\n" + 
		  		"       clc.clistacorporativa,																											\r\n" + 
		  		"       ecd.mpreciofacturarconiva mprecioconvenio,																						\r\n" + 
		  		"       null incluye 				  																									\r\n" + 
		  		"FROM cotizador.e_lista_corporativa_detalle elcd 																						\r\n" + 
		  		" INNER JOIN cotizador.c_examen ce on elcd.cexamen = ce.cexamen       																	\r\n" + 
		  		" INNER JOIN cotizador.c_lista_corporativa clc on clc.clistacorporativa = elcd.clistacorporativa 										\r\n" + 
		  		" INNER JOIN cotizador.e_convenio ec on ec.clistacorporativa = elcd.clistacorporativa 													\r\n" + 
		  		" INNER JOIN cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen 															\r\n" + 
		  		" INNER JOIN cotizador.c_departamento cd   on ce.cdepartamento = cd.cdepartamento      			   										\r\n" + 
		  		" INNER JOIN cotizador.c_tipo_comercial ctc on ctc.ctipocomercial = ce.ctipocomercial  													\r\n" + 
		  		" INNER JOIN cotizador.e_convenio_detalle ecd on ecd.cconvenio = ec.cconvenio  and ce.cexamen = ecd.cexamen 							\r\n" + 
		  		"WHERE ec.cconvenio = ? and ec.cmarca = " + cmarca + "  and clc.clistacorporativa in ("+ env.getProperty("list.clistacorporativa.marca") +" )  	\r\n" + 
		  			complemento +																															 
		  		"--EXAMEN EN PERFIL   																													\r\n" + 
		  		"UNION     																															\r\n" + 
		  		"SELECT cp.cperfil,   																													\r\n" + 
		  		"       cp.sperfil,   																													\r\n" + 
		  		"       cp.sperfil,   																													\r\n" + 
		  		"       ecp.mpreciofacturarconiva mprecio,   																							\r\n" + 
		  		"       '' scondicionpreanalitica,   																									\r\n" + 
		  		"       true blunes,    																												\r\n" + 
		  		"       true bmartes,   																												\r\n" + 
		  		"       true bmiercoles,   																												\r\n" + 
		  		"     true bjueves,    																													\r\n" + 
		  		"     true bviernes,   																													\r\n" + 
		  		"     true bsabado,    																													\r\n" + 
		  		"    true bdomingo,   																													\r\n" + 
		  		"     max(utiemporespuestadiasprint) utiemporespuestadiasprint, ecp.mpreciofacturarsiniva,   											\r\n" + 
		  		"     77 cdepartamento,       																											\r\n" + 
		  		"     'PERFIL' sdepartamento,   																										\r\n" + 
		  		"     ctc.ctipocomercial,       																										\r\n" + 
		  		"     sdescripcioncomercial,     																										\r\n" + 
		  		"     clc.clistacorporativa  ,																											\r\n" + 
		  		"     ecp.mpreciofacturarconiva mprecioconvenio,																						\r\n" + 
		  		"     array_to_string(array_agg(ce.sexamen order by ce.sexamen), ';') incluye   														\r\n" + 
		  		"FROM cotizador.c_perfil cp INNER JOIN cotizador.e_convenio_perfil ecp on ecp.cperfil = cp.cperfil   									\r\n" + 
		  		" INNER JOIN cotizador.e_perfil_examen epe on epe.cperfil = cp.cperfil   																\r\n" + 
		  		" INNER JOIN cotizador.c_examen ce on epe.cexamen = ce.cexamen   																		\r\n" + 
		  		" INNER JOIN cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen        													\r\n" + 
		  		" INNER JOIN cotizador.e_convenio ec on ecp.cconvenio = ec.cconvenio   																	\r\n" + 
		  		" INNER JOIN cotizador.c_lista_corporativa clc on clc.clistacorporativa = ec.clistacorporativa											\r\n" + 
		  		" INNER JOIN cotizador.c_tipo_comercial ctc on ctc.ctipocomercial = cp.ctipocomercial  													\r\n" + 
		  		"WHERE ec.cconvenio = ? and ec.cmarca = " + cmarca + "  and clc.clistacorporativa in ("+ env.getProperty("list.clistacorporativa.marca") +" ) \r\n" + 
		  		"    and cp.blistapublico = true      																									\r\n" + 
		  		"    and ec.cestadoregistro = 22        																								\r\n" + 
		  			complemento  +
		  		"group by cp.cperfil,     																												\r\n" + 
		  		"  cp.sperfil,     																														\r\n" + 
		  		"  cp.sperfil,     																														\r\n" + 
		  		"  ecp.mpreciofacturarconiva,     																										\r\n" + 
		  		"  ecp.mpreciofacturarsiniva,  																											\r\n" + 
		  		"  ctc.ctipocomercial,   																												\r\n" + 
		  		"  sdescripcioncomercial,        																										\r\n" + 
		  		"  clc.clistacorporativa,      																											\r\n" + 
		  		"  ecp.mpreciofacturarconiva 	  																										\r\n" + 
		  		"--NOMBRE PERFIL        																												\r\n" + 
		  		"UNION     																															\r\n" + 
		  		"SELECT  cp.cperfil,    																												\r\n" + 
		  		" cp.sperfil,    																														\r\n" + 
		  		" cp.sperfil,    																														\r\n" + 
		  		" ecp.mpreciofacturarconiva mprecio,   																									\r\n" + 
		  		" '' scondicionpreanalitica,   																											\r\n" + 
		  		" true blunes,   																														\r\n" + 
		  		" true bmartes,   																														\r\n" + 
		  		" true bmiercoles,    																													\r\n" + 
		  		" true bjueves,   																														\r\n" + 
		  		" true bviernes,   																														\r\n" + 
		  		" true bsabado,   																														\r\n" + 
		  		" true bdomingo,   																														\r\n" + 
		  		" max(utiemporespuestadiasprint) utiemporespuestadiasprint, ecp.mpreciofacturarsiniva,   												\r\n" + 
		  		" 77 cdepartamento,   																													\r\n" + 
		  		" 'PERFIL' sdepartamento,    																											\r\n" + 
		  		" ctc.ctipocomercial,   																												\r\n" + 
		  		" sdescripcioncomercial,     																											\r\n" + 
		  		" clc.clistacorporativa,																												\r\n" + 
		  		" ecp.mpreciofacturarconiva mprecioconvenio,						   																	\r\n" + 
		  		" array_to_string(array_agg(ce.sexamen order by ce.sexamen), ';') incluye 		  														\r\n" + 				  						  		
		  		"FROM cotizador.c_perfil cp INNER JOIN cotizador.e_convenio_perfil ecp on ecp.cperfil = cp.cperfil        								\r\n" + 
		  		" INNER JOIN cotizador.e_perfil_examen epe on epe.cperfil = cp.cperfil   																\r\n" + 
		  		" INNER JOIN cotizador.c_examen ce on epe.cexamen = ce.cexamen   																		\r\n" + 
		  		" INNER JOIN cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen        													\r\n" + 
		  		" INNER JOIN cotizador.e_convenio ec on ecp.cconvenio = ec.cconvenio   																	\r\n" + 
		  		" INNER JOIN cotizador.c_lista_corporativa clc on clc.clistacorporativa = ec.clistacorporativa   										\r\n" + 
		  		" INNER JOIN cotizador.c_tipo_comercial ctc on ctc.ctipocomercial = cp.ctipocomercial  													\r\n" + 
		  		"WHERE ec.cconvenio = ? and ec.cmarca = " + cmarca + "  and clc.clistacorporativa in ("+ env.getProperty("list.clistacorporativa.marca") +" )  	\r\n" + 
		  		"    and cp.blistapublico = true      																									\r\n" + 
		  		"    and ec.cestadoregistro = 22 																										\r\n" + 
		  			complementoperfiles + 
		  		"    group by cp.cperfil,     																											\r\n" + 
		  		"  cp.sperfil,     																														\r\n" + 
		  		"  cp.sperfil,     																														\r\n" + 
		  		"  ecp.mpreciofacturarconiva,     																										\r\n" + 
		  		"  ecp.mpreciofacturarsiniva,  																											\r\n" + 
		  		"  ctc.ctipocomercial,   																												\r\n" + 
		  		"  sdescripcioncomercial,        																										\r\n" + 
		  		"  clc.clistacorporativa,																												\r\n" + 
		  		"  ecp.mpreciofacturarconiva	   																										\r\n" + 
		  		"    order by 1,2   "; 				
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ExamenConfigDto> getListSearchExamenDto(Integer cexamen, Integer cconvenio) {
		List<ExamenConfigDto> list;
		
		String query = 	"SELECT elcd.cexamen,																													\r\n" + 
				  		"       ce.sexamen,									    																				\r\n" + 
				  		"       ce.sexamenweb,																													\r\n" + 
				  		"       elcd.mprecio mprecio, 																											\r\n" + 
				  		"       eec.scondicionpreanalitica,   																									\r\n" + 
				  		"       eec.blunes,  																													\r\n" + 
				  		"       eec.bmartes, 																													\r\n" + 
				  		"       eec.bmiercoles, 																												\r\n" + 
				  		"       eec.bjueves,   																													\r\n" + 
				  		"       eec.bviernes, 																													\r\n" + 
				  		"       eec.bsabado,  																													\r\n" + 
				  		"       eec.bdomingo, 																													\r\n" + 
				  		"       eec.utiemporespuestadiasprint,      																							\r\n" + 
				  		"       elcd.mpreciosiniva,    																											\r\n" + 
				  		"       ce.cdepartamento,      																											\r\n" + 
				  		"       cd.sdepartamento,      																											\r\n" + 
				  		"       ce.ctipocomercial,     																											\r\n" + 
				  		"       ctc.sdescripcioncomercial, 																										\r\n" + 
				  		"       clc.clistacorporativa,																											\r\n" + 
				  		"       ecd.mpreciofacturarconiva mprecioconvenio,																						\r\n" + 
				  		"       null incluye, 				  																									\r\n" + 
				  		"       ce.brequierecita																												\r\n" + 
				  		"FROM cotizador.e_lista_corporativa_detalle elcd INNER JOIN cotizador.c_examen ce on elcd.cexamen = ce.cexamen       					\r\n" + 
				  		" INNER JOIN cotizador.c_lista_corporativa clc on clc.clistacorporativa = elcd.clistacorporativa 										\r\n" + 
				  		" INNER JOIN cotizador.e_convenio ec on ec.clistacorporativa = elcd.clistacorporativa 													\r\n" + 
				  		" INNER JOIN cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen 															\r\n" + 
				  		" INNER JOIN cotizador.c_departamento cd   on ce.cdepartamento = cd.cdepartamento      			   										\r\n" + 
				  		" INNER JOIN cotizador.c_tipo_comercial ctc on ctc.ctipocomercial = ce.ctipocomercial  													\r\n" + 
				  		" INNER JOIN cotizador.e_convenio_detalle ecd on ecd.cconvenio = ec.cconvenio  and ce.cexamen = ecd.cexamen 							\r\n" + 
				  		"WHERE ce.cexamen = ? and ec.cconvenio = ? and clc.clistacorporativa in ("+ env.getProperty("list.clistacorporativa.marca") +" )  		\r\n";
		list = jdbcTemplate.query(query, new Object[] { cexamen, cconvenio }, new ExamenConfigMapper());
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SucursalDto> getListSearchSucursalDto(com.gda.cotizador.dto.requestSucursal.FiltroSucursalDto filtro,
			Integer cmarca) {
		List<SucursalDto> list;
		String complemento = "";
		String campoCodigoPostal = "" ;
		if (filtro.getCsucursal() != "") {
			if (filtro.getCsucursal().contains("0")) {
				complemento = "";
			} else {
				complemento += "and csucursal in (" + filtro.getCsucursal() + ") \r\n";
			}
		}
		if (filtro.getSsucursal() != "") {
			complemento += "and snombresucursal like '%" + filtro.getSsucursal() + "%' \r\n";
		}

		String query = "SELECT csucursal, ssucursal, snombresucursal, nlatitud, nlongitud, cpostal\r\n" +
					   "FROM cotizador.c_sucursal					 						\r\n" +
				 	   "WHERE cmarca = ?													\r\n" + complemento;
		list = jdbcTemplate.query(query, new Object[] { cmarca }, new SucursalMapper());
		return list;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public List<TipoComercialDto> getListSearchTipoComercialDto(FiltroTipoComercialDto filtro,
			Integer cmarca) {
		List<TipoComercialDto> list;
		String complemento = "";
		if (filtro.getCtipocomercial() != "") {
			if (filtro.getCtipocomercial().contains("-1")) {
				complemento = "";
			} else {
				complemento += "where ctipocomercial in (" + filtro.getCtipocomercial() + ") \r\n";
			}
		}
		if (filtro.getSdescripcioncomercial() != "") {
			if(complemento=="") {
				complemento += "where sdescripcioncomercial like '%" + filtro.getSdescripcioncomercial() + "%' \r\n";
			}else {
				complemento += "and sdescripcioncomercial like '%" + filtro.getSdescripcioncomercial() + "%' \r\n";
			}
		}

		String query = "select * \r\n" + "from cotizador.c_tipo_comercial\r\n"
				+ complemento;
		list = jdbcTemplate.query(query, new Object[] { }, new TipoComercialMapper());
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<MarcaDto> getListSearchMarcaDto(com.gda.cotizador.dto.requestMarca.FiltroMarcaDto filtro) {
		List<MarcaDto> list;
		String complemento = "";
		if (filtro.getCmarca() != "") {
			complemento += "where cmarca in (" + filtro.getCmarca() + ") \r\n";
		}
		if (filtro.getSmarca() != "") {
			if (complemento != "") {
				complemento += "and smarca like '%" + filtro.getSmarca() + "%' \r\n";
			} else {
				complemento += "where smarca like '%" + filtro.getSmarca() + "%' \r\n";
			}
		}
		String query = "select cmarca, smarca \r\n" + "from cotizador.c_marca\r\n" + complemento;
		list = jdbcTemplate.query(query, new Object[] {}, new MarcaMapper());
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<com.gda.cotizador.dto.requestPerfil.PerfilDto> getListSearchPerfilDto(
			com.gda.cotizador.dto.requestPerfil.FiltroPerfilDto filtro, Integer cmarca) {
		List<PerfilDto> list;
		String complemento = "";
		if (filtro.getCperfil() != "") {
			if(filtro.getCperfil().contains("-1")) {
				complemento = "";
			}else {
			complemento += "and cp.cperfil in (" + filtro.getCperfil() + ") \r\n";
			}
		}
		if (filtro.getSperfil() != "") {
			complemento += "and cp.sperfil like '%" + filtro.getSperfil() + "%' \r\n";
		}
		String query = "select cp.cperfil, cp.sperfil from cotizador.c_perfil cp\r\n"
				+ "inner join cotizador.e_convenio_perfil ecp on cp.cperfil = ecp.cperfil\r\n"
				+ "inner join cotizador.c_convenio cc on cc.cconvenio = ecp.cconvenio\r\n" + "where cp.cmarca = ?\r\n"
				+ "and cp.blistapublico = true\r\n" + "and cc.ctipoconvenio = 24\r\n" + complemento;
		list = jdbcTemplate.query(query, new Object[] { cmarca }, new BusquedaPerfilMapper());
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<EConvenioDetalleDto> getListEConvenioDetalle(Integer cconvenio, Integer cexamen) {
		List<EConvenioDetalleDto> list;
		String query = "select * from cotizador.e_convenio_detalle \r\n" + "where cconvenio = ?\r\n"
				+ "and cexamen = ?";
		list = jdbcTemplate.query(query, new Object[] { cconvenio, cexamen }, new EConvenioDetalleMapper());
		return list;
	}
}
