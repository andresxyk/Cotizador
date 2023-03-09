package com.gda.cotizador.service.impl.dominio;

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
    public GDAMenssageDto setForGdaMessage(Integer estusCode,String message,String description);
}
