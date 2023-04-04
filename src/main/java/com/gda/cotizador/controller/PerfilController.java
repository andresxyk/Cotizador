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
import org.springframework.web.bind.annotation.RestController;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.requestMarca.RequestMarcaDto;
import com.gda.cotizador.dto.requestPerfil.RequestPerfilDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.utils.GeneralUtil;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/gda-cotizador")
public class PerfilController {
	@Autowired
	private GeneralUtil generalUtil;

	@Autowired
	private Cotizador cotizador;

	final static Logger log = LogManager.getLogger(MarcaController.class);

	@RequestMapping(value = "/search-perfil", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para buscar una perfil en base al filtro proporcionado en la petición.", tags = {
			"Cotización" })
	public ResponseEntity<?> searchPerfil(@RequestBody RequestPerfilDto request) {
		log.info("searchPerfil");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);
	
	try {
		request = cotizador.procesarRequestPerfil(request);
		request.getGDA_menssage().setMenssage("success");
		request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
		request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
		return new ResponseEntity<RequestPerfilDto>(request, HttpStatus.OK);
	}catch (Exception e) {
		log.error("Error inesperado", e);
		request.getGDA_menssage().setMenssage("error");
		request.getGDA_menssage().setDescripcion(e.getMessage());
		request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<RequestPerfilDto>(request, HttpStatus.BAD_REQUEST);
		}
	}
}
