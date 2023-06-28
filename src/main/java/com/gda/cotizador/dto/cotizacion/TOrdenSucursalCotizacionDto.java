package com.gda.cotizador.dto.cotizacion;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TOrdenSucursalCotizacionDto {

	private Integer kordensucursalcotizacion;
	private Integer kordensucursal;
	private Integer cmarca;
    private String ssucursal;
    private Integer csucursal;
    private Integer kpaciente;
    private Integer cmedico;
    private String smedico;
    private BigDecimal msubtotal;
    private BigDecimal mdescuentopromocion;
    private BigDecimal mdescuentoempresa;
    private BigDecimal mdescuentomedico;
    private BigDecimal mfacturaempresa;
    private BigDecimal mpagopaciente;
    private BigDecimal miva;
    private BigDecimal piva;
    private BigDecimal mtotal;
    private Integer userid;
    private Integer cestadoregistro;
    private Date dregistro;
    private String sobservacion;
    private Integer cconvenio;
    private Integer useridchange;
    private Integer csucursaldestino;
    
}
