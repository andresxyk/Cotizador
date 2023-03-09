package com.gda.cotizador.dto.cotizasion;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TOrdenExamenSucursalCotizacionDto {

	private Integer kordenexamensucursalcotizacion;
    private Integer kordensucursalcotizacion;
    private Integer cexamen;
    private String sexamen;
    private BigDecimal msubtotal;
    private BigDecimal mdescuentopromocion;
    private BigDecimal mdescuentoempresa;
    private BigDecimal mdescuentomedico;
    private BigDecimal mfacturaempresa;
    private BigDecimal mpagopaciente;
    private BigDecimal miva;
    private BigDecimal mtotal;
    private Integer userid;
    private Integer cestadoregistro;
    private Date dregistro;
    private Integer cconvenio;
    private String smotivocancelacion;
    private Integer cperfil;
    private Integer uvolumenexamen; 
    
}
