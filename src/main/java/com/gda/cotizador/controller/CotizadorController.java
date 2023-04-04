package com.gda.cotizador.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gda.cotizador.dto.bitacora.TBitacoraApiDto;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.cotizasion.CotizacionDto;
import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.service.bitacora.Bitacora;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.service.impl.dominio.SetsDtosImpl;
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
	@Autowired
	private Environment env;
	@Autowired
	private Bitacora _bitacora;
	@Autowired
	private SetsDtosImpl setsDtosImpl;

	@RequestMapping(value = "/request-cotizador", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para obtener los precios de los estudios.", tags = { "Cotización" })
	@Deprecated
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
			return new ResponseEntity<RequestCotizacionDto>(request, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestCotizacionDto>(request, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/service-request-cotizacion", method = {
			RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	@Operation(description = "Método para generar un ID y archivo PDF de la cotización.", tags = { "Cotización" })
	@Deprecated
	public ResponseEntity<?> serviceRequest(@RequestBody CotizacionDto cotizacionDto) throws Exception {
		log.info("serviceRequest");
		try {
			if (cotizacionDto.getStatus().equals("active")) {
				String response = gson.toJson(cotizador.procesarNewCotizacion(cotizacionDto));
				_bitacora.bitacoraApis(new TBitacoraApiDto(gson.toJson(cotizacionDto), response,
						env.getProperty("name.cotizador.create.service.requestcotizacion")));
				return new ResponseEntity<String>(response, HttpStatus.CREATED);
			} else {
				cotizacionDto.setGDA_menssage(setsDtosImpl.setForGdaMessage(HttpStatus.BAD_REQUEST.value(), "error",
						"Status Incorrecto, Status disponibles: active [crear nueva cotizacion]"));
				String response = gson.toJson(cotizacionDto);
				_bitacora.bitacoraApis(new TBitacoraApiDto(gson.toJson(cotizacionDto), response,
						env.getProperty("name.cotizador.create.service.requestcotizacion")));
				return new ResponseEntity<String>(gson.toJson(cotizacionDto), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error inesperado", e);
			String request = gson.toJson(cotizacionDto);
			cotizacionDto.setGDA_menssage(setsDtosImpl.setForGdaMessage(HttpStatus.BAD_REQUEST.value(), "error",
					"error:" + e.getMessage() != null ? e.getMessage() : e.getCause().getMessage()));
			String response = gson.toJson(cotizacionDto);
			_bitacora.bitacoraApis(new TBitacoraApiDto(request, response,
					env.getProperty("name.cotizador.error.service.requestcotizacion")));
			return new ResponseEntity<String>(gson.toJson(cotizacionDto), HttpStatus.BAD_REQUEST);
		}

	}
							//Confirmar nombre
	@RequestMapping(value = "/search-cotizacion", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para obtener los precios de los estudios.", tags = { "Cotización" })
	public ResponseEntity<?> searchCotizacion(@RequestBody RequestCotizacionDto request) {
		log.info("searchExamen");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);
		try {
			request = cotizador.procesarRequestCotizacion(request);
			request.getGDA_menssage().setMenssage("success");
			request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
			request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
			return new ResponseEntity<RequestCotizacionDto>(request, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestCotizacionDto>(request, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/generate-cotizacion", method = {
			RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	@Operation(description = "Método para generar un ID y archivo PDF de la cotización.", tags = { "Cotización" })
	public ResponseEntity<?> generateCotizacion(@RequestBody CotizacionDto cotizacionDto) throws Exception {
		log.info("serviceRequest");
		try {
			if (cotizacionDto.getStatus().equals("active")) {
				String response = gson.toJson(cotizador.procesarNewCotizacion(cotizacionDto));
				_bitacora.bitacoraApis(new TBitacoraApiDto(gson.toJson(cotizacionDto), response,
						env.getProperty("name.cotizador.create.service.requestcotizacion")));
				return new ResponseEntity<String>(response, HttpStatus.CREATED);
			} else {
				cotizacionDto.setGDA_menssage(setsDtosImpl.setForGdaMessage(HttpStatus.BAD_REQUEST.value(), "error",
						"Status Incorrecto, Status disponibles: active [crear nueva cotizacion]"));
				String response = gson.toJson(cotizacionDto);
				_bitacora.bitacoraApis(new TBitacoraApiDto(gson.toJson(cotizacionDto), response,
						env.getProperty("name.cotizador.create.service.requestcotizacion")));
				return new ResponseEntity<String>(gson.toJson(cotizacionDto), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error inesperado", e);
			String request = gson.toJson(cotizacionDto);
			cotizacionDto.setGDA_menssage(setsDtosImpl.setForGdaMessage(HttpStatus.BAD_REQUEST.value(), "error",
					"error:" + e.getMessage() != null ? e.getMessage() : e.getCause().getMessage()));
			String response = gson.toJson(cotizacionDto);
			_bitacora.bitacoraApis(new TBitacoraApiDto(request, response,
					env.getProperty("name.cotizador.error.service.requestcotizacion")));
			return new ResponseEntity<String>(gson.toJson(cotizacionDto), HttpStatus.BAD_REQUEST);
		}

	}
}
