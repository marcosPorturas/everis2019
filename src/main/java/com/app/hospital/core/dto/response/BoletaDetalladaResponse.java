package com.app.hospital.core.dto.response;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletaDetalladaResponse {
	
	private Integer idBoleta;
	private Date fechPago;
	private IngresoBoletaResponse ingreso;
	private HospedajeBoletaResponse hospedaje;
	List<ConsumoResponse> consumos;
	private Double totalIngreso;
	private Double totalConsumo;
	private Double totalHospedaje;
	private Double totalBoleta;
	


}
