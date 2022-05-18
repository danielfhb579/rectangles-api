package com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bottomLeftX",
    "bottomLeftY",
    "upperRightX",
    "upperRightY"
})
public class RectangleDto {

  @JsonProperty("bottomLeftX")
  public Double bottomLeftX;
  @JsonProperty("bottomLeftY")
  public Double bottomLeftY;
  @JsonProperty("upperRightX")
  public Double upperRightX;
  @JsonProperty("upperRightY")
  public Double upperRightY;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}