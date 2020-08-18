package com.innso.domain.suivi.service;

import com.innso.domain.suivi.model.DossierClient;
import java.util.List;
import java.util.UUID;
import javassist.NotFoundException;

public interface IDossierClientService {

  DossierClient create(UUID messageUuid) throws IllegalArgumentException, NotFoundException;

  DossierClient update(UUID dossierUuid, String reference) throws NotFoundException;

  List<DossierClient> findAll();

  DossierClient findById(UUID uuid) throws NotFoundException;
}
