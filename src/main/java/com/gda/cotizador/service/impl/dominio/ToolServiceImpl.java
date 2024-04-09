package com.gda.cotizador.service.impl.dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dao.interfaz.IConsultaCotizacionDao;
import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dto.AccesoClienteDto;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.PerfilDto;
import com.gda.cotizador.dto.cotizacion.CExamenDto;
import com.gda.cotizador.dto.cotizacion.CodingCotizacionDto;
import com.gda.cotizador.dto.cotizacion.CotizacionDto;
import com.gda.cotizador.dto.cotizacion.TOrdenSucursalCotizacionDto;
import com.gda.cotizador.dto.cotizadorRequest.Coding;
import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
import com.gda.cotizador.dto.db.EConvenioDetalleDto;
import com.gda.cotizador.service.dominio.ToolDominio;
import com.gda.cotizador.utils.GeneralUtil;

@Service
public class ToolServiceImpl implements ToolDominio {

	final static Logger logger = LogManager.getLogger(ToolServiceImpl.class);

	private static Double tasaIVA = 1.16; // Tasa de IVA (16%)

	@Autowired
	private IConsultasDao consultasDao;
	@Autowired
	private IConsultaCotizacionDao consultasCotizacionDao;
	@Autowired
	private GeneralUtil generalUtil;
	@Autowired
	private Environment env;
	@Autowired
	private SetsDtosImpl setsDtosImpl;

