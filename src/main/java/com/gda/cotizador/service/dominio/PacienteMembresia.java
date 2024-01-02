package com.gda.cotizador.service.dominio;

import com.gda.cotizador.dto.requestPacienteMembresia.RequestPacienteMembresiaDto;

public interface PacienteMembresia {

	RequestPacienteMembresiaDto procesarPacienteMembresia(RequestPacienteMembresiaDto request) throws Exception;
}
