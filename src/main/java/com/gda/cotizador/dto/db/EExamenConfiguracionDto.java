package com.gda.cotizador.dto.db;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EExamenConfiguracionDto {

	private Integer kexamenconfiguracion;
	private Integer clugarprocesamiento;
	private Integer cexamen;
	private Integer cmetodologia;
    private String ssubtituloexameninicio;
    private String ssubtituloexamenfinal;
    private Integer utiemporespuestahoras;
    private Date hhoracorte;
    private BigDecimal mcostolaboratorio;
    private Boolean blunes;
    private Boolean bmartes;
    private Boolean bmiercoles;
    private Boolean bjueves;
    private Boolean bviernes;
    private Boolean bsabado;
    private Boolean bdomingo;
    private Integer userid;
    private Integer cdepartamentolaboratorio;
    private Integer utiemporespuestadias;
    private Integer uvolumenmaximo;
    private String sutilidadclinica;
    private Date dexamenmodificado;
    private Integer uresponsable;
    private Integer uverificacionresponsable;
    private String scondicionpreanalitica;
    private Integer cestadoregistro;
    private Date dregistro;
    private Integer cmoneda;
    private Boolean brutina;
    private Boolean blunesmuestratoma;
    private Boolean bmartesmuestratoma;
    private Boolean bmiercolesmuestratoma;
    private Boolean bjuevesmuestratoma;
    private Boolean bviernesmuestratoma;
    private Boolean bsabadomuestratoma;
    private Boolean bdomingomuestratoma;
    private Integer utiemporespuestadiasprint;
    private Date hduracionestudio;
    private String sindicaciontomador;
    private String stemperaturamuestra;
    private String smotivorechazo;
}
