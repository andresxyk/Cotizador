package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CExamenDto;

public class CExamenMapper implements RowMapper<CExamenDto>{

	@Override
	public CExamenDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CExamenDto dto = new CExamenDto();
		dto.setCexamen(rs.getInt("cexamen"));
		dto.setSexamen(rs.getString("sexamen"));
		dto.setCtipocomercial(rs.getInt("ctipocomercial"));
		dto.setCclasificacioncomercial(rs.getInt("cclasificacioncomercial"));
		dto.setCdepartamento(rs.getInt("cdepartamento"));
		dto.setCclasificacionmedico(rs.getInt("cclasificacionmedico"));
		dto.setSnemonico(rs.getString("snemonico"));
		dto.setBlistapublico(rs.getBoolean("blistapublico"));
		dto.setUserid(rs.getInt("userid"));
		dto.setUlaboratoriogabinete(rs.getInt("ulaboratoriogabinete"));
		dto.setCmarca(rs.getInt("cmarca"));
		dto.setSexamenweb(rs.getString("sexamenweb"));
		dto.setUpatologia(rs.getInt("upatologia"));
		dto.setUestaciontomatlalpan(rs.getInt("uestaciontomatlalpan"));
		dto.setUmuestraetiqueta(rs.getInt("umuestraetiqueta"));
		dto.setBentregausb(rs.getBoolean("bentregausb"));
		dto.setBregistrarconsumo(rs.getBoolean("bregistrarconsumo"));
		dto.setCexamenazteca(rs.getInt("cexamenazteca"));
		dto.setSexamenlabcore(rs.getString("sexamenlabcore"));
		dto.setUenvioecatepec(rs.getInt("uenvioecatepec"));
		dto.setSexamenlabnexus(rs.getString("sexamenlabnexus"));
		dto.setSidentificadorareaproceso(rs.getString("sidentificadorareaproceso"));
		dto.setCclaveproductoserviciosat(rs.getInt("cclaveproductoserviciosat"));
		dto.setCclaveunidad(rs.getInt("cclaveunidad"));
		dto.setBdatospreanaliticos(rs.getBoolean("bdatospreanaliticos"));
		dto.setScodigolis(rs.getString("scodigolis"));
		dto.setScodigogda(rs.getString("scodigogda"));
		dto.setPurgencia(rs.getInt("purgencia"));
		dto.setCdepartamentonuevo(rs.getInt("cdepartamentonuevo"));
		dto.setUexamenunico(rs.getString("uexamenunico"));
		dto.setSexamenunico(rs.getString("sexamenunico"));
		dto.setCexamenproceso(rs.getInt("cexamenproceso"));
		dto.setUvolumenmaximo(rs.getInt("uvolumenmaximo"));
		dto.setSsinonimoexterno(rs.getString("ssinonimoexterno"));
		dto.setSwebservicesconsultaresultado(rs.getString("swebservicesconsultaresultado"));
		dto.setCexamenprocesomoreira(rs.getInt("cexamenprocesomoreira"));
		dto.setBexamenprocesomoreira(rs.getBoolean("bexamenprocesomoreira"));
				
		return dto;
	}

}
