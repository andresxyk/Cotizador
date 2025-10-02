/**
 * 
 */
package com.gda.cotizador.service.dominio.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.service.dominio.ToolDominio;

/**
 * 
 */
@Service
public class ToolServiceImpl implements ToolDominio {
	
	public List<ExamenConfigDto> agruparPorExamen(List<ExamenConfigDto> listExamenConfig) {
	    if (listExamenConfig.size() > 0) {
	      Map<Integer, ExamenConfigDto> mapaAgrupado = new HashMap<>();
	      for (ExamenConfigDto examen : listExamenConfig) {
	        int cexamen = examen.getCexamen().intValue();
	        if (mapaAgrupado.containsKey(Integer.valueOf(cexamen))) {
	          ExamenConfigDto examenExistente = mapaAgrupado.get(Integer.valueOf(cexamen));
	          examenExistente.agregarPrecioConvenio(examen.getCconvenio(), examen.getMprecio());
	          continue;
	        } 
	        mapaAgrupado.put(Integer.valueOf(cexamen), new ExamenConfigDto(examen));
	      } 
	      List<ExamenConfigDto> newlistAgrupada = new ArrayList<>(mapaAgrupado.values());
	      Comparator<ExamenConfigDto> comparador = Comparator.comparingInt(ExamenConfigDto::getCexamen).thenComparing(ExamenConfigDto::getSexamen);
	      Collections.sort(newlistAgrupada, comparador);
	      return newlistAgrupada;
	    } 
	    return new ArrayList<>();
	  }

}
