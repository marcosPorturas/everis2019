package com.app.hospital.core.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngresoBoletaResponse {

   private Integer idIngreso;
   private String Socio;
   private Integer numInvitado;
   private Integer costoInvitado;
   
   @JsonIgnore
   private double costoIngreso;
  
  
}
