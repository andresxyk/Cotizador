package com.gda.cotizador.utils;

import java.io.InputStream;

import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;


@Service

public class GenerateReportPDF extends JdbcDaoSupport{
	
	final static Logger iObjLog = LogManager.getLogger(GenerateReportPDF.class);
	
	 @Autowired
	 private GeneraReporte GeneraReporte;

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
	 
	 public Connection getConnectionJDBC() throws Exception{
		  iObjLog.debug("ejecutando getConnectionJDBC");
		  EdbExecutor edbExecutor;
		  edbExecutor = new EdbExecutor();
		  return edbExecutor.getConnetion(env.getProperty("legacy.datasource.jdbc-url").replace("postgresql", "edb"),
				  env.getProperty("legacy.datasource.username"), env.getProperty("legacy.datasource.password"));
	  }

   public void doIndicaciones(TOrdenSucursalCotizacionDto aObjDatos) throws Exception {
	 
   	iObjLog.debug("doImprimir:ENTRANDO"); 
    Connection objCon = null;
       try {
           	iObjLog.debug("Entrando la Admision doRecibofactura ");
			//GenericDAO objConn = new GenericDAO();
           	iObjLog.info("Antes de entrar al getConnection");
			objCon = getConnectionJDBC();         
			iObjLog.info("Después de entrar al getConnection");
			InputStream strImagen = getClass().getResourceAsStream("/images/marca/Olab.jpg");   
			InputStream strImagenSLogan = getClass().getResourceAsStream("/images/marca/Olab_Slogan.png");
			if (aObjDatos.getCmarca() == 1) {
				iObjLog.info("OLAB");
			   // strImagen = getClass().getResourceAsStream("/images/marca/Olab.jpg");   
			   //strImagenSLogan = getClass().getResourceAsStream("/images/marca/Olab_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 4) {
				iObjLog.info("AZTECA");
			  // strImagen = getClass().getResourceAsStream("/images/marca/Azteca.jpg");            
			  // strImagenSLogan = getClass().getResourceAsStream("/images/marca/Azteca_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 5) {
				iObjLog.info("SWISSLAB");
			   //strImagen = getClass().getResourceAsStream("/images/marca/Swisslab.jpg");            
			  // strImagenSLogan = getClass().getResourceAsStream("/images/marca/Swisslab_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 7) {
				iObjLog.info("JENNER");
			 // strImagen = getClass().getResourceAsStream("/images/marca/jenner.jpg");            
			  // strImagenSLogan = getClass().getResourceAsStream("/images/marca/Jenner_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 15) {
				iObjLog.info("LIACSA");
			   // strImagen = getClass().getResourceAsStream("/images/marca/Liacsa.jpg");            
			  // strImagenSLogan = getClass().getResourceAsStream("/images/marca/Liacsa_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 19) {
				iObjLog.info("ASESORES NORTE");
			  // strImagen = getClass().getResourceAsStream("/images/marca/AsesoresNorte.jpg");            
			   //strImagenSLogan = getClass().getResourceAsStream("/images/marca/AsesoresNorte_Slogan.png");   
			}
			int intCotizacion = aObjDatos.getKordensucursalcotizacion();
		    String strNomArchivo = "RepIndicacionPaciente" + Calendar.getInstance().getTimeInMillis() + ".pdf";
           iObjLog.debug("Procesando la Admision doRecibofactura " +intCotizacion);
		    Map params = new HashMap();	
		    params.put("kordensucursalcotizacion", new Double(intCotizacion));            
		    params.put("imagen", strImagen);     
		    params.put("imagenSlogan", strImagenSLogan);
           Map subreportes = new HashMap();           
			if (aObjDatos.getCmarca() == 1) {            
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamen.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPaciente.jasper");            
			    GeneraReporte.generaReportePdf("RepIndicaciones.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 4) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenAzteca.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteAzteca.jasper");            
	            GeneraReporte.generaReportePdf("RepIndicacionesAzteca.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 5) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenSwissLab.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteSwissLab.jasper");            
	            GeneraReporte.generaReportePdf("RepIndicacionesSwissLab.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 7) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenJenner.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteJenner.jasper");            
	            GeneraReporte.generaReportePdf("RepIndicacionesJenner.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 15) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenLiacsa.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteLiacsa.jasper");            
	            GeneraReporte.generaReportePdf("RepIndicacionesLiacsa.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 19) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenAsesoresNorte.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteAsesoresNorte.jasper");            
	            GeneraReporte.generaReportePdf("RepIndicacionesAsesoresNorte.jasper", strNomArchivo, params, subreportes, objCon);            
			}
           iObjLog.debug("Saliendo la Admision doRecibofactura " +intCotizacion);        	
		}catch (Exception aError) {
		    iObjLog.error("Error en ReporteAction.doRecibofactura ",aError);
		    
		    throw aError;
		} finally {
			if(objCon!=null)objCon.close();        	
		}
   }

}
