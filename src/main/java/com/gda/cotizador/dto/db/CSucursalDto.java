package com.gda.cotizador.dto.db;

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
public class CSucursalDto {

	private Integer csucursal;
    private String ssucursal;
    private String snombresucursal;
    private String sdireccion;
    private Integer ccodigopostal;
    private Integer cmarca;
    private String stelefono;
    private String snombresucursalweb;
    private String  erpscuentasucursal;
    private Integer czonasucursal;
    private Integer uorderby;
    private String sclavesucursal;
    private String shorariolaboralsemana;
    private String shorarioentregaresultadossemana;
    private String shorariolaboralfinsemana;
    private String shorarioentregaresultadosfinsemana;
    private String sunidadnegocioerp;
    private String smarcaerp;
    private String sunidadnegocioarerp;
    private String sunidadnegocioglerp;
    private String sidunidadoperativaerp;
    private String ssucursalalterna;
}
