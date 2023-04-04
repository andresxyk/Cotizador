package com.gda.cotizador.dto.requestPerfil;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.requestExamen.ExamenDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@RequestMapping("/infogda-fullV3")
public class PerfilDto {
	@Schema(description = "ID Pefil")
	private String cperfil;
	@Schema(description = "Nombre del Perfil")
	private String sperfil;
}
