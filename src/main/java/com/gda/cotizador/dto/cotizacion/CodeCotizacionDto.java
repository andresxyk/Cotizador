package com.gda.cotizador.dto.cotizacion;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
@RequestMapping("/infogda-fullV3")
public class CodeCotizacionDto
{
	@NotNull
    @NotEmpty
    @Valid
    @Schema(description = "Revisar estructa coding")
    private List<CodingCotizacionDto> coding;

    public void setCoding(List<CodingCotizacionDto> coding){
        this.coding = coding;
    }
    public List<CodingCotizacionDto> getCoding(){
        return this.coding;
    }
}

