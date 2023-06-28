package com.gda.cotizador.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.sql.Connection;


import com.gda.cotizador.dto.ExamenConfigDto;

import net.sf.jasperreports.engine.JRException;

@Service
public class GeneralUtil {

	final static Logger logger = LogManager.getLogger(GeneralUtil.class);
	@Autowired
	private Environment env;
	
	public String getAcuseUUID() {
		return UUID.randomUUID().toString();
	}
	
	public String formatDate(String format, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public String calcularFechaPromesa(ExamenConfigDto configDto) {
		logger.info(configDto.toString());
		Integer dias = 1;
		List<Integer> listDiasDisponibles = new ArrayList<>();
		if(configDto.getBlunes()) {
			listDiasDisponibles.add(Calendar.MONDAY);
		}
		if(configDto.getBmartes()) {
			listDiasDisponibles.add(Calendar.TUESDAY);
		}
		if(configDto.getBmiercoles()) {
			listDiasDisponibles.add(Calendar.WEDNESDAY);
		}
		if(configDto.getBjueves()) {
			listDiasDisponibles.add(Calendar.THURSDAY);
		}
		if(configDto.getBviernes()) {
			listDiasDisponibles.add(Calendar.FRIDAY);
		}
		if(configDto.getBsabado()) {
			listDiasDisponibles.add(Calendar.SATURDAY);
		}
		if(configDto.getBdomingo()) {
			listDiasDisponibles.add(Calendar.SUNDAY);
		}
		logger.info(listDiasDisponibles);
		Calendar calendar = Calendar.getInstance();
		while (dias<=configDto.getUtiemporespuestadiasprint()) {
//			logger.info("dia="+calendar.get(Calendar.DAY_OF_WEEK)+"    count="+dias);
			if(listDiasDisponibles.contains(calendar.get(Calendar.DAY_OF_WEEK))) {
				dias++;
			}
			calendar.add(Calendar.DAY_OF_YEAR, 1);
		}
		return formatDate("dd-MM-yyyy", calendar.getTime());
	}
}
