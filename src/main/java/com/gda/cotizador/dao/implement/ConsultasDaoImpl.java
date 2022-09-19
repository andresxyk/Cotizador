package com.gda.cotizador.dao.implement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gda.cotizador.dao.interfaz.IConsultasDao;

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
	
	
	
}
