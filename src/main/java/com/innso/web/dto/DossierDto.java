package com.innso.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DossierDto implements Serializable {

  @JsonProperty(value = "uuid")
  private UUID uuid;

  @JsonProperty(value = "nom")
  private String nom;

  @JsonProperty(value = "reference")
  private String reference;

  @JsonProperty(value = "created_at")
  private Date createdAt;

  @JsonProperty(value = "updated_at")
  private Date updatedAt;
}
