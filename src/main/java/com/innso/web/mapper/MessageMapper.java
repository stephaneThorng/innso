package com.innso.web.mapper;

import com.github.dozermapper.core.Mapper;
import com.innso.domain.suivi.model.Message;
import com.innso.web.dto.MessageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

  @Autowired
  private Mapper mapper;

  public MessageResponseDto mapFrom(Message message) {
    return mapper.map(message, MessageResponseDto.class);
  }
}
