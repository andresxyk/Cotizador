package com.gda.cotizador.dao.interfaz;

import java.sql.Connection;

public interface IConexionJasper {
    public Connection getConnectionJDBC() throws Exception;
}
