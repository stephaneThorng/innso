package com.innso.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.innso.domain.suivi.model.Canal;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDto implements Serializable {

  @JsonProperty("uuid")
  private UUID uuid;

  @JsonProperty("auteur")
  private String auteur;

  @JsonProperty("contenu")
  private String contenu;

  @JsonProperty("canal")
  private Canal canal;

  @JsonProperty("created_at")
  private Date createdAt;

  @JsonProperty("updated_at")
  private Date updatedAt;
}
