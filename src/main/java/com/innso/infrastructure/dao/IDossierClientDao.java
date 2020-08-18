package com.innso.infrastructure.dao;

import com.innso.domain.suivi.model.DossierClient;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDossierClientDao {

  DossierClient create(DossierClient dossierClient);

  Optional<DossierClient> findBy(UUID uuid);

  List<DossierClient> findAll();
}
