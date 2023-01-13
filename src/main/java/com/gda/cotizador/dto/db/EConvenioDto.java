package com.gda.cotizador.dto.db;

import java.math.BigDecimal;
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
