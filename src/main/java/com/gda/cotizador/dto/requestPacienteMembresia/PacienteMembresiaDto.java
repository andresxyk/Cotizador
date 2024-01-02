package com.gda.cotizador.dto.requestPacienteMembresia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PacienteMembresiaDto {

	@Schema(description = "Membresia del paciente")
	private String membresia;

	@Schema(description = "Nombre del paciente")
	private String nombre;
	
	@Schema(description = "Apellido paterno del paciente")
	private String apellidoPaterno;
	
	@Schema(description = "Apellido materno del paciente")
	private String apellidoMaterno;
	
	@Schema(description = "Fecha de nacimiento del paciente")
	private String fechaNacimiento;
	
	@Schema(description = "Marca")
	private Integer marca;
	
}
