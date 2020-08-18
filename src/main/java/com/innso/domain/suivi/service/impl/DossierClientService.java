package com.innso.domain.suivi.service.impl;

import com.innso.domain.suivi.model.DossierClient;
import com.innso.domain.suivi.model.Message;
import com.innso.domain.suivi.service.IDossierClientService;
import com.innso.infrastructure.dao.IDossierClientDao;
import com.innso.infrastructure.dao.IMessageDao;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DossierClientService implements IDossierClientService {

  @Autowired
  private IDossierClientDao dossierDao;

  @Autowired
  private IMessageDao messageDao;

  @Override
  public DossierClient create(UUID messageUuid) throws IllegalArgumentException, NotFoundException {

    final Optional<Message> opt = messageDao.findBy(messageUuid);

    Message message = opt
        .orElseThrow(() -> new NotFoundException("le message_uuid est inconnu de notre système."));
    if (message.getDossier() != null) {
      throw new IllegalArgumentException("Le message a déjà été attribué à un dossier.");
    }

    final DossierClient dossierClient = new DossierClient();
    dossierClient.setNom(message.getAuteur());
    dossierClient.getMessages().add(message);
    message.setDossier(dossierClient);
    return dossierDao.create(dossierClient);
  }

  @Override
  public DossierClient update(UUID dossierUuid, String reference) throws NotFoundException {
    final Optional<DossierClient> dossierOpt = dossierDao.findBy(dossierUuid);
    final DossierClient dossier = dossierOpt
        .orElseThrow(() -> new NotFoundException("le uuid est inconnu de notre système."));
    dossier.setReference(reference);

    return dossierDao.create(dossier);
  }

  @Override
  public List<DossierClient> findAll() {
    return dossierDao.findAll();
  }

  @Override
  public DossierClient findById(UUID uuid) throws NotFoundException {
    final Optional<DossierClient> dossierOpt = dossierDao.findBy(uuid);
    return dossierOpt
        .orElseThrow(() -> new NotFoundException("le uuid est inconnu de notre système."));

  }


}