	@Override
	public RequestCotizacionDto addConvenioDetalle(RequestCotizacionDto request) {
		List<Coding> lisCodings = new ArrayList<>();
		String porcentajePuntos = env.getProperty("puntos.gda.marca." + request.getHeader().getMarca());
		Boolean isPuntosGda = false;
		BigDecimal ttotal = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal tsubtotal = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal ttotalPuntos = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		for (Coding coding : request.getCode().getCoding()) {
			List<ExamenConfigDto> listExamenesConfigDto = consultasDao
					.getListSearchExamenDto(Integer.parseInt(coding.getCode()), coding.getConvenio());
			List<EConvenioDetalleDto> listECD = consultasDao.getListEConvenioDetalle(coding.getConvenio(),
					Integer.parseInt(coding.getCode()));
			logger.info("list.size():::" + listExamenesConfigDto.size());
			if (listExamenesConfigDto.size() > 0) {
				coding.setPreciolistamadretotal(listExamenesConfigDto.get(0).getMprecio());
				coding.setIndicacionespaciente(listExamenesConfigDto.get(0).getScondicionpreanalitica());
				coding.setDescuentopromocion(BigDecimal.ZERO);
				// coding.setRequiere_cita((listExamenesConfigDto.get(0).getBrequierecita())?"SI":"NO");
				if (listExamenesConfigDto.get(0).getBrequierecita()) {
					coding.setRequiere_cita("SI");
					coding.setSucursalesProcesa(
							consultasCotizacionDao.getListSucursalesProcesa(listExamenesConfigDto.get(0).getCexamen()));
				} else {
					coding.setRequiere_cita("NO");
					coding.setSucursalesProcesa(new String[] { "*" });
				}
				logger.info("listECD.size():::" + listECD.size());
				if (listECD.size() > 0) {
					coding.setSubtotal(listECD.get(0).getMpreciofacturarconiva());
					coding.setTotal(listECD.get(0).getMpreciofacturarconiva());
					coding.setPagopaciente(listECD.get(0).getMpreciofacturarconiva());
					coding.setFechaentrega(generalUtil.calcularFechaPromesa(listExamenesConfigDto.get(0)));
					if (porcentajePuntos != null) {
						isPuntosGda = true;
						BigDecimal porcentaje = new BigDecimal(porcentajePuntos);
						coding.setPuntos(
								generalUtil.calculoPuntos(listECD.get(0).getMpreciofacturarconiva(), porcentaje));
						ttotalPuntos = ttotalPuntos.add(coding.getPuntos());
					}
					ttotal = ttotal
							.add(listECD.get(0).getMpreciofacturarconiva().setScale(2, BigDecimal.ROUND_HALF_UP));
					tsubtotal = tsubtotal
							.add(listECD.get(0).getMpreciofacturarsiniva().setScale(2, BigDecimal.ROUND_HALF_UP));
				} else {
					coding.setSubtotal(listExamenesConfigDto.get(0).getMprecio());
					coding.setTotal(listExamenesConfigDto.get(0).getMprecio());
					coding.setPagopaciente(listExamenesConfigDto.get(0).getMprecio());
					coding.setFechaentrega(generalUtil.calcularFechaPromesa(listExamenesConfigDto.get(0)));

					if (porcentajePuntos != null) {
						isPuntosGda = true;
						BigDecimal porcentaje = new BigDecimal(porcentajePuntos);
						coding.setPuntos(
								generalUtil.calculoPuntos(listExamenesConfigDto.get(0).getMprecio(), porcentaje));
						ttotalPuntos = ttotalPuntos.add(coding.getPuntos());
					}
					ttotal = ttotal
							.add(listExamenesConfigDto.get(0).getMprecio().setScale(2, BigDecimal.ROUND_HALF_UP));
					tsubtotal = tsubtotal
							.add(listExamenesConfigDto.get(0).getMprecio().setScale(2, BigDecimal.ROUND_HALF_UP));
				}
			} else {
				BigDecimal ttotalPuntosPerfil = BigDecimal.ZERO;
				List<PerfilDto> listExamenesPerfil = consultasCotizacionDao
						.getListExamenesPerfil(Integer.parseInt(coding.getCode()), coding.getConvenio());
				logger.info("listExamenesPerfil.size():" + listExamenesPerfil.size());
				if (listExamenesPerfil.size() > 0) {
					BigDecimal bdSubtotal = BigDecimal.ZERO;
					BigDecimal bdTotal = BigDecimal.ZERO;
					for (PerfilDto perfilDto : listExamenesPerfil) {
						bdSubtotal = bdSubtotal.add(perfilDto.getSubtotal());
						bdTotal = bdTotal.add(perfilDto.getMpagopacienteytotal());
					}
					BigDecimal bdSubtotalTotal = bdSubtotal.divide(
							new BigDecimal(listExamenesPerfil.get(0).getNcantidadexamen()), 2, RoundingMode.HALF_UP);
					BigDecimal bdDescuentoPromocion = bdSubtotalTotal
							.subtract(listExamenesPerfil.get(0).getMpagopacienteytotal());
					for (PerfilDto perfilDto : listExamenesPerfil) {
						// BigDecimal mIVATotal = perfilDto.getMpagopacienteytotal().add(tasaIVA);
						double mIVATotal = coding.getTotal().doubleValue()
								- (coding.getTotal().doubleValue() / tasaIVA);

						if (porcentajePuntos != null) {
							isPuntosGda = true;
							BigDecimal porcentaje = new BigDecimal(porcentajePuntos);
							coding.setPuntos(generalUtil.calculoPuntos(perfilDto.getMpagopacienteytotal(), porcentaje));
							ttotalPuntosPerfil = ttotalPuntosPerfil.add(coding.getPuntos());
							ttotalPuntos = ttotalPuntos.add(coding.getPuntos());
						}
					}
					coding.setSubtotal(bdSubtotal);
					coding.setTotal(bdTotal);
					coding.setPagopaciente(bdTotal);
					coding.setFechaentrega("");

					ttotal = ttotal.add(bdTotal);
					tsubtotal = tsubtotal.add(bdSubtotal);
				}
				if (isPuntosGda) {
					coding.setPuntos(ttotalPuntosPerfil);
				}
				if (coding.getRequiere_cita().equals("NO")) {
					coding.setSucursalesProcesa(new String[] { "*" });
				}
			}
			lisCodings.add(coding);
		}
		request.getCode().setCoding(lisCodings);
		request.getRequisition().setDescuentopromocion(BigDecimal.ZERO);
		request.getRequisition().setPagopaciente(ttotal);
		request.getRequisition().setTotal(ttotal);
		request.getRequisition().setSubtotal(tsubtotal);
		request.getRequisition().setFechaentrega("");

		if (isPuntosGda) {
			request.getRequisition().setPuntos(ttotalPuntos);
		}
		return request;
	}

