package com.gda.cotizador.utils;



import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class GeneraReporte implements Serializable{
  
  private Connection connection = null;
  private JRDataSource jrDataSrc = null;
  private Map params = null;
  private Map subreportes = null;
  private String jasperFileName = null;
  private String jasperFileNameFull = null;
  private String pdfFileName = null;
  private String pdfFileNameFull = null;
  private String httpPath = null;
  private String deafultContentType = "application/pdf";
  private String defaultHtmlHeader = "inline;filename=Reporte_" + (new Date()).getTime() + ".pdf";
  private String contentType = null;
  private String htmlHeader = null;
  private byte[] bytes = null;




  public byte[] generarIReport(String jasperFileName, String pdfFileName, Map params, Map subreportes, Connection connection) throws JRException{
	  File reportFile = new File("C:\\jasper\\RepOrdenEstadoCuenta.jasper");
      JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath()); //se ejecuta el reporte
      byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, params, connection);
      return bytes;
  }

/**
 * Funcion para genera el reporte pdf
 * @param jasperFileName
 * @param pdfFileName
 * @param params
 * @param subreportes
 * @param connection
 * @return String sHttpPath De buelve la ruta donde se creo el pdf del .jasper
 * @throws Exception
 */
  public String generaReportePdf(String jasperFileName, String pdfFileName, Map params, Map subreportes, Connection connection) throws Exception {
	    try {	      
	        String sHttpPath = generarPdf(jasperFileName, pdfFileName, params, subreportes, connection);
	        return sHttpPath;
	    } catch (JRException jexp) {
	      throw jexp;
	    } catch (Exception aError) {
	      throw aError;
	    } 
	  }

	  /**
	   * Funcion para crear el reporte con jasper para pdf
	   * @param jasperFileName
	   * @param pdfFileName
	   * @param params
	   * @param subreportes
	   * @param connection
	   * @return String pdfFileNameFull nombre completo del pdf generaro 
	   * @throws Exception
	   */
  public String generarPdf(String jasperFileName, String pdfFileName, Map params, Map subreportes, Connection connection) throws Exception {
	    try {
	      this.jasperFileName = jasperFileName;
	      this.pdfFileName = pdfFileName;
	      this.params = params;
	      this.subreportes = subreportes;
	      this.connection = connection;
	      setRutasReportes();
	      Map parametrosFull = new HashMap();
	      if (params != null) parametrosFull.putAll(params); 
	      if (subreportes != null) parametrosFull.putAll(subreportes); 

	      JasperRunManager.runReportToPdfFile(this.jasperFileNameFull, this.pdfFileNameFull, parametrosFull, this.connection);
	    } catch (JRException jexp) {
	      throw jexp;
	    } catch (Exception aError) {
	      throw aError;
	    } 
	    return this.pdfFileNameFull;
	  }

  	private void setRutasReportes() {	    
	    try {
	      String sJasperPath = "/mnt/gda/DesarrolloGDA/jasper-gda/";
	      String sPdfPath = "/mnt/gda/DesarrolloGDA/files-reportes-tmp/";
	      String sHttpPath = "";

	      this.jasperFileNameFull = sJasperPath + this.jasperFileName;
	      this.pdfFileNameFull = sPdfPath + this.pdfFileName;
	      this.httpPath = sHttpPath + this.pdfFileName;
	      
	      if (this.subreportes != null && !this.subreportes.isEmpty()) {
	        Iterator itera = this.subreportes.keySet().iterator();
	        while (itera.hasNext()) {
	          String key = (String)itera.next();
	          String valor = (String)this.subreportes.get(key);
	          String sNuevoValor = sJasperPath + valor;

	          
	          this.subreportes.put(key, sNuevoValor);
	        } 
	      } 
	    }
	    catch (Exception aError) {
	      throw aError;
	    } 
	  }
}