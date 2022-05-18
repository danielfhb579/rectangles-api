package com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.service;

import com.danielhernandez.RectanglesExercise.domain.rectangles.Line;
import com.danielhernandez.RectanglesExercise.domain.rectangles.Point;
import com.danielhernandez.RectanglesExercise.domain.rectangles.Rectangle;
import com.danielhernandez.RectanglesExercise.domain.usecase.RectangleProperties;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.ResponseResultDto;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.RectanglesRequestDto;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.mapper.RectanglesRequestMapper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RectangleFeaturesService {

  @Autowired
  private RectanglesRequestMapper rectanglesRequestMapper;


  public ResponseResultDto intersectionOfRectangles(RectanglesRequestDto rectanglesRequestDto) {
    List<Rectangle> rectangles = rectanglesRequestMapper.dtoToDomain(rectanglesRequestDto);
    Set<Point> result = intersectionOfRectanglesValidation(rectangles.get(0), rectangles.get(1));
    if (result.isEmpty()){
      return ResponseResultDto.builder()
          .result("No Intersection")
          .build();
    }
    return ResponseResultDto.builder()
        .result("Intersection")
        .pointsOfIntersection(result)
        .build();
  }

  public ResponseResultDto containmentOfRectangles(RectanglesRequestDto rectangleRequestDto) {
    List<Rectangle> rectangles = rectanglesRequestMapper.dtoToDomain(rectangleRequestDto);
    if (isContained(rectangles.get(0), rectangles.get(1))){
      return ResponseResultDto.builder()
          .result("Containment")
          .build();
    }
    if (isIntersection(rectangles.get(0), rectangles.get(1))){
      return ResponseResultDto.builder()
          .result("Intersection - No Containment")
          .build();
    }
    return ResponseResultDto.builder()
        .result("No containment")
        .build();
  }

  public ResponseResultDto adjacencyOfRectangles(RectanglesRequestDto rectangleRequestDto) {
    List<Rectangle> rectangles = rectanglesRequestMapper.dtoToDomain(rectangleRequestDto);
    String result = adjacentRectangles(rectangles.get(0), rectangles.get(1));
    return ResponseResultDto.builder()
        .result(result)
        .build();
  }

  private Set<Point> intersectionOfRectanglesValidation(Rectangle rectangleA, Rectangle rectangleB){
    if (!isIntersection(rectangleA,rectangleB)) { return new HashSet<>();}
    double xBottom = Math.max(rectangleA.getMinX(), rectangleB.getMinX());
    double yBottom = Math.max(rectangleA.getMinY(), rectangleB.getMinY());
    double xTop = Math.min(rectangleA.getMaxX(), rectangleB.getMaxX());
    double yTop = Math.min(rectangleA.getMaxY(), rectangleB.getMaxY());
    Rectangle rectangleIntersection = new Rectangle(xBottom,yBottom, xTop, yTop);
    Set<Point> hashSet =  RectangleProperties.pointsOfRectangle(rectangleIntersection);
    hashSet.removeAll(RectangleProperties.pointsOfRectangle(rectangleA));
    hashSet.removeAll(RectangleProperties.pointsOfRectangle(rectangleB));
    return hashSet;
  }

  private boolean isIntersection(Rectangle rectA, Rectangle rectB){
    return (rectA.getMinX() <= rectB.getMaxX()
        && rectA.getMaxX() >= rectB.getMinX()
        && rectA.getMinY() <= rectB.getMaxY()
        && rectA.getMaxY() >= rectB.getMinY()
        && !isContained(rectA, rectB));
  }

  private boolean isContained(Rectangle rectA, Rectangle rectB){
    if(rectA.area() < rectB.area()){ return isContained(rectB, rectA);}
    return (rectA.getMinX() <= rectB.getMinX() && rectA.getMinY() <= rectB.getMinY()
        && rectA.getMaxX() >= rectB.getMaxX() && rectA.getMaxY()>= rectB.getMaxY());
  }

  private String adjacentRectangles(Rectangle rectangleA, Rectangle rectangleB){
    for (Line lineOfA:RectangleProperties.linesOfRectangle(rectangleA)) {
      for (Line lineOfB:RectangleProperties.linesOfRectangle(rectangleB)) {
        if(properAdjacentRectangle(lineOfA, lineOfB)){
          return "Adjacent (Proper)";
        }
        if (lineContained(lineOfA, lineOfB)){
          return "Adjacent (Sub-line)";
        }
        if (partiallyAdjacentLine(lineOfA, lineOfB)){
          return "Adjacent (Partial)";
        }
      }
    }
    return "No Adjacent Rectangles";
  }

  private boolean properAdjacentRectangle(Line lineOfA, Line lineOfB) {
    return lineOfA.equals(lineOfB);
  }

  public boolean lineContained(Line l1, Line l2){
    if (l1.length() < l2.length()){ return lineContained(l2, l1);}
    if (inAlignmentYAxis(l1, l2)) {
      return l1.getY1() <= l2.getY1() && l2.getY2() <= l1.getY2();
    }
    else if (inAlignmentXAxis(l1, l2)) {
      return l1.getX1() <= l2.getX1() && l2.getX2() <= l1.getX2();
    }
    return false;
  }

  private boolean inAlignmentXAxis(Line l1, Line l2) {
    return l1.getY1() == l2.getY1() && l1.getY2() == l2.getY2();
  }

  private boolean inAlignmentYAxis(Line l1, Line l2) {
    return l1.getX1() == l2.getX1() && l1.getX2() == l2.getX2();
  }

  private boolean partiallyAdjacentLine(Line l1, Line l2){
    if (inAlignmentYAxis(l1, l2)) {
      return (l1.getY1() <= l2.getY1() && l2.getY1() <= l1.getY2())
          || (l1.getY1() <= l2.getY2() && l2.getY2() <= l1.getY2());
    }
    else if (inAlignmentXAxis(l1, l2)) {
      return (l1.getX1() <= l2.getX1() && l2.getX1() <= l1.getX2()) || (l1.getX1() <= l2.getX2() && l2.getX2() <= l1.getX2());
    }
    return false;
  }


}
