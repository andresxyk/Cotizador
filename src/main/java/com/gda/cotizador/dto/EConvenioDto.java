package com.gda.cotizador.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EConvenioDto {
	    private Integer kconvenio;
	    private Integer cconvenio;
	    private Integer cvigencia;
	    private Integer clistacorporativa;
	    private Integer cestadoregistro;
	    private Date dinicio;
	    private Date dtermino;
	    private BigDecimal pcopago;
	    private BigDecimal mcopago;
	    private Boolean bcopagopaciente;
	    private Integer cmarca;
	    private Boolean binactivaautomatico;
}
