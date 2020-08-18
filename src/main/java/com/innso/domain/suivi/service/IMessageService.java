package com.innso.domain.suivi.service;

import com.innso.domain.suivi.model.Canal;
import com.innso.domain.suivi.model.Message;
import java.util.Optional;
import java.util.UUID;
import javassist.NotFoundException;

public interface IMessageService {

  Message create(String auteur, String contenu, Canal canal, Optional<UUID> dossierUuidOpt)
      throws NotFoundException;

  Optional<Message> findBy(UUID uuid);
}