	@Override
	public TOrdenSucursalCotizacionDto saveTOrdenSucursalCotizacion(CotizacionDto cotizacionDto,
			AccesoClienteDto accesoClienteDto) throws Exception {
		try {
			if (consultasCotizacionDao.validationConvIndiseBran(cotizacionDto.getRequisition().getMarca(),
					cotizacionDto.getRequisition().getConvenio()) == 0) {
				throw new Exception("No existe este convenio en la marca !!!");
			}

			if (validarPaciente(cotizacionDto)) {

			}
			// if(!validateCode(cotizacionDto)){
			// throw new Exception("Exámenes de otros convenios de contado !!!");
			// }
			String patient = cotizacionDto.getSubject().getReference().substring(
					cotizacionDto.getSubject().getReference().indexOf("/") + 1,
					cotizacionDto.getSubject().getReference().length());
			String practitioner = cotizacionDto.getRequester().getReference().substring(
					cotizacionDto.getRequester().getReference().indexOf("/") + 1,
					cotizacionDto.getRequester().getReference().length());
			Integer cconvenio = cotizacionDto.getCode().getCoding().get(0).getConvenio();
			double mIVATotal = cotizacionDto.getRequisition().getTotal().doubleValue()
					- (cotizacionDto.getRequisition().getTotal().doubleValue() / tasaIVA);

			// setForTOrdenSucursalCotizacionDto
			TOrdenSucursalCotizacionDto ordenCotizacionDto = setsDtosImpl.setForTOrdenSucursalCotizacionDto(0,
					cotizacionDto.getRequisition().getMarca(),
					consultasCotizacionDao.getSSucursal(accesoClienteDto.getCsucursal()),
					accesoClienteDto.getCsucursal(), accesoClienteDto.getCsucursal(), Integer.parseInt(patient),
					Integer.parseInt(practitioner), cotizacionDto.getRequester().getDisplay(),
					cotizacionDto.getRequisition().getSubtotal(),
					cotizacionDto.getRequisition().getDescuentopromocion(), BigDecimal.ZERO, BigDecimal.ZERO,
					BigDecimal.ZERO, cotizacionDto.getRequisition().getPagopaciente(), new BigDecimal(mIVATotal),
					new BigDecimal(tasaIVA), cotizacionDto.getRequisition().getTotal(), 1, 173, "", cconvenio, 1, 0);

			Integer idCotizacion = consultasCotizacionDao.insertTOrdenSucursalCotizacion(ordenCotizacionDto);
			ordenCotizacionDto.setKordensucursalcotizacion(idCotizacion);
			return ordenCotizacionDto;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public CotizacionDto saveTordenExamenSucursalCotizacion(CotizacionDto cotizacionDto,
			TOrdenSucursalCotizacionDto ordenCotizacionDto) throws Exception {
		cotizacionDto.setGDA_menssage(setsDtosImpl.setForGdaMessage(0, " ", " "));
		List<CodingCotizacionDto> codingCotizacionDtos = new ArrayList<>();
		BigDecimal ttotalPuntos = BigDecimal.ZERO;
		Boolean isPuntosGda = true;
		String porcentajePuntos = env.getProperty("puntos.gda.marca." + cotizacionDto.getRequisition().getMarca());
		for (CodingCotizacionDto coding : cotizacionDto.getCode().getCoding()) {
			coding.setPuntos(BigDecimal.ZERO);
			try {
				// BigDecimal mIVATotal = coding.getTotal().add(tasaIVA);
				double mIVATotal = coding.getTotal().doubleValue() - (coding.getTotal().doubleValue() / tasaIVA);

				if (cotizacionDto.getRequisition().getMarca() == 16) {
					List<CExamenDto> examenDto = consultasCotizacionDao.getListCExamenDto2(coding.getCode(),
							cotizacionDto.getRequisition().getConvenio());

					if (examenDto != null && examenDto.size() > 0) {
						if (porcentajePuntos != null) {
							isPuntosGda = true;
							BigDecimal porcentaje = new BigDecimal(porcentajePuntos);
							coding.setPuntos(generalUtil.calculoPuntos(coding.getTotal(), porcentaje));
							ttotalPuntos = ttotalPuntos.add(coding.getPuntos());
						}
						consultasCotizacionDao.insertTOrdenExamenSucursalCotizacion(
								setsDtosImpl.setForTOrdenExamenSucursalCotizacionDto(
										ordenCotizacionDto.getKordensucursalcotizacion(), examenDto.get(0).getCexamen(),
										examenDto.get(0).getSexamen(), coding.getSubtotal(),
										coding.getDescuentopromocion(), BigDecimal.ZERO, BigDecimal.ZERO,
										BigDecimal.ZERO, coding.getPagopaciente(), new BigDecimal(mIVATotal),
										coding.getTotal(), 1, 13, coding.getConvenio(), "", -1, 1));
					} else {
						logger.error("ERROR:El estudio no se encuentra en convenio");
						throw new Exception("El estudio " + coding.getCode() + " no se encuentra en conveino ");
						// cotizacionDto.setGDA_menssage(setsDtosImpl.setForGdaMessage(400,"error",cotizacionDto.getGDA_menssage()
						// + "\nEl estudio " + coding.getCode()+ " no se encuentra en convenio."));
					}
				} else {
					// logger.info("antes de validad el examne "+coding.getCode());
					// if(){
					// logger.error("Examen no corresponde a la marca: " + coding.getCode());
					// throw new Exception("Examen no corresponde a la marca");
					//
					// }
					if (!consultasCotizacionDao.validarExamenConvenio(coding)
							&& consultasCotizacionDao.validationConvIndiseExamn(
									cotizacionDto.getRequisition().getConvenio(), coding.getCode()) == 0) {

						logger.error("ERROR:El estudio no se encuentra en convenio");
						throw new Exception("No se encontraron registros con el perfil " + coding.getCode()
								+ " en el convenio " + coding.getConvenio());
					} else {
						if (porcentajePuntos != null) {
							isPuntosGda = true;
							BigDecimal porcentaje = new BigDecimal(porcentajePuntos);
							coding.setPuntos(generalUtil.calculoPuntos(coding.getTotal(), porcentaje));
							ttotalPuntos = ttotalPuntos.add(coding.getPuntos());
						}
						consultasCotizacionDao.insertTOrdenExamenSucursalCotizacion(
								setsDtosImpl.setForTOrdenExamenSucursalCotizacionDto(
										ordenCotizacionDto.getKordensucursalcotizacion(),
										Integer.parseInt(coding.getCode()), coding.getDisplay(), coding.getSubtotal(),
										coding.getDescuentopromocion(), BigDecimal.ZERO, BigDecimal.ZERO,
										BigDecimal.ZERO, coding.getPagopaciente(), new BigDecimal(mIVATotal),
										coding.getTotal(), 1, 13, coding.getConvenio(), "", -1, 1));
					}
				}
			} catch (Exception e) {
				if (cotizacionDto.getRequisition().getMarca() != 16) {
					BigDecimal ttotalPuntosPerfil = BigDecimal.ZERO;
					List<PerfilDto> listExamenesPerfil = consultasCotizacionDao
							.getListExamenesPerfil(Integer.parseInt(coding.getCode()), coding.getConvenio());
					if (listExamenesPerfil.size() > 0) {
						BigDecimal bdSubtotal = BigDecimal.ZERO;
						for (PerfilDto perfilDto : listExamenesPerfil) {
							bdSubtotal = bdSubtotal.add(perfilDto.getSubtotal());
						}
						BigDecimal bdSubtotalTotal = bdSubtotal.divide(
								new BigDecimal(listExamenesPerfil.get(0).getNcantidadexamen()), 2,
								RoundingMode.HALF_UP);
						BigDecimal bdDescuentoPromocion = bdSubtotalTotal
								.subtract(listExamenesPerfil.get(0).getMpagopacienteytotal());
						for (PerfilDto perfilDto : listExamenesPerfil) {
							// BigDecimal mIVATotal = perfilDto.getMpagopacienteytotal().add(tasaIVA);
							double mIVATotal = coding.getTotal().doubleValue()
									- (coding.getTotal().doubleValue() / tasaIVA);

							if (porcentajePuntos != null) {
								isPuntosGda = true;
								BigDecimal porcentaje = new BigDecimal(porcentajePuntos);
								coding.setPuntos(
										generalUtil.calculoPuntos(perfilDto.getMpagopacienteytotal(), porcentaje));
								ttotalPuntosPerfil = ttotalPuntosPerfil.add(coding.getPuntos());
								ttotalPuntos = ttotalPuntos.add(coding.getPuntos());
							}

							consultasCotizacionDao.insertTOrdenExamenSucursalCotizacion(
									setsDtosImpl.setForTOrdenExamenSucursalCotizacionDto(
											ordenCotizacionDto.getKordensucursalcotizacion(), perfilDto.getCexamen(),
											perfilDto.getSexamen(), bdSubtotalTotal, bdDescuentoPromocion,
											BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
											perfilDto.getMpagopacienteytotal(), BigDecimal.ZERO,
											perfilDto.getMpagopacienteytotal(), 1, 13, perfilDto.getCconvenio(), "",
											perfilDto.getCperfil(), perfilDto.getUvolumenexamen()));
						}
					} else {
						throw new Exception("No se encontraron registros con el perfil " + coding.getCode()
								+ " en el convenio " + coding.getConvenio());
					}
					if (isPuntosGda) {
						coding.setPuntos(ttotalPuntosPerfil);
					}
				}
			}
			codingCotizacionDtos.add(coding);
		}

		cotizacionDto.getCode().setCoding(codingCotizacionDtos);
		cotizacionDto.getRequisition().setPuntos(ttotalPuntos);
		return cotizacionDto;
	}
	// public boolean validarExamen(CodingDto coding) throws Exception {
	// // for (CodingDto coding : cotizacionDto.getCode().getCoding()) {
	// if ( == false) {
	// logger.info("Validación de examen por convenio");
	// // logger.info("Examen: " + coding.getCode());
	// // logger.info("Convenio: " + coding.getConvenio());
	// // throw new Exception("No se encontraron registros con el perfil " +
	// coding.getCode()
	// // + " en el convenio " + coding.getConvenio());
	// return false;
	// }
	// // }
	// return true;
	// }

	public boolean validarPaciente(CotizacionDto cotizacionDto) throws Exception {
		for (CodingCotizacionDto coding : cotizacionDto.getCode().getCoding()) {
			String patient = cotizacionDto.getSubject().getReference().substring(
					cotizacionDto.getSubject().getReference().indexOf("/") + 1,
					cotizacionDto.getSubject().getReference().length());
			if (consultasCotizacionDao.validarPacienteMarca(cotizacionDto.getRequisition().getMarca(),
					patient) == false) {
				logger.info("Entrando a la validación de examen por paciente");
				logger.info("Marca: " + cotizacionDto.getRequisition().getMarca());
				logger.info("Paciente: " + patient);
				throw new Exception("El paciente " + patient + " no pertenece a la marca "
						+ cotizacionDto.getRequisition().getMarca());
			}
		}
		return true;
	}

	public List<ExamenConfigDto> agruparPorExamen(List<ExamenConfigDto> listExamenConfig) {
		if(listExamenConfig.size()>0) {			
			Map<Integer, ExamenConfigDto> mapaAgrupado = new HashMap<>();
			for (ExamenConfigDto examen : listExamenConfig) {
				int cexamen = examen.getCexamen();
				
				if (mapaAgrupado.containsKey(cexamen)) {
					// Si ya existe en el mapa, acumula la información
					ExamenConfigDto examenExistente = mapaAgrupado.get(cexamen);
					examenExistente.agregarPrecioConvenio(examen.getCconvenio(), examen.getMprecio());
				} else {
					// Si no existe en el mapa, agrega el examen
					mapaAgrupado.put(cexamen, new ExamenConfigDto(examen));
				}
			}
			List<ExamenConfigDto> newlistAgrupada = new ArrayList<>(mapaAgrupado.values());
			// Crear un comparador compuesto que primero compara por cexamen y luego por sexamen
			Comparator<ExamenConfigDto> comparador = Comparator
	                .comparingInt(ExamenConfigDto::getCexamen)
	                .thenComparing(ExamenConfigDto::getSexamen);

	        // Ordenar la lista utilizando el comparador compuesto
	        Collections.sort(newlistAgrupada, comparador);
			
			return newlistAgrupada;
		}else {
			return new ArrayList<>();
		}
	}

	// public Boolean validateCode(CotizacionDto _cotizacionDto) throws Exception{
	// try{
	// for (CodingDto coding : _cotizacionDto.getCode().getCoding()) {
	// if(consultasCotizacionDao.validationConvIndiseExamn(_cotizacionDto.getRequisition().getConvenio(),coding.getCode())
	// == 0){
	// logger.error("Examen no corresponde a la marca: " + coding.getCode());
	// throw new Exception("Examen no corresponde a la marca");
	// }
	// }
	// return true;
	// }catch(Exception e){
	// logger.error("Error en la funcion validateCode");
	// throw e;
	// }

	// }
}
