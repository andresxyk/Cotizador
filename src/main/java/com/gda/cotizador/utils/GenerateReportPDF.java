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
import com.gda.cotizador.dto.cotizacion.TOrdenSucursalCotizacionDto;



@Service
public class GenerateReportPDF {
	
	final static Logger iObjLog = LogManager.getLogger(GenerateReportPDF.class);
	
	 @Autowired
	 private GeneraReporte GeneraReporte;

	 @Autowired
	 IConexionJasper conexionJasper;

	 /**
	  * Funcion puente para genera los pdfs en base la marca
	  * @param TOrdenSucursalCotizacionDto 
	  * @return byte[] Pdf en base 64
	  * @throws Exception
	  */
   public byte[] doIndicaciones(TOrdenSucursalCotizacionDto aObjDatos) throws Exception {
	 
   	iObjLog.debug("doImprimir:ENTRANDO"); 
    Connection objCon = null;
    String ruta = "" ;
    
       try {
           	iObjLog.debug("Entrando la Admision doRecibofactura ");
			objCon = conexionJasper.getConnectionJDBC();         
			InputStream strImagen = null;   
			InputStream strImagenSLogan = null;
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
			} else if (aObjDatos.getCmarca() == 20) {
				strImagen = getClass().getResourceAsStream("/images/marca/Exakta.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/Exakta_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 25) {
				strImagen = getClass().getResourceAsStream("/images/marca/Biomedica.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/Biomedica_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 22) {
				strImagen = getClass().getResourceAsStream("/images/marca/Polab.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/Polab_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 23) {
				strImagen = getClass().getResourceAsStream("/images/marca/Lister.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/Lister_Slogan.png");   
			} else if (aObjDatos.getCmarca() == 28) {
				strImagen = getClass().getResourceAsStream("/images/marca/Moreira.jpg");            
				strImagenSLogan = getClass().getResourceAsStream("/images/marca/Moreira_Slogan.png");   
			}
			int intCotizacion = aObjDatos.getKordensucursalcotizacion();
		    String strNomArchivo = "RepIndicacionPaciente" + Calendar.getInstance().getTimeInMillis() + ".pdf";
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
			} else if (aObjDatos.getCmarca() == 20) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenExakta.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteExakta.jasper");            
	            ruta = GeneraReporte.generaReportePdf("RepIndicacionesExakta.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 25) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenBiomedica.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteBiomedica.jasper");            
	            ruta = GeneraReporte.generaReportePdf("RepIndicacionesBiomedica.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 22) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenPolab.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacientePolab.jasper");            
	            ruta = GeneraReporte.generaReportePdf("RepIndicacionesPolab.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 23) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenLister.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteLister.jasper");            
	            ruta = GeneraReporte.generaReportePdf("RepIndicacionesLister.jasper", strNomArchivo, params, subreportes, objCon);            
			} else if (aObjDatos.getCmarca() == 28) {
	            subreportes.put("repprocedimientoexamen","RepProcedimientoExamenMoreira.jasper");
	            subreportes.put("repindicacionpaciente","RepIndicacionPacienteMoreira.jasper");            
	            ruta = GeneraReporte.generaReportePdf("RepIndicacionesMoreira.jasper", strNomArchivo, params, subreportes, objCon);            
			}
           iObjLog.debug("Saliendo la Admision doRecibofactura " +intCotizacion);
           byte[] inFileBytes = Files.readAllBytes(Paths.get(ruta)); 
           byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
           return encoded;
		}catch (Exception aError) {
			aError.printStackTrace();
		    iObjLog.error("Error en ReporteAction.doRecibofactura ",aError);
		    throw aError;
		} finally {
			if(objCon!=null)objCon.close();        	
		}
    
   }

}

