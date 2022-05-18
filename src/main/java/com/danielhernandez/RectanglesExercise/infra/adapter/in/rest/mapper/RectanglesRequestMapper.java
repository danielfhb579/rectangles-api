package com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.mapper;

import com.danielhernandez.RectanglesExercise.domain.rectangles.Rectangle;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.RectanglesRequestDto;
import java.util.List;


public interface RectanglesRequestMapper {

  List<Rectangle> dtoToDomain(RectanglesRequestDto rectangleRequestDto);

}
