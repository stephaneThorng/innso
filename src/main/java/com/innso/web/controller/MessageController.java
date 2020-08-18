package com.innso.web.controller;

import com.innso.domain.suivi.model.Message;
import com.innso.domain.suivi.service.IMessageService;
import com.innso.web.dto.MessageRequestDto;
import com.innso.web.mapper.MessageMapper;
import java.util.Optional;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({MessageController.URL_PATH})
@Slf4j
public class MessageController {

  static final String URL_PATH = "/api/message";

  @Autowired
  private MessageMapper mapper;

  @Autowired
  private IMessageService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity create(@RequestBody MessageRequestDto inputDto) throws NotFoundException {
    log.info("creation d'un message... {}", inputDto);
    
    final Message message = service
        .create(inputDto.getAuteur(), inputDto.getContenu(), inputDto.getCanal(),
            Optional.ofNullable(inputDto.getDossierUuid()));
    return ResponseEntity
        .ok(mapper.mapFrom(message));
  }


}
