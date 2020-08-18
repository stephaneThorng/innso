package com.innso.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DossierUpdateResponseDto extends DossierDto implements Serializable {

  @JsonProperty(value = "messages")
  private Set<MessageResponseDto> messages;
}
