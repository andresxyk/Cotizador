package com.gda.cotizador.service.impl.bitacora;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.gda.cotizador.dto.bitacora.TBitacoraApiDto;
import com.gda.cotizador.service.bitacora.Bitacora;
import com.google.gson.Gson;

@Service
public class BitacoraServiceImpl implements Bitacora{

	final static Logger logger = LogManager.getLogger(BitacoraServiceImpl.class);
	
	@Autowired
	private Environment env;
	
	private Gson gson = new Gson();
	
	@Override
	public String bitacoraApis(TBitacoraApiDto dto) {
		try { 
			RestTemplate rt = new RestTemplate();
			String url = env.getProperty("url.service.bitacora.apis");			
			RequestEntity<String> requestEntity = RequestEntity.post(new URL(url).toURI()).contentType(MediaType.APPLICATION_JSON).body(gson.toJson(dto)); 
			ResponseEntity<String> response = rt.exchange(requestEntity, String.class);
			logger.info(response.getBody());
			return response.getBody();
		} catch (RestClientResponseException e) {
			logger.error("Error: en la RestClientResponseException");
			logger.error("Error: " + e.getResponseBodyAsString());
			return null;
		} catch (Exception e) {
			logger.error("Error: en la Exception");
			logger.error("Error: " + e.getMessage());

			return null;
		}
	}
	
}
