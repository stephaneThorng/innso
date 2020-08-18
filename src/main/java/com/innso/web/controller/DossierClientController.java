package com.innso.web.controller;

import com.innso.domain.suivi.model.DossierClient;
import com.innso.domain.suivi.service.IDossierClientService;
import com.innso.web.dto.DossierCreateRequestDto;
import com.innso.web.dto.DossierDto;
import com.innso.web.dto.DossierUpdateRequestDto;
import com.innso.web.mapper.DossierClientMapper;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({DossierClientController.URL_PATH})
@Slf4j
public class DossierClientController {

  static final String URL_PATH = "/api/dossier";

  @Autowired
  private DossierClientMapper mapper;

  @Autowired
  private IDossierClientService service;

  @GetMapping
  public ResponseEntity<List<DossierDto>> findAll() {

    final List<DossierClient> dossiers = service.findAll();
    final List<DossierDto> results = dossiers.stream().map(d -> mapper.mapDossierFrom(d))
        .collect(Collectors.toList());
    return ResponseEntity.ok(results);

  }

  @GetMapping(value = "/{uuid}")
  public ResponseEntity findById(@PathVariable("uuid") UUID uuid) throws NotFoundException {
    DossierClient dossier = service.findById(uuid);
    return ResponseEntity.ok(mapper.mapDossierFrom(dossier));
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity create(@RequestBody DossierCreateRequestDto requestDto)
      throws IllegalArgumentException, NotFoundException {
    log.info("creation d'un dossier... {}", requestDto);

    final DossierClient dossier;
    dossier = service
        .create(requestDto.getMessageUuid());

    return ResponseEntity
        .ok(mapper.mapCreateFrom(dossier));
  }

  @PatchMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity update(@RequestBody DossierUpdateRequestDto requestDto)
      throws NotFoundException {

    log.info("mise à jour d'un dossier... {}", requestDto);

    final DossierClient dossier;
    dossier = service
        .update(requestDto.getUuid(), requestDto.getReference());

    return ResponseEntity
        .ok(mapper.mapUpdateFrom(dossier));
  }
}
