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
import com.gda.cotizador.dao.mapper.db.EConvenioDetalleMapper;
import com.gda.cotizador.dto.ExamenConfigDto;
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
		String complemento = "cec.marca = " + filtro.getCmarca() + " and ";
		if (filtro.getCconvenio() > 0 || filtro.getSconvenio().isEmpty()) {
			if (filtro.getCconvenio() != null && filtro.getCconvenio() > -1) {
				complemento = "cc.cconvenio = " + filtro.getCconvenio() + "\r\n";
			} else {
				complemento = "cc.sconvenio like '%" + filtro.getSconvenio() + "%'\r\n";
			}
			
			String query = "SELECT cc.cconvenio, cc.sconvenio, cc.ctipoconvenio, ctc.cdescripciontipoconvenio, cec.marca\r\n"
					+ "FROM cotizador.c_convenio cc\r\n"
					+ "INNER JOIN cotizador.c_tipo_convenio ctc on cc.ctipoconvenio = ctc.ctipoconvenio\r\n"
					+ "INNER JOIN cotizador.e_convenio cec ON cec.cconvenio = cc.cconvenio \r\n"  
					+ "WHERE " + complemento;
			list = jdbcTemplate.query(query, new Object[] {}, new ConvenioMapper());
		}
		return list;

	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ExamenConfigDto> getListSearchExamenDto(com.gda.cotizador.dto.requestExamen.FiltroExamenDto filtro) {
		List<ExamenConfigDto> list;
		String complemento = "";
		
			if (filtro.getSexamen() != null) {
				if (filtro.getSexamen().length() > 0) {
					complemento = "and ce.sexamen like '%" + filtro.getSexamen() + "%' ";
				}
			}
			if (filtro.getSexamenweb() != null) {
				if (filtro.getSexamenweb().length() > 0) {
					complemento = "and ce.sexamenweb like '%" + filtro.getSexamenweb() + "%' ";
				}
			}
		
		String query = "select \r\n" + "elcd.cexamen,\r\n" + "ce.sexamen,\r\n" + " ce.sexamenweb,\r\n"
				+ "elcd.mprecio,\r\n" + "eec.scondicionpreanalitica,\r\n" + "eec.blunes,\r\n" + "eec.bmartes,\r\n"
				+ "eec.bmiercoles,\r\n" + "eec.bjueves,\r\n" + "eec.bviernes,\r\n" + "eec.bsabado,\r\n"
				+ "eec.bdomingo,\r\n" + "eec.utiemporespuestadiasprint,\r\n" + "elcd.mpreciosiniva,\r\n"
				+ "ce.cdepartamento,\r\n" + "cd.sdepartamento\r\n"
				+ "from cotizador.e_lista_corporativa_detalle elcd\r\n" + "inner join cotizador.c_examen ce\r\n"
				+ "on elcd.cexamen = ce.cexamen\r\n" + "inner join cotizador.c_lista_corporativa clc\r\n"
				+ "on clc.clistacorporativa = elcd.clistacorporativa\r\n" + "inner join cotizador.e_convenio ec\r\n"
				+ "on ec.clistacorporativa = elcd.clistacorporativa\r\n"
				+ "inner join cotizador.e_examen_configuracion eec\r\n" + "on ce.cexamen = eec.cexamen\r\n"
				+ "inner join cotizador.c_departamento cd\r\n" + "on ce.cdepartamento = cd.cdepartamento\r\n"
				+ "where ec.cconvenio = ? \r\n" + "and clc.clistacorporativa in (\r\n"
				+ env.getProperty("list.clistacorporativa.marca") + ")\r\n" + complemento;
		list = jdbcTemplate.query(query, new Object[] { filtro.getCconvenio() }, new ExamenConfigMapper());
		
		logger.info(query);
		
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ExamenConfigDto> getListSearchExamenDto(Integer cexamen, Integer cconvenio) {
		List<ExamenConfigDto> list;

		String query = "select elcd.cexamen, ce.sexamen, ce.sexamenweb, elcd.mprecio, eec.scondicionpreanalitica,\r\n"
				+ "eec.blunes, eec.bmartes, eec.bmiercoles, eec.bjueves, eec.bviernes, eec.bsabado,\r\n"
				+ "eec.bdomingo, eec.utiemporespuestadiasprint , elcd.mpreciosiniva, ce.cdepartamento, cd.sdepartamento	\r\n"
				+ "from cotizador.e_lista_corporativa_detalle elcd\r\n"
				+ "inner join cotizador.c_examen ce on elcd.cexamen = ce.cexamen\r\n"
				+ "inner join cotizador.e_convenio ec on ec.clistacorporativa = elcd.clistacorporativa\r\n"
				+ "inner join cotizador.e_examen_configuracion eec on ce.cexamen = eec.cexamen\r\n"
				+ "inner join cotizador.c_departamento cd on ce.cdepartamento = cd.cdepartamento\r\n"
				+ "where ce.cexamen = ?\r\n" + "and ec.cconvenio = ? ";
		list = jdbcTemplate.query(query, new Object[] { cexamen, cconvenio }, new ExamenConfigMapper());
		return list;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<SucursalDto> getListSearchSucursalDto(com.gda.cotizador.dto.requestSucursal.FiltroSucursalDto filtro,
			Integer cmarca) {
		List<SucursalDto> list;
		String complemento = "";
		if (filtro.getCsucursal() != "") {
			complemento += "and csucursal in (" + filtro.getCsucursal() + ") \r\n";
		}
		if (filtro.getSsucursal() != "") {
			complemento += "and snombresucursal like '%" + filtro.getSsucursal() + "%' \r\n";
		}

		String query = "select csucursal, ssucursal, snombresucursal \r\n" + "from cotizador.c_sucursal\r\n"
				+ "where cmarca = ?\r\n" + complemento;
		list = jdbcTemplate.query(query, new Object[] { cmarca }, new SucursalMapper());
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
			complemento += "and cp.cperfil in (" + filtro.getCperfil() + ") \r\n";
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
