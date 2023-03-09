package com.gda.cotizador.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.utils.GeneralUtil;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/infogda-fullV3")
@Api(tags = "controllerCotizacion")
public class CotizacionController {

final static Logger logger = LogManager.getLogger(CotizacionController.class);
	
	private Gson gson = new Gson();
		
	@Autowired
	private Cotizador cotizador;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private GeneralUtil generalUtil;
	
	
	@RequestMapping(value = "/service-request-cotizacion", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "Procesar Service Request Cotizacion", notes = "Método que se encarga de procesar la información del service request cotizacion, "
			+ "para generar la Cotizacion.")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_CREATED, message = "CREATED",response = Cotizador.class),
		@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "BAD_REQUEST",response = Cotizador.class)})
	public ResponseEntity<?> serviceRequest(@ApiParam(value = "Objeto ServiceRequest", required = true) @RequestBody RequestCotizacionDto cotizacionDto) throws Exception {
		logger.info("serviceRequest");
		try{
			if(cotizacionDto.getStatus().equals("active")){
				//String response = gson.toJson(cotizador.procesarNewCotizacion("cotizacion"));
				
				return new ResponseEntity<String>(
						//response,
						HttpStatus.CREATED);				
			}else{
				
				GDAMenssageDto gdaMessage = new GDAMenssageDto();
				gdaMessage.setAcuse(generalUtil.getAcuseUUID());
				cotizacionDto.setGDA_menssage(gdaMessage);
				//cotizacion = cotizacion.procesarRequestConvenio();
				cotizacionDto.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
				cotizacionDto.getGDA_menssage().setMenssage("error");
				cotizacionDto.getGDA_menssage().setDescripcion("Status Incorrecto, Status disponibles: active [crear nueva cotizacion]");
				cotizacionDto.getGDA_menssage().setAcuse(generalUtil.getAcuseUUID());
				cotizacionDto.setGDA_menssage(gdaMessage);
				String response = gson.toJson(cotizacionDto);
				
				return new ResponseEntity<String>(
						gson.toJson(cotizacionDto), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error("Error inesperado", e);
			String request = gson.toJson(cotizacionDto);
			GDAMenssageDto gdaMessage = new GDAMenssageDto();
				gdaMessage.setCodeHttp(HttpStatus.BAD_REQUEST.value());
				gdaMessage.setMenssage("error");
				gdaMessage.setDescripcion("error:" + e.getMessage()!=null?e.getMessage():e.getCause().getMessage());
				gdaMessage.setAcuse(generalUtil.getAcuseUUID());
				cotizacionDto.setGDA_menssage(gdaMessage);
			String response = gson.toJson(cotizacionDto);
			
			return new ResponseEntity<String>(
					gson.toJson(cotizacionDto), HttpStatus.BAD_REQUEST);
		}

	}
	
}
