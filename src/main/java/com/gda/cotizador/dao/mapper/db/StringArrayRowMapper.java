package com.gda.cotizador.dao.mapper.db;

import com.gda.cotizador.service.impl.dominio.ToolServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.jdbc.PgArray;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StringArrayRowMapper implements RowMapper<String[]> {
    final static Logger logger = LogManager.getLogger(ToolServiceImpl.class);
    @Override
    public String[] mapRow(ResultSet resultSet, int i) throws SQLException {
        try{
            PgArray pgArray = (PgArray) resultSet.getObject(1); // Ajusta la posición según tu consulta
            Object[] array = (Object[]) pgArray.getArray();
            String[] integerArray = new String[array.length];

            for (int j = 0; j < array.length; j++) {
                integerArray[j] = array[j].toString();
            }
            return integerArray;
        }catch (Exception ex){
            logger.error("Error al mappear la propiedad el array de csucursal");
            return new String[]{ "*" };
        }
    }
}


