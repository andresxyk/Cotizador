package com.gda.cotizador.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.edb.util.Base64;
import com.gda.cotizador.dao.interfaz.IConexionJasper;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;



@Service
public class GenerateReportPDF {
	
	final static Logger iObjLog = LogManager.getLogger(GenerateReportPDF.class);
	
	 @Autowired
	 private GeneraReporte GeneraReporte;

	 @Autowired
	 IConexionJasper conexionJasper;

   public byte[] doIndicaciones(TOrdenSucursalCotizacionDto aObjDatos) throws Exception {
	 
   	iObjLog.debug("doImprimir:ENTRANDO"); 
    Connection objCon = null;
    String ruta = "" ;
    
       try {
           	iObjLog.debug("Entrando la Admision doRecibofactura ");
			objCon = conexionJasper.getConnectionJDBC();         
			InputStream strImagen = getClass().getResourceAsStream("/images/marca/Olab.jpg");   
			InputStream strImagenSLogan = getClass().getResourceAsStream("/images/marca/Olab_Slogan.png");
			if (aObjDatos.getCmarca() == 1) {
			    strImagen = getClass().getResourceAsStream("/images/marca/Olab.jpg");   
			    strImagenSLogan = getClass().getResourceAsStream("/images/marca/Olab_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 4) {
				strImagen = getClass().getResourceAsStream("/images/marca/Azteca.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/Azteca_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 5) {
				strImagen = getClass().getResourceAsStream("/images/marca/Swisslab.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/Swisslab_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 7) {
				strImagen = getClass().getResourceAsStream("/images/marca/jenner.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/Jenner_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 15) {
			    strImagen = getClass().getResourceAsStream("/images/marca/Liacsa.jpg");            
			    strImagenSLogan = getClass().getResourceAsStream("/images/marca/Liacsa_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 19) {
				strImagen = getClass().getResourceAsStream("/images/marca/AsesoresNorte.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/AsesoresNorte_Slogan.png");   
			}
			int intCotizacion = aObjDatos.getKordensucursalcotizacion();
		    String strNomArchivo = "RepIndicacionPaciente" + Calendar.getInstance().getTimeInMillis() + ".pdf";
           iObjLog.info("Procesando la Admision doRecibofactura " +intCotizacion);
		    Map params = new HashMap();	
		    params.put("kordensucursalcotizacion", new Double(intCotizacion));            
		    params.put("imagen", strImagen);     
		    params.put("imagenSlogan", strImagenSLogan);
           Map subreportes = new HashMap();           
			if (aObjDatos.getCmarca() == 1) {            
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamen.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPaciente.jasper");            
			    ruta = GeneraReporte.generaReportePdf("RepIndicaciones.jasper", strNomArchivo, params, subreportes, objCon);
			} else if (aObjDatos.getCmarca() == 4) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenAzteca.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteAzteca.jasper");            
	            ruta =GeneraReporte.generaReportePdf("RepIndicacionesAzteca.jasper", strNomArchivo, params, subreportes, objCon);
			} else if (aObjDatos.getCmarca() == 5) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenSwissLab.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteSwissLab.jasper");            
	            ruta =GeneraReporte.generaReportePdf("RepIndicacionesSwissLab.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 7) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenJenner.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteJenner.jasper");            
	            ruta =GeneraReporte.generaReportePdf("RepIndicacionesJenner.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 15) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenLiacsa.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteLiacsa.jasper");            
	            ruta =GeneraReporte.generaReportePdf("RepIndicacionesLiacsa.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 19) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenAsesoresNorte.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteAsesoresNorte.jasper");            
	            ruta = GeneraReporte.generaReportePdf("RepIndicacionesAsesoresNorte.jasper", strNomArchivo, params, subreportes, objCon);            
			}
           iObjLog.debug("Saliendo la Admision doRecibofactura " +intCotizacion);
           byte[] inFileBytes = Files.readAllBytes(Paths.get(ruta)); 
           byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
           return encoded;
		}catch (Exception aError) {
		    iObjLog.error("Error en ReporteAction.doRecibofactura ",aError);
		    
		    throw aError;
		} finally {
			if(objCon!=null)objCon.close();        	
		}
    
   }

}

