package com.gda.cotizador.dao.implement;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gda.cotizador.dao.interfaz.IConexionJasper;
import com.gda.cotizador.utils.EdbExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository("ConexionJasper")
public class ConexionJasper extends JdbcDaoSupport implements IConexionJasper{
    final static Logger logger = LogManager.getLogger(ConexionJasper.class);

    @Autowired
	 private Environment env;
	 
	 @Autowired
	 DataSource dataSource;
	 
	 @PostConstruct
	 private void initialize() {
		 setDataSource(dataSource); 
	 }
	 
	 @Autowired
	 @Qualifier("jdbcSlave")
	 private JdbcTemplate jdbcTemplate;
	 
     @Override
	 public Connection getConnectionJDBC() throws Exception{
        logger.debug("ejecutando getConnectionJDBC");
        logger.info("dentro de la funcion getConnectionJDBC");
		  EdbExecutor edbExecutor;
		  edbExecutor = new EdbExecutor();
         return edbExecutor.getConnetion(env.getProperty("legacy.datasource.jdbc-url").replace("postgresql", "edb"),
				  env.getProperty("legacy.datasource.username"), env.getProperty("legacy.datasource.password"));
	  }
}
