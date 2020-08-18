package com.innso.infrastructure.dao.impl;

import com.innso.domain.suivi.model.DossierClient;
import com.innso.infrastructure.dao.IDossierClientDao;
import com.innso.infrastructure.repository.DossierClientRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DossierClientDao implements IDossierClientDao {

  @Autowired
  private DossierClientRepository repository;

  @Override
  public DossierClient create(DossierClient dossierClient) {
    return repository.save(dossierClient);
  }

  @Override
  public Optional<DossierClient> findBy(UUID uuid) {
    return repository.findById(uuid);
  }

  @Override
  public List<DossierClient> findAll() {
    return repository.findAll();
  }
}
