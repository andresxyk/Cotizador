package com.gda.cotizador.dto.cotizador;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Code
{
	@NotNull
    @NotEmpty
    @Valid
    private List<Coding> coding;

    public void setCoding(List<Coding> coding){
        this.coding = coding;
    }
    public List<Coding> getCoding(){
        return this.coding;
    }
}

