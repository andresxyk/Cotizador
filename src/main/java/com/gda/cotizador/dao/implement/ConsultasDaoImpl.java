package com.gda.cotizador.dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dao.mapper.ExamenConfigMapper;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.requestExamen.ConvenioDto;
import com.gda.cotizador.dto.requestExamen.FiltroExamenConveniosDto;

import jakarta.annotation.PostConstruct;

@Repository("consultasDaoImpl")
public class ConsultasDaoImpl extends JdbcDaoSupport implements IConsultasDao {
  @Autowired
  DataSource dataSource;
  
  @Autowired
  Environment env;
  
  @Autowired
  @Qualifier("jdbcMaster")
  private JdbcTemplate jdbcTemplate;
  
  @PostConstruct
  private void initialize() {
    setDataSource(this.dataSource);
  }
	
	public List<ExamenConfigDto> getListSearchExamenConveniosDto(FiltroExamenConveniosDto filtro, Integer cmarca) {
	    String complemento = "";
	    String complementoperfiles = "";
	    List<Integer> listConvenios = new ArrayList<>();
	    for (ConvenioDto convenioDto : filtro.getCconvenios())
	      listConvenios.add(convenioDto.getConvenio()); 
	    String convenios = String.join(",", (CharSequence[])listConvenios.stream().map(Object::toString).toArray(x$0 -> new String[x$0]));
	    if (filtro.getCexamen().intValue() > 0) {
	      complemento = " and ce.cexamen = " + filtro.getCexamen() + " ";
	      complementoperfiles = " and cp.cperfil = " + filtro.getCexamen() + " ";
	    } 
	    if (filtro.getSexamen() != null && 
	      filtro.getSexamen().length() > 0) {
	      complemento = " and ce.sexamen like '%" + filtro.getSexamen().replaceAll(" ", "%") + "%' ";
	      complementoperfiles = " and sperfil like '%" + filtro.getSexamen().replaceAll(" ", "%") + "%' ";
	    } 
	    if (filtro.getSexamenweb() != null && 
	      filtro.getSexamenweb().length() > 0) {
	      complemento = " and ce.sexamenweb like '%" + filtro.getSexamenweb().replaceAll(" ", "%") + "%' ";
	      complementoperfiles = " and sperfil like '%" + filtro.getSexamenweb().replaceAll(" ", "%") + "%' ";
	    } 
	    this.logger.info(getQueryFilter(cmarca.intValue(), complemento, complementoperfiles, Boolean.valueOf(true), convenios));
	    List<ExamenConfigDto> list = this.jdbcTemplate.query(getQueryFilter(cmarca.intValue(), complemento, complementoperfiles, Boolean.valueOf(true), convenios), new Object[0], (RowMapper)new ExamenConfigMapper());
	    return list;
	  }
	
