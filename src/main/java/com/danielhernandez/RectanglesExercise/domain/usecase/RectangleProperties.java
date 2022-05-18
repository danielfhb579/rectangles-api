package com.danielhernandez.RectanglesExercise.domain.usecase;

import com.danielhernandez.RectanglesExercise.domain.rectangles.Line;
import com.danielhernandez.RectanglesExercise.domain.rectangles.Point;
import com.danielhernandez.RectanglesExercise.domain.rectangles.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;


public class RectangleProperties {

  public static Set<Point> pointsOfRectangle(Rectangle rectangle) {
    Set<Point> hashSet = new HashSet<>();
    hashSet.add(Point.builder().x(rectangle.getMinX()).y(rectangle.getMinY()).build());
    hashSet.add(Point.builder().x(rectangle.getMaxX()).y(rectangle.getMinY()).build());
    hashSet.add(Point.builder().x(rectangle.getMinX()).y(rectangle.getMaxY()).build());
    hashSet.add(Point.builder().x(rectangle.getMaxX()).y(rectangle.getMaxY()).build());
    return hashSet;
  }

  public static List<Line> linesOfRectangle(Rectangle rectangle) {
    List<Line> lines = new ArrayList<>();
    lines.add(new Line(rectangle.getMinX(),
        rectangle.getMinY(),
        rectangle.getMinX()+rectangle.getWidth(),
        rectangle.getMinY()));
    lines.add(new Line(rectangle.getMinX(),
        rectangle.getMinY(),
        rectangle.getMinX(),
        rectangle.getMinY()+rectangle.getHeight()));
    lines.add(new Line(rectangle.getMinX() + rectangle.getWidth(),
        rectangle.getMinY(),
        rectangle.getMinX()+rectangle.getWidth(),
        rectangle.getMinY()+rectangle.getHeight()));
    lines.add(
        new Line(
            rectangle.getMinX(),
            rectangle.getMinY() + rectangle.getHeight(),
            rectangle.getMinX() + rectangle.getWidth(),
            rectangle.getMinY() + rectangle.getHeight()));
    return lines;
  }

}
