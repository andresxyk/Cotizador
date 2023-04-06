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
import com.gda.cotizador.dto.requestConvenio.RequestConvenioDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.dto.requestMarca.RequestMarcaDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.utils.GeneralUtil;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/gda-cotizador")
public class ConvenioController {
	final static Logger log = LogManager.getLogger(ConvenioController.class);

	@Autowired
	private GeneralUtil generalUtil;

	@Autowired
	private Cotizador cotizador;

	@RequestMapping(value = "/search-convenio", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para buscar convenios en base al filtro proporcionado en la petición.", tags = {
			"Cotización" })

	public ResponseEntity<?> searchConvenio(@RequestBody RequestConvenioDto request) {
		log.info("searchConvenio");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);
		try {
			if (request.validarlineaNegocio(request)) {
				if (request.validarFechaRegistro(request)) {
					if (request.validarFiltro(request)) {
						if (request.validarMarca(request)) {
							if (request.validarFiltroConvenio(request)) {
								request = cotizador.procesarRequestConvenio(request);
								request.getGDA_menssage().setMenssage("success");
								request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
								request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
								return new ResponseEntity<RequestConvenioDto>(request, HttpStatus.OK);
							} else {
								log.error("Error inesperado");
								request.getGDA_menssage().setMenssage("error");
								request.getGDA_menssage().setDescripcion(
										"Los campos sconvenio y cmarca son vacios, no se puede validar");
								request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
								return new ResponseEntity<RequestConvenioDto>(request, HttpStatus.BAD_REQUEST);
							}

						} else {
							log.error("Error inesperado");
							request.getGDA_menssage().setMenssage("error");
							request.getGDA_menssage().setDescripcion("La marca no es la correcta, marca: 0");
							request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
							return new ResponseEntity<RequestConvenioDto>(request, HttpStatus.BAD_REQUEST);
						}

					} else {
						request.getGDA_menssage().setMenssage("error");
						request.getGDA_menssage().setDescripcion(
								"Los campos filtro.sconvenio, filtro.cmarca no pueden ir nulos o vacios o deben contener mas caracteres");
						request.getGDA_menssage().setCodeHttp(HttpStatus.NOT_ACCEPTABLE.value());
						return new ResponseEntity<RequestConvenioDto>(request, HttpStatus.NOT_ACCEPTABLE);
					}
				} else {
					request.getGDA_menssage().setMenssage("error");
					request.getGDA_menssage().setDescripcion("El formato de la fecha es incorrecto o no es la actual, validar");
					request.getGDA_menssage().setCodeHttp(HttpStatus.NOT_ACCEPTABLE.value());
					return new ResponseEntity<RequestConvenioDto>(request, HttpStatus.NOT_ACCEPTABLE);
				}
			} else {
				request.getGDA_menssage().setMenssage("error");
				request.getGDA_menssage().setDescripcion("La linea de negocio no es la correcta, linea de negocio: COTIZACION");
				request.getGDA_menssage().setCodeHttp(HttpStatus.NOT_ACCEPTABLE.value());
				return new ResponseEntity<RequestConvenioDto>(request, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestConvenioDto>(request, HttpStatus.BAD_REQUEST);
		}
	}

}
