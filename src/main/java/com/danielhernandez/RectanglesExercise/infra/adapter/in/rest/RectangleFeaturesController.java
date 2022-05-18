package com.danielhernandez.RectanglesExercise.infra.adapter.in.rest;

import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.ResponseResultDto;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.RectanglesRequestDto;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.service.RectangleFeaturesService;
import javax.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/rectangles/features")
public class RectangleFeaturesController {

  @Autowired
  private RectangleFeaturesService rectangleFeaturesService;

  @PostMapping(value = "/intersection", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseResultDto> intersectionOfRectangles(@RequestBody @Valid
      RectanglesRequestDto rectangleRequestDto){
    ResponseResultDto result = rectangleFeaturesService.intersectionOfRectangles(rectangleRequestDto);
    return ResponseEntity.ok(result);
  }

  @PostMapping(value = "/containment", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseResultDto> containmentOfRectangles(@RequestBody @Valid
      RectanglesRequestDto rectangleRequestDto){
    ResponseResultDto result = rectangleFeaturesService.containmentOfRectangles(rectangleRequestDto);
    return ResponseEntity.ok(result);
  }

  @PostMapping(value = "/adjacency", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseResultDto> adjacencyOfRectangles(@RequestBody @Valid
      RectanglesRequestDto rectangleRequestDto){
    ResponseResultDto result = rectangleFeaturesService.adjacencyOfRectangles(rectangleRequestDto);
    return ResponseEntity.ok(result);
  }


}
