package com.innso.infrastructure.dao.impl;

import com.innso.domain.suivi.model.Message;
import com.innso.infrastructure.dao.IMessageDao;
import com.innso.infrastructure.repository.MessageRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MessageDao implements IMessageDao {

  @Autowired
  private MessageRepository repository;

  @Override
  public Message create(Message message) {

    return repository.save(message);
  }

  @Override
  public Optional<Message> findBy(UUID uuid) {
    return repository.findById(uuid);
  }
}
