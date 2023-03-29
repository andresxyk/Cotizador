package com.gda.cotizador.dto.cotizasion;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
@RequestMapping("/infogda-fullV3")
public class CodeDto
{
	@NotNull
    @NotEmpty
    @Valid
    @Schema(description = "Revisar estructa coding")
    private List<CodingDto> coding;

    public void setCoding(List<CodingDto> coding){
        this.coding = coding;
    }
    public List<CodingDto> getCoding(){
        return this.coding;
    }
}

