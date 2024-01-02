package com.gda.cotizador.dto.requestPacienteMembresia;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class FiltroPacienteMembresiaDto {
	
	@NotNull
	@Schema(description = "Membresia del paciente")
	private String membresia;

	@NotNull
	@Schema(description = "Nombre del paciente")
	private String nombre;
	
	@NotNull
	@Schema(description = "Apellido paterno del paciente")
	private String apellidoPaterno;
	
	@NotNull
	@Schema(description = "Apellido materno del paciente")
	private String apellidoMaterno;
	
	@Null
	@Pattern(regexp = "^$|^\\d{2}-\\d{2}-\\d{4}$", message = "El formato debe ser dd-mm-yyyy o estar vacío")
	@Schema(description = "Fecha de nacimiento del paciente")
	private String fechaNacimiento;
	
}
