package com.gda.cotizador.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CListaCorporativaDto {

	private Integer clistacorporativa;
    private String sdescripcionlista;
    private Integer cmarca;
    private Date dregistro;
    private Integer userid;
    
}
