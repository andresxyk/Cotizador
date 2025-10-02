package com.gda.cotizador.controller;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenConveniosDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.utils.GeneralUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
@RestController
@RequestMapping({"/gda-cotizador"})
public class ExamenController {
  static final Logger log = LogManager.getLogger(com.gda.cotizador.controller.ExamenController.class);
  
  @Autowired
  private GeneralUtil generalUtil;
  
  @Autowired
  private Cotizador cotizador;
  
 
  @RequestMapping(value = {"/search-examen-convenios"}, method = {RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
  @Operation(description = "Mpara buscar examenes en base al filtro proporcionado en la petici, tags = {Cotizaci}")
  public ResponseEntity<?> searchExamenConvenios(@RequestBody RequestExamenConveniosDto request) {
    log.info("searchExamen");
    GDAMenssageDto msg = new GDAMenssageDto();
    msg.setAcuse(this.generalUtil.getAcuseUUID());
    request.setGDA_menssage(msg);
    try {
      if (request.validarlineaNegocio(request)) {
        if (request.validarFiltro(request).booleanValue()) {
          if (request.validarMarca(request).booleanValue()) {
            if (request.validarFiltroExamen(request).booleanValue()) {
              request = this.cotizador.procesarRequestExamenConvenios(request);
              request.getGDA_menssage().setMenssage("success");
              request.getGDA_menssage().setDescripcion("Peticiprocesada exitosamente.");
              request.getGDA_menssage().setCodeHttp(Integer.valueOf(HttpStatus.OK.value()));
              return new ResponseEntity(request, HttpStatus.OK);
            } 
            log.error("Error inesperado");
            request.getGDA_menssage().setMenssage("error");
            request.getGDA_menssage().setDescripcion("Los campos sexamen y sexamenweb son vacios, no se puede validar");
            request.getGDA_menssage().setCodeHttp(Integer.valueOf(HttpStatus.BAD_REQUEST.value()));
            return new ResponseEntity(request, HttpStatus.BAD_REQUEST);
          } 
          log.error("Error inesperado");
          request.getGDA_menssage().setMenssage("error");
          request.getGDA_menssage().setDescripcion("La marca no es la correcta, validar marca");
          request.getGDA_menssage().setCodeHttp(Integer.valueOf(HttpStatus.BAD_REQUEST.value()));
          return new ResponseEntity(request, HttpStatus.BAD_REQUEST);
        } 
        request.getGDA_menssage().setMenssage("error");
        request.getGDA_menssage().setDescripcion("El campo filtro.sexamen no puede ir nulo o vacio o debe contener mas de 4 caracteres y el campo filtro.cconvenio debe ser mayor de -1");
        request.getGDA_menssage().setCodeHttp(Integer.valueOf(HttpStatus.NOT_ACCEPTABLE.value()));
        return new ResponseEntity(request, HttpStatus.NOT_ACCEPTABLE);
      } 
      request.getGDA_menssage().setMenssage("error");
      request.getGDA_menssage().setDescripcion("La linea de negocio no es la correcta, linea de negocio: COTIZACION");
      request.getGDA_menssage().setCodeHttp(Integer.valueOf(HttpStatus.NOT_ACCEPTABLE.value()));
      return new ResponseEntity(request, HttpStatus.NOT_ACCEPTABLE);
    } catch (Exception e) {
      log.error("Error inesperado", e);
      request.getGDA_menssage().setMenssage("error");
      request.getGDA_menssage().setDescripcion(e.getMessage());
      request.getGDA_menssage().setCodeHttp(Integer.valueOf(HttpStatus.BAD_REQUEST.value()));
      return new ResponseEntity(request, HttpStatus.BAD_REQUEST);
    } 
  }
}
