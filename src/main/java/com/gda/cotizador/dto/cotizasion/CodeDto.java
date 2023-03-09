package com.gda.cotizador.dto.cotizasion;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CodeDto
{
	@NotNull
    @NotEmpty
    @Valid
    private List<CodingDto> coding;

    public void setCoding(List<CodingDto> coding){
        this.coding = coding;
    }
    public List<CodingDto> getCoding(){
        return this.coding;
    }
}

