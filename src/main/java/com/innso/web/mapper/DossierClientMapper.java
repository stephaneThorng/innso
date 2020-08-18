package com.innso.web.mapper;

import com.github.dozermapper.core.Mapper;
import com.innso.domain.suivi.model.DossierClient;
import com.innso.web.dto.DossierCreateResponseDto;
import com.innso.web.dto.DossierDto;
import com.innso.web.dto.DossierUpdateResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DossierClientMapper {

  @Autowired
  private Mapper mapper;

  public DossierCreateResponseDto mapCreateFrom(DossierClient dossier) {
    return mapper.map(dossier, DossierCreateResponseDto.class);
  }

  public DossierUpdateResponseDto mapUpdateFrom(DossierClient dossier) {
    return mapper.map(dossier, DossierUpdateResponseDto.class);
  }

  public DossierDto mapDossierFrom(DossierClient dossier) {
    return mapper.map(dossier, DossierDto.class);
  }
}
