package com.gda.cotizador.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.db.CConvenioDto;
import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.dto.requestSucursal.RequestSucursalDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.utils.GeneralUtil;
import com.google.gson.Gson;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/gda-cotizador")
public class CotizadorController {
	final static Logger log = LogManager.getLogger(CotizadorController.class);

	private Gson gson = new Gson();
	
	@Autowired
	private GeneralUtil generalUtil;
	
	@Autowired
	private Cotizador cotizador;

	@RequestMapping(value = "/search-convenio", method = { RequestMethod.POST },
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
	        produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para buscar convenios en base al filtro proporcionado en la petición.", tags = {"Cotización"})
	public ResponseEntity<?> searchConvenio(@RequestBody RequestConvenioDto request) {
		log.info("searchConvenio");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);
		try {
			request = cotizador.procesarRequestConvenio(request);
			request.getGDA_menssage().setMenssage("success");
			request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
			request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
			return new ResponseEntity<RequestConvenioDto>(request,HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestConvenioDto>(request, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/search-sucursal", method = { RequestMethod.POST },
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
	        produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para buscar sucursal en base al filtro proporcionado en la petición.", tags = {"Cotización"})
	public ResponseEntity<?> searchSucursal(@RequestBody RequestSucursalDto request) {
		log.info("searchSucursal");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);
		try {
			request = cotizador.procesarRequestSucursal(request);
			request.getGDA_menssage().setMenssage("success");
			request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
			request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
			return new ResponseEntity<RequestSucursalDto>(request,HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestSucursalDto>(request, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/search-examen", method = { RequestMethod.POST },
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
	        produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para buscar examenes en base al filtro proporcionado en la petición.", tags = {"Cotización"})
	public ResponseEntity<?> searchExamen(@RequestBody RequestExamenDto request) {
		log.info("searchExamen");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);
		try {
			if((request.getFiltro().getSexamen()==null && request.getFiltro().getCconvenio()>-1) || 
			   (request.getFiltro().getSexamen()!=null && request.getFiltro().getSexamen() == "" && request.getFiltro().getCconvenio()>-1) || 
			   (request.getFiltro().getSexamen().length()>4 && request.getFiltro().getCconvenio()>-1)) {
				request = cotizador.procesarRequestExamen(request);
				request.getGDA_menssage().setMenssage("success");
				request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
				request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
				return new ResponseEntity<RequestExamenDto>(request,HttpStatus.OK);		
			}else {
				request.getGDA_menssage().setMenssage("error");
				request.getGDA_menssage().setDescripcion("El campo filtro.sexamen puede ir nulo o vacio o debe contener mas de 4 caracteres y el campo filtro.cconvenio debe ser mayor de -1");
				request.getGDA_menssage().setCodeHttp(HttpStatus.NOT_ACCEPTABLE.value());
				return new ResponseEntity<RequestExamenDto>(request, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestExamenDto>(request, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/request-cotizador", method = { RequestMethod.POST },
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
	        produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para obtener los precios de los estudios.", tags = {"Cotización"})
	public ResponseEntity<?> requestCotizador(@RequestBody RequestCotizacionDto request) {
		log.info("searchExamen");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);
		try {
			request = cotizador.procesarRequestCotizacion(request);
			request.getGDA_menssage().setMenssage("success");
			request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
			request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
			return new ResponseEntity<RequestCotizacionDto>(request,HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestCotizacionDto>(request, HttpStatus.BAD_REQUEST);
		}
	}
	
}
