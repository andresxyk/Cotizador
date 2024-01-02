package com.gda.cotizador.service.impl.dominio;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dto.requestPacienteMembresia.RequestPacienteMembresiaDto;
import com.gda.cotizador.dto.requestSucursal.SucursalDto;
import com.gda.cotizador.service.dominio.PacienteMembresia;

@Service
public class PacienteMembresiaServiceImpl implements PacienteMembresia {

	final static Logger logger = LogManager.getLogger(PacienteMembresiaServiceImpl.class);

	@Autowired
	private IConsultasDao consultasDao;
	@Autowired
	private Environment env;
	@Autowired
	
	@Override
	public RequestPacienteMembresiaDto procesarPacienteMembresia(RequestPacienteMembresiaDto request) throws Exception {
		if (env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
			List<SucursalDto> list = consultasDao.getListSearchSucursalDto(request.getFiltro(),
					request.getHeader().getMarca());
			request.setSucursales(list);
		} else {
			throw new Exception("El token es incorrecto, favor de validar el acceso.");
		}
		return request;
	}	
}
