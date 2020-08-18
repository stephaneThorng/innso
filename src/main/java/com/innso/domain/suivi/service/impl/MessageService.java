package com.innso.domain.suivi.service.impl;

import com.innso.domain.suivi.model.Canal;
import com.innso.domain.suivi.model.DossierClient;
import com.innso.domain.suivi.model.Message;
import com.innso.domain.suivi.service.IMessageService;
import com.innso.infrastructure.dao.IDossierClientDao;
import com.innso.infrastructure.dao.IMessageDao;
import java.util.Optional;
import java.util.UUID;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {

  @Autowired
  private IMessageDao messageDao;

  @Autowired
  private IDossierClientDao dossierDao;

  @Override
  public Message create(String auteur, String contenu, Canal canal, Optional<UUID> dossierUuidOpt)
      throws NotFoundException {
    final Message message = new Message();
    message.setAuteur(auteur);
    message.setContenu(contenu);
    message.setCanal(canal);

    if (dossierUuidOpt.isPresent()) {
      final Optional<DossierClient> dossierOpt = dossierDao.findBy(dossierUuidOpt.get());
      if (dossierOpt.isPresent()) {
        DossierClient dossier = dossierOpt.orElseThrow(
            () -> new NotFoundException("le message_uuid est inconnu de notre système."));
        dossier.getMessages().add(message);
        message.setDossier(dossier);
      }
    }
    return messageDao.create(message);
  }

  @Override
  public Optional<Message> findBy(UUID uuid) {
    return messageDao.findBy(uuid);

  }
}
