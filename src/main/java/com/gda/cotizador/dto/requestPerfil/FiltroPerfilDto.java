package com.gda.cotizador.dto.requestPerfil;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@RequestMapping("/infogda-fullV3")
public class FiltroPerfilDto {
	
	@Schema(description = "Código del perfil, -1: todos los perfiles")
	private String cperfil;
	
	@Schema(description = "Nombre del perfil")
	private String sperfil;
}
