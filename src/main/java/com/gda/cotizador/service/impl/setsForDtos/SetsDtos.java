package com.gda.cotizador.service.impl.setsForDtos;

import org.springframework.beans.factory.annotation.Autowired;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.service.impl.dominio.SetsDtosImpl;
import com.gda.cotizador.utils.GeneralUtil;

public class SetsDtos implements SetsDtosImpl{
    
	@Autowired
	private GeneralUtil generalUtil;
    

    /**
     * Funcion para setear el objeto de GDAMenssageDto
     * 
     * @param estusCode
     * @param message
     * @param description
     * @return GDAMenssageDto regresa el objeto seteado GDAMenssageDto
     */
    @Override
    public GDAMenssageDto setForGdaMessage(Integer estusCode,String message,String description){
        GDAMenssageDto gdaMessage = new GDAMenssageDto();
		gdaMessage.setCodeHttp(estusCode);
		gdaMessage.setMenssage(message);
		gdaMessage.setDescripcion(description);
		gdaMessage.setAcuse(generalUtil.getAcuseUUID());
        return gdaMessage;
    }
}
