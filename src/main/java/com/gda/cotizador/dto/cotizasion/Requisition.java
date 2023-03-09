package com.gda.cotizador.dto.cotizasion;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Requisition
{
    private String system;

    @NotNull
    @NotBlank
    private String value;
    
    @NotNull 
    private Integer convenio;
    
    @NotNull
    private Integer marca;
    
    @NotNull
    private BigDecimal subtotal;
    
    @NotNull
    private BigDecimal descuentopromocion;

    @NotNull
    private BigDecimal pagopaciente;
    
    @NotNull
    private BigDecimal total;
    
  
}