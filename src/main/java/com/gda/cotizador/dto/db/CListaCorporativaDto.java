package com.gda.cotizador.dto.db;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class CListaCorporativaDto {

	private Integer clistacorporativa;
    private String sdescripcionlista;
    private Integer cmarca;
    private Date dregistro;
    private Integer userid;
    
}
