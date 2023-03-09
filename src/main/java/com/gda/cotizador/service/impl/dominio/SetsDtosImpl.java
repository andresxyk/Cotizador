package com.gda.cotizador.service.impl.dominio;

import java.math.BigDecimal;

import com.gda.cotizador.dto.cotizasion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.general.GDAMenssageDto;

public interface SetsDtosImpl {
     /**
     * Funcion para setear el objeto de GDAMenssageDto
     * 
     * @param estusCode
     * @param message
     * @param description
     * @return GDAMenssageDto regresa el objeto seteado GDAMenssageDto
     */
    GDAMenssageDto setForGdaMessage(Integer estusCode,String message,String description);

    /**
     * Funcion para setera los valores al dto TOrdenExamenSucursalCotizacionDto
     * @param Kordensucursalcotizacion
     * @param Cexamen
     * @param Sexamen
     * @param Msubtotal
     * @param Mdescuentopromocion
     * @param Mdescuentoempresa
     * @param Mdescuentomedico
     * @param Mfacturaempresa
     * @param Mpagopaciente
     * @param Miva
     * @param Mtotal
     * @param Userid
     * @param Cestadoregistro
     * @param Cconvenio
     * @param Smotivocancelacion
     * @param Cperfil
     * @param Uvolumenexamen
     * @return TOrdenExamenSucursalCotizacionDto
     */
    TOrdenExamenSucursalCotizacionDto setForTOrdenExamenSucursalCotizacionDto(Integer Kordensucursalcotizacion,Integer Cexamen, 
                    String Sexamen,BigDecimal Msubtotal,BigDecimal Mdescuentopromocion,BigDecimal Mdescuentoempresa,BigDecimal Mdescuentomedico, BigDecimal Mfacturaempresa,
                    BigDecimal Mpagopaciente,BigDecimal Miva,BigDecimal Mtotal, Integer Userid,Integer Cestadoregistro,Integer Cconvenio,
                    String Smotivocancelacion, Integer Cperfil,Integer Uvolumenexamen);
}
