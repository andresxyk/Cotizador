package com.gda.cotizador.dto.requestSucursal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distance {

    @Schema(description = "Resulado en Kilometros")
    private double Kilometers;
}