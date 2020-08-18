package com.innso.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DossierCreateResponseDto implements Serializable {


  @JsonProperty(value = "uuid")
  private UUID uuid;

  @JsonProperty(value = "created_at")
  private Date createdAt;
}
