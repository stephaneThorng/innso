package com.innso.infrastructure.dao;

import com.innso.domain.suivi.model.Message;
import java.util.Optional;
import java.util.UUID;

public interface IMessageDao {

  Message create(Message message);

  Optional<Message> findBy(UUID uuid);
}
