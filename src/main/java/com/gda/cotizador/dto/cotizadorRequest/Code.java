package com.gda.cotizador.dto.cotizadorRequest;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
@RequestMapping("/infogda-fullV3")
public class Code
{
	@NotNull
    @NotEmpty
    @Valid
    @Schema(description = "Revisar estructura coding")
    private List<Coding> coding;

    public void setCoding(List<Coding> coding){
        this.coding = coding;
    }
    public List<Coding> getCoding(){
        return this.coding;
    }
}

