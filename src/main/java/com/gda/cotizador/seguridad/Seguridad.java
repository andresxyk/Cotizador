package com.gda.cotizador.seguridad;

import java.util.Base64;
import java.security.Key;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dao.interfaz.IConsultaCotizacionDao;
import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.seguridad.UssersDTO;

import ch.qos.logback.classic.Logger;


@Service
public class Seguridad {

    private static String ENCRYPT_KEY = Base64.getEncoder().encodeToString("GDA_2023_API".getBytes());

    @Autowired
	private IConsultaCotizacionDao consultasDao;	

    public List<AccesoClienteDto> accesoCliente(String token) throws Exception{
        List<AccesoClienteDto> Acceso = null;
        try{
            UssersDTO getDataUsers = getUsuarioData(descripTocken(token));
            Acceso = consultasDao.getListAccesoCliente(getDataUsers);
		    return Acceso;
        }catch(Exception e){
            return Acceso;
        }
		
	}

    private String descripTocken(String tocken) throws Exception{
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(tocken.replace("\n", ""));

            Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);

            String token = new String(cipher.doFinal(encryptedBytes));

            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private UssersDTO getUsuarioData(String cadena){
        UssersDTO userDto = new UssersDTO();
        
        String[] data =  cadena.split("&",2);

        String[] user = data[0].split("=");
        String[] password = data[1].split("=");
        
        userDto.setUser(user[1]);
        userDto.setPassword(password[1]);

        return userDto;
    }
}
