package com.innso.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.innso.domain.suivi.model.Canal;
import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageRequestDto implements Serializable {

  private String auteur;

  private String contenu;

  private Canal canal;

  private UUID dossierUuid;

  @JsonCreator
  public MessageRequestDto(
      @JsonProperty(value = "auteur", required = true) String auteur,
      @JsonProperty(value = "contenu", required = true) String contenu,
      @JsonProperty(value = "canal", required = true) Canal canal,
      @JsonProperty(value = "dossier_uuid") UUID dossierUuid) {
    this.auteur = auteur;
    this.contenu = contenu;
    this.canal = canal;
    this.dossierUuid = dossierUuid;
  }
}
