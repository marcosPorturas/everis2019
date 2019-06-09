package com.app.hospital.core.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospedajeBoletaResponse {

    private Integer idHospedaje;
    private Integer idBungalow;
    private Double costoBungalow;
    private Date fechIngreso;
    private Date fechSalida;
    private Integer dias;
    
    @JsonIgnore
    private Double costoHospedaje;
  
}
