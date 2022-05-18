package com.danielhernandez.RectanglesExercise.domain.rectangles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Point {

  /**
   * The X coordinate of the point .
   */
  private final double x;

  /**
   * The Y coordinate of the point.
   */
  private final double y;

}
