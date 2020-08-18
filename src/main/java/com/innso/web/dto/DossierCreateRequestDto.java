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
public class DossierCreateRequestDto implements Serializable {

  private UUID messageUuid;

  @JsonCreator
  public DossierCreateRequestDto(
      @JsonProperty(value = "message_uuid", required = true) UUID messageUuid) {
    this.messageUuid = messageUuid;
  }
}
