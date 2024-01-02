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
import com.gda.cotizador.dto.requestPacienteMembresia.RequestPacienteMembresiaDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.utils.GeneralUtil;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/gda-cotizador")
public class PacienteMembresiaController {

	@Autowired
	private GeneralUtil generalUtil;

	@Autowired
	private Cotizador cotizador;

	final static Logger log = LogManager.getLogger(PacienteMembresiaController.class);

	@RequestMapping(value = "/search-paciente-membresia", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para buscar si un páciente cuenta con una membresia vigente.", tags = {
			"Cotización" })
	public ResponseEntity<?> searchPacienteMembresia(@RequestBody RequestPacienteMembresiaDto request) {
		log.info("searchPacienteMembresia");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);
		try {
			if (request.validarlineaNegocio(request)) {
						if (request.validarMarca(request)) {
							if (request.validarFiltroMembresia(request)) {
								request = cotizador.procesarPacienteMembresia(request);
								request.getGDA_menssage().setMenssage("success");
								request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
								request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
								return new ResponseEntity<RequestPacienteMembresiaDto>(request, HttpStatus.OK);
							} else {
								log.error("Error inesperado");
								request.getGDA_menssage().setMenssage("error");
								request.getGDA_menssage().setDescripcion(
										"Los campos del filtro no son válidos, se puede buscar por las siguientes combinaciones:\n"
										+ "1.- Membresia\n"
										+ "2.- Nombre, Apellido Paterno y Apellido Materno\n"
										+ "2.- Membresia, Nombre, Apellido Paterno y Apellido Materno\n"
										+ "2.- Fecha de Nacimiento, Nombre, Apellido Paterno y Apellido Materno\n");
								request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
								return new ResponseEntity<RequestPacienteMembresiaDto>(request, HttpStatus.BAD_REQUEST);
							}

						} else {
							log.error("Error inesperado");
							request.getGDA_menssage().setMenssage("error");
							request.getGDA_menssage().setDescripcion("La marca no es la correcta");
							request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
							return new ResponseEntity<RequestPacienteMembresiaDto>(request, HttpStatus.BAD_REQUEST);
						}
			} else {
				request.getGDA_menssage().setMenssage("error");
				request.getGDA_menssage().setDescripcion("La linea de negocio no es la correcta, linea de negocio: COTIZACION");
				request.getGDA_menssage().setCodeHttp(HttpStatus.NOT_ACCEPTABLE.value());
				return new ResponseEntity<RequestPacienteMembresiaDto>(request, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestPacienteMembresiaDto>(request, HttpStatus.BAD_REQUEST);
		}
	}
}
