package com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.mapper;

import com.danielhernandez.RectanglesExercise.domain.rectangles.Rectangle;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.RectangleDto;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.RectanglesRequestDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RectanglesRequestMapperImpl implements RectanglesRequestMapper {

  @Override
  public List<Rectangle> dtoToDomain(RectanglesRequestDto rectangleRequestDto) {
    List<Rectangle> rectangleList = new ArrayList<>();
    for (RectangleDto rectangleDto : rectangleRequestDto.getRectanglesDto()) {
      rectangleList.add(
          new Rectangle(
              rectangleDto.getBottomLeftX(),
              rectangleDto.getBottomLeftY(),
              rectangleDto.getUpperRightX(),
              rectangleDto.getUpperRightY()));
      }
    return rectangleList;
  }
}
