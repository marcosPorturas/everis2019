package com.app.hospital.core.service;

import java.util.List;

import com.app.hospital.core.dto.response.SocioResponse;
import com.app.hospital.core.entity.Socio;

public interface SocioService {
  
  List<SocioResponse> allSocio();
  Socio addSocio(Socio socio);
  Socio findSocio(Integer idsocio);
  void deleteSocio(Integer idsocio);
  Integer generatedIdSocio();

  
}
