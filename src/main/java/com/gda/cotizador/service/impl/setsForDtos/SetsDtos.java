package com.gda.cotizador.service.impl.setsForDtos;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.gda.cotizador.dto.cotizasion.TOrdenExamenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizasion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.service.impl.dominio.SetsDtosImpl;
import com.gda.cotizador.utils.GeneralUtil;
import org.springframework.stereotype.Service;

@Service
public class SetsDtos implements SetsDtosImpl {

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
    public GDAMenssageDto setForGdaMessage(Integer estusCode, String message, String description) {
        GDAMenssageDto gdaMessage = new GDAMenssageDto();
        gdaMessage.setCodeHttp(estusCode);
        gdaMessage.setMenssage(message);
        gdaMessage.setDescripcion(description);
        gdaMessage.setAcuse(generalUtil.getAcuseUUID());
        return gdaMessage;
    }

    @Override
    public TOrdenExamenSucursalCotizacionDto setForTOrdenExamenSucursalCotizacionDto(Integer Kordensucursalcotizacion,Integer Cexamen, 
                    String Sexamen,BigDecimal Msubtotal,BigDecimal Mdescuentopromocion,BigDecimal Mdescuentoempresa,BigDecimal Mdescuentomedico, BigDecimal Mfacturaempresa,
                    BigDecimal Mpagopaciente,BigDecimal Miva,BigDecimal Mtotal, Integer Userid,Integer Cestadoregistro,Integer Cconvenio,
                    String Smotivocancelacion, Integer Cperfil,Integer Uvolumenexamen) {
        TOrdenExamenSucursalCotizacionDto toesc = new TOrdenExamenSucursalCotizacionDto();
        toesc.setKordensucursalcotizacion(Kordensucursalcotizacion);
        toesc.setCexamen(Cexamen);
        toesc.setSexamen(Sexamen);
        toesc.setMsubtotal(Msubtotal);
        toesc.setMdescuentopromocion(Mdescuentopromocion);
        toesc.setMdescuentoempresa(Mdescuentoempresa);
        toesc.setMdescuentomedico(Mdescuentomedico);
        toesc.setMfacturaempresa(Mfacturaempresa);
        toesc.setMpagopaciente(Mpagopaciente);
        toesc.setMiva(Miva);
        toesc.setMtotal(Mtotal);
        toesc.setMtotal(Mtotal);
        toesc.setCestadoregistro(Cestadoregistro);
        toesc.setDregistro(new Date());
        toesc.setCconvenio(Cconvenio);
        toesc.setSmotivocancelacion(Smotivocancelacion);
        toesc.setCperfil(Cperfil);
        toesc.setUvolumenexamen(Uvolumenexamen);

        return toesc;
    }

    @Override
    public TOrdenSucursalCotizacionDto setForTOrdenSucursalCotizacionDto(Integer Kordensucursal,Integer Cmarca,String Ssucursal,Integer Csucursalm,Integer Csucursaldestino,Integer Kpaciente,
                    Integer Cmedico,String Smedico,BigDecimal Msubtotalm,BigDecimal Mdescuentopromocion,BigDecimal Mdescuentoempresa,BigDecimal Mdescuentomedico,
                    BigDecimal Mfacturaempresa,BigDecimal Mpagopaciente,BigDecimal Miva,BigDecimal Piva,BigDecimal Mtotal,Integer Userid,Integer Cestadoregistro,
                    String Sobservacion,Integer Cconvenio,Integer Useridchange,Integer Kordensucursalcotizacion){
        TOrdenSucursalCotizacionDto ordenCotizacionDto = new TOrdenSucursalCotizacionDto();
		ordenCotizacionDto.setKordensucursal(Kordensucursal);
		ordenCotizacionDto.setCmarca(Cmarca);
		ordenCotizacionDto.setSsucursal(Ssucursal);
		ordenCotizacionDto.setCsucursal(Csucursalm);
		ordenCotizacionDto.setCsucursaldestino(Csucursaldestino);
        ordenCotizacionDto.setKpaciente(Kpaciente);
		ordenCotizacionDto.setCmedico(Cmedico);
		ordenCotizacionDto.setSmedico(Smedico);
		ordenCotizacionDto.setMsubtotal(Msubtotalm);
		ordenCotizacionDto.setMdescuentopromocion(Mdescuentopromocion);
		ordenCotizacionDto.setMdescuentoempresa(Mdescuentoempresa);
		ordenCotizacionDto.setMdescuentomedico(Mdescuentomedico);
		ordenCotizacionDto.setMfacturaempresa(Mfacturaempresa);
		ordenCotizacionDto.setMpagopaciente(Mpagopaciente);
		ordenCotizacionDto.setMiva(Miva);
		ordenCotizacionDto.setPiva(Piva);
		ordenCotizacionDto.setMtotal(Mtotal);
		ordenCotizacionDto.setUserid(Userid);
		ordenCotizacionDto.setCestadoregistro(Cestadoregistro);
		ordenCotizacionDto.setDregistro(new Date());
		ordenCotizacionDto.setSobservacion(Sobservacion);		
		ordenCotizacionDto.setCconvenio(Cconvenio);
		ordenCotizacionDto.setUseridchange(Useridchange);
		ordenCotizacionDto.setKordensucursalcotizacion(Kordensucursalcotizacion);

        return ordenCotizacionDto;
    }
}
