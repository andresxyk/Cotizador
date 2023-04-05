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
import com.gda.cotizador.dto.requestSucursal.RequestSucursalDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.utils.GeneralUtil;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/gda-cotizador")
public class MarcaController {
	@Autowired
	private GeneralUtil generalUtil;

	@Autowired
	private Cotizador cotizador;

	final static Logger log = LogManager.getLogger(MarcaController.class);

	@RequestMapping(value = "/search-marca", method = { RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Método para buscar una marca en base al filtro proporcionado en la petición.", tags = {
			"Cotización" })
	public ResponseEntity<?> searchMarca(@RequestBody RequestMarcaDto request) {
		log.info("searchMarca");
		GDAMenssageDto msg = new GDAMenssageDto();
		msg.setAcuse(generalUtil.getAcuseUUID());
		request.setGDA_menssage(msg);

		try {
			if (request.validarlineaNegocio(request)) {
				if (request.validarFechaRegistro(request)) {
					if (request.validarFiltro(request)) {
						if (request.validarMarca(request)) {
							if (request.validarFiltroMarca(request)) {
								request = cotizador.procesarRequestMarca(request);
								request.getGDA_menssage().setMenssage("success");
								request.getGDA_menssage().setDescripcion("Petición procesada exitosamente.");
								request.getGDA_menssage().setCodeHttp(HttpStatus.OK.value());
								return new ResponseEntity<RequestMarcaDto>(request, HttpStatus.OK);
							} else {
								log.error("Error inesperado");
								request.getGDA_menssage().setMenssage("error");
								request.getGDA_menssage()
										.setDescripcion("Los campos smarca y cmarca son vacios, no se puede validar");
								request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
								return new ResponseEntity<RequestMarcaDto>(request, HttpStatus.BAD_REQUEST);
							}

						} else {
							log.error("Error inesperado");
							request.getGDA_menssage().setMenssage("error");
							request.getGDA_menssage().setDescripcion("La marca no es la correcta, Marca: 0");
							request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
							return new ResponseEntity<RequestMarcaDto>(request, HttpStatus.BAD_REQUEST);
						}
					} else {
						request.getGDA_menssage().setMenssage("error");
						request.getGDA_menssage().setDescripcion(
								"Los campos filtro.cmarca, filtro.smarca no pueden ir nulos o vacios o deben contener mas de 1 caracteres");
						request.getGDA_menssage().setCodeHttp(HttpStatus.NOT_ACCEPTABLE.value());
						return new ResponseEntity<RequestMarcaDto>(request, HttpStatus.NOT_ACCEPTABLE);
					}
				} else {
					request.getGDA_menssage().setMenssage("error");
					request.getGDA_menssage().setDescripcion("La fecha no es la actual");
					request.getGDA_menssage().setCodeHttp(HttpStatus.NOT_ACCEPTABLE.value());
					return new ResponseEntity<RequestMarcaDto>(request, HttpStatus.NOT_ACCEPTABLE);
				}
			} else {
				request.getGDA_menssage().setMenssage("error");
				request.getGDA_menssage().setDescripcion("Linea de negocio incorrecto");
				request.getGDA_menssage().setCodeHttp(HttpStatus.NOT_ACCEPTABLE.value());
				return new ResponseEntity<RequestMarcaDto>(request, HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			log.error("Error inesperado", e);
			request.getGDA_menssage().setMenssage("error");
			request.getGDA_menssage().setDescripcion(e.getMessage());
			request.getGDA_menssage().setCodeHttp(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<RequestMarcaDto>(request, HttpStatus.BAD_REQUEST);
		}
	}
}
