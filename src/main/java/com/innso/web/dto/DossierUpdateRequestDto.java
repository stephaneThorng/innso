package com.innso.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DossierUpdateRequestDto implements Serializable {

  private UUID uuid;

  private String reference;

  @JsonCreator
  public DossierUpdateRequestDto(
      @JsonProperty(value = "uuid", required = true) UUID uuid,
      @JsonProperty(value = "reference", required = true) String reference) {
    this.uuid = uuid;
    this.reference = reference;
  }
}
