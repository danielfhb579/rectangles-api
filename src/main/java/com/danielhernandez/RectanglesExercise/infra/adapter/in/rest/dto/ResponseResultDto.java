package com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto;

import com.danielhernandez.RectanglesExercise.domain.rectangles.Point;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(Include.NON_NULL)
public class ResponseResultDto {

  private final String result;
  private final Set<Point> pointsOfIntersection;

}
