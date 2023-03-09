package com.gda.cotizador.dto.cotizadorRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Subject
{
	@NotNull
	@NotBlank
    private String reference;

    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReference(){
        return this.reference;
    }
}