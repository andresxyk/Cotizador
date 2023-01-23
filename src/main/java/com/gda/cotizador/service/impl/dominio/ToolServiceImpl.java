package com.gda.cotizador.service.impl.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.cotizador.Coding;
import com.gda.cotizador.dto.cotizador.RequestCotizacionDto;
import com.gda.cotizador.dto.db.EConvenioDetalleDto;
import com.gda.cotizador.service.dominio.ToolDominio;
import com.gda.cotizador.utils.GeneralUtil;

@Service
public class ToolServiceImpl implements ToolDominio{

	final static Logger logger = LogManager.getLogger(ToolServiceImpl.class);
	
	@Autowired
	private IConsultasDao consultasDao;
	@Autowired
	private GeneralUtil generalUtil;
	
	@Override
	public RequestCotizacionDto addConvenioDetalle(RequestCotizacionDto request) {
		List<Coding> lisCodings = new ArrayList<>();
		BigDecimal ttotal= BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal tsubtotal= BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
		for (Coding coding : request.getCode().getCoding()) {
			List<ExamenConfigDto> list = consultasDao.getListSearchExamenDto(Integer.parseInt(coding.getCode()), coding.getConvenio());
			List<EConvenioDetalleDto> listECD = consultasDao.getListEConvenioDetalle(coding.getConvenio(), Integer.parseInt(coding.getCode()));
			if(list.size()>0) {
				if(listECD.size()>0) {
					coding.setPreciolistamadretotal(list.get(0).getMprecio());
					coding.setIndicacionespaciente(list.get(0).getScondicionpreanalitica());
					coding.setSubtotal(listECD.get(0).getMpreciofacturarsiniva());
					coding.setTotal(listECD.get(0).getMpreciofacturarconiva());
					coding.setDescuentopromocion(BigDecimal.ZERO);
					coding.setPagopaciente(listECD.get(0).getMpreciofacturarconiva());
					coding.setFechaentrega(generalUtil.calcularFechaPromesa(list.get(0)));
					ttotal = ttotal.add(listECD.get(0).getMpreciofacturarconiva().setScale(2, BigDecimal.ROUND_HALF_UP));
					tsubtotal = tsubtotal.add(listECD.get(0).getMpreciofacturarsiniva().setScale(2, BigDecimal.ROUND_HALF_UP));
				}else {
					coding.setPreciolistamadretotal(list.get(0).getMprecio());
					coding.setIndicacionespaciente(list.get(0).getScondicionpreanalitica());
					coding.setSubtotal(list.get(0).getMpreciosiniva());
					coding.setTotal(list.get(0).getMprecio());
					coding.setDescuentopromocion(BigDecimal.ZERO);
					coding.setPagopaciente(list.get(0).getMprecio());
					coding.setFechaentrega(generalUtil.calcularFechaPromesa(list.get(0)));
					ttotal = ttotal.add(list.get(0).getMprecio().setScale(2, BigDecimal.ROUND_HALF_UP));
					tsubtotal = tsubtotal.add(list.get(0).getMpreciosiniva().setScale(2, BigDecimal.ROUND_HALF_UP));					
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
		return request;
	}
	
}