	 private String getQueryFilter(int cmarca, String complemento, String complementoperfiles, Boolean isMultiConvenio, String convenios) {
		    String queryConvenio = isMultiConvenio.booleanValue() ? ("ec.cconvenio in (" + convenios + ")") : ("ec.cconvenio = " + convenios);
		    return "SELECT elcd.cexamen,\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ce.sexamen,\t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ce.sexamenweb,\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       elcd.mprecio mprecio, \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.scondicionpreanalitica,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.blunes,  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.bmartes, \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.bmiercoles, \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.bjueves,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.bviernes, \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.bsabado,  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.bdomingo, \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       eec.utiemporespuestadiasprint,      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       elcd.mpreciosiniva,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ce.cdepartamento,      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       cd.sdepartamento,      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ce.ctipocomercial,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ctc.sdescripcioncomercial, \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       clc.clistacorporativa,\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ecd.mpreciofacturarconiva mprecioconvenio,\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       null incluye, \t\t\t\t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ce.brequierecita,\t\t\t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ec.cconvenio\t\t\t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \r\nFROM cotizador.e_lista_corporativa_detalle elcd \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_examen ce on elcd.cexamen = ce.cexamen       \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_lista_corporativa clc on clc.clistacorporativa = elcd.clistacorporativa \t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_convenio ec on ec.clistacorporativa = elcd.clistacorporativa \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_departamento cd   on ce.cdepartamento = cd.cdepartamento      \t\t\t   \t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_tipo_comercial ctc on ctc.ctipocomercial = ce.ctipocomercial  \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_convenio_detalle ecd on ecd.cconvenio = ec.cconvenio  and ce.cexamen = ecd.cexamen \t\t\t\t\t\t\t\r\nWHERE " + queryConvenio + " and ec.cmarca = " + cmarca + "  and clc.clistacorporativa in (" + this.env
		      
		      .getProperty("list.clistacorporativa.marca") + " )  \t\r\n" + complemento + "--EXAMEN EN PERFIL   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\nUNION     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\nSELECT cp.cperfil,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       cp.sperfil,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       cp.sperfil,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       ecp.mpreciofacturarconiva mprecio,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       '' scondicionpreanalitica,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       true blunes,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       true bmartes,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n       true bmiercoles,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     true bjueves,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     true bviernes,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     true bsabado,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n    true bdomingo,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     max(utiemporespuestadiasprint) utiemporespuestadiasprint, ecp.mpreciofacturarsiniva,   \t\t\t\t\t\t\t\t\t\t\t\r\n     77 cdepartamento,       \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     'PERFIL' sdepartamento,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     ctc.ctipocomercial,       \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     sdescripcioncomercial,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     clc.clistacorporativa  ,\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     ecp.mpreciofacturarconiva mprecioconvenio,\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     array_to_string(array_agg(ce.sexamen order by ce.sexamen), ';') incluye,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n     false brequierecita,  \t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                        \r\n       ec.cconvenio\t\t\t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \r\nFROM cotizador.c_perfil cp INNER JOIN cotizador.e_convenio_perfil ecp on ecp.cperfil = cp.cperfil   \t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_perfil_examen epe on epe.cperfil = cp.cperfil   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_examen ce on epe.cexamen = ce.cexamen   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen        \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_convenio ec on ecp.cconvenio = ec.cconvenio   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_lista_corporativa clc on clc.clistacorporativa = ec.clistacorporativa\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_tipo_comercial ctc on ctc.ctipocomercial = cp.ctipocomercial  \t\t\t\t\t\t\t\t\t\t\t\t\t\r\nWHERE " + queryConvenio + " and ec.cmarca = " + cmarca + "  and clc.clistacorporativa in (" + this.env
		      
		      .getProperty("list.clistacorporativa.marca") + " ) \r\n    and cp.blistapublico = true      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n    and ec.cestadoregistro = 22        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n" + complemento + "group by cp.cperfil,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  cp.sperfil,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  cp.sperfil,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ecp.mpreciofacturarconiva,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ecp.mpreciofacturarsiniva,  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ctc.ctipocomercial,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  sdescripcioncomercial,        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  clc.clistacorporativa,      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ecp.mpreciofacturarconiva, \t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ec.cconvenio\t   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n--NOMBRE PERFIL        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\nUNION     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\nSELECT  cp.cperfil,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n cp.sperfil,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n cp.sperfil,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n ecp.mpreciofacturarconiva mprecio,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n '' scondicionpreanalitica,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n true blunes,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n true bmartes,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n true bmiercoles,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n true bjueves,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n true bviernes,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n true bsabado,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n true bdomingo,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n max(utiemporespuestadiasprint) utiemporespuestadiasprint, ecp.mpreciofacturarsiniva,   \t\t\t\t\t\t\t\t\t\t\t\t\r\n 77 cdepartamento,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n 'PERFIL' sdepartamento,    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n ctc.ctipocomercial,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n sdescripcioncomercial,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n clc.clistacorporativa,\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n ecp.mpreciofacturarconiva mprecioconvenio,\t\t\t\t\t\t   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n array_to_string(array_agg(ce.sexamen order by ce.sexamen), ';') incluye, \t\t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n false brequierecita,  \t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                        \r\n ec.cconvenio\t\t\t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\r\nFROM cotizador.c_perfil cp INNER JOIN cotizador.e_convenio_perfil ecp on ecp.cperfil = cp.cperfil        \t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_perfil_examen epe on epe.cperfil = cp.cperfil   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_examen ce on epe.cexamen = ce.cexamen   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen        \t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.e_convenio ec on ecp.cconvenio = ec.cconvenio   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_lista_corporativa clc on clc.clistacorporativa = ec.clistacorporativa   \t\t\t\t\t\t\t\t\t\t\r\n INNER JOIN cotizador.c_tipo_comercial ctc on ctc.ctipocomercial = cp.ctipocomercial  \t\t\t\t\t\t\t\t\t\t\t\t\t\r\nWHERE " + queryConvenio + " and ec.cmarca = " + cmarca + "  and clc.clistacorporativa in (" + this.env
		      
		      .getProperty("list.clistacorporativa.marca") + " )  \t\r\n    and cp.blistapublico = true      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n    and ec.cestadoregistro = 22 \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n" + complementoperfiles + "    group by cp.cperfil,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  cp.sperfil,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  cp.sperfil,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ecp.mpreciofacturarconiva,     \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ecp.mpreciofacturarsiniva,  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ctc.ctipocomercial,   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  sdescripcioncomercial,        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  clc.clistacorporativa,\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ecp.mpreciofacturarconiva,\t   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n  ec.cconvenio\t   \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n    order by 1,2   ";
		  }

}
