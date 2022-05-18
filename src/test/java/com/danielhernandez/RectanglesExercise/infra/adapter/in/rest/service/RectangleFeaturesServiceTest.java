package com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.danielhernandez.RectanglesExercise.domain.rectangles.Point;
import com.danielhernandez.RectanglesExercise.domain.rectangles.Rectangle;
import com.danielhernandez.RectanglesExercise.domain.usecase.RectangleProperties;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.ResponseResultDto;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.dto.RectanglesRequestDto;
import com.danielhernandez.RectanglesExercise.infra.adapter.in.rest.mapper.RectanglesRequestMapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
class RectangleFeaturesServiceTest {

  @Mock
  private RectanglesRequestMapper rectanglesRequestMapper;

  @InjectMocks
  private RectangleFeaturesService rectangleFeaturesService;


  @Test
  void intersectionOfRectangles2Points() {
    //Arrange
    Rectangle rectangleA = new Rectangle(1,1, 4,4);
    Rectangle rectangleB = new Rectangle(3,0,6,5);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rectangleA);
    rectangleList.add(rectangleB);
    Set<Point> pointsOfIntersection = new HashSet<>();
    pointsOfIntersection.add(Point.builder().x(3).y(1).build());
    pointsOfIntersection.add(Point.builder().x(3).y(4).build());
    ResponseResultDto expected = ResponseResultDto.builder().result("Intersection").pointsOfIntersection(pointsOfIntersection).build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.intersectionOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
    assertEquals(expected.getPointsOfIntersection(), result.getPointsOfIntersection());
  }

  @Test
  void intersectionOfRectangles4Points() {
    //Arrange
    Rectangle rectangleA = new Rectangle(1,1, 4,4);
    Rectangle rectangleB = new Rectangle(0,2,6,3);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rectangleA);
    rectangleList.add(rectangleB);
    Set<Point> pointsOfIntersection = new HashSet<>();
    pointsOfIntersection.add(Point.builder().x(1).y(2).build());
    pointsOfIntersection.add(Point.builder().x(4).y(2).build());
    pointsOfIntersection.add(Point.builder().x(1).y(3).build());
    pointsOfIntersection.add(Point.builder().x(4).y(3).build());
    ResponseResultDto expected = ResponseResultDto.builder().result("Intersection").pointsOfIntersection(pointsOfIntersection).build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.intersectionOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
    assertEquals(expected.getPointsOfIntersection(), result.getPointsOfIntersection());
  }

  @Test
  void intersectionOfRectanglesNegativeQuadrant4Points() {
    //Arrange
    Rectangle rectangleA = new Rectangle(-5,-5, -2,1);
    Rectangle rectangleB = new Rectangle(-6,-3,-1,-2);
    //Act
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rectangleA);
    rectangleList.add(rectangleB);
    Set<Point> pointsOfIntersection = new HashSet<>();
    pointsOfIntersection.add(Point.builder().x(-2).y(-2).build());
    pointsOfIntersection.add(Point.builder().x(-5).y(-2).build());
    pointsOfIntersection.add(Point.builder().x(-2).y(-3).build());
    pointsOfIntersection.add(Point.builder().x(-5).y(-3).build());
    ResponseResultDto expected = ResponseResultDto.builder().result("Intersection").pointsOfIntersection(pointsOfIntersection).build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.intersectionOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
    assertEquals(expected.getPointsOfIntersection(), result.getPointsOfIntersection());
  }

  @Test
  void noIntersectionIdenticalRectangles() {
    //Arrange
    Rectangle rectangleA = new Rectangle(1,1, 5,4);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rectangleA);
    rectangleList.add(rectangleA);
    ResponseResultDto expected = ResponseResultDto.builder().result("No Intersection").build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.intersectionOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
    assertEquals(expected.getPointsOfIntersection(), result.getPointsOfIntersection());
  }

  @Test
  void noIntersectionOfRectangles() {
    //Arrange
    Rectangle rectangleA = new Rectangle(1,1, 5,4);
    Rectangle rectangleB = new Rectangle(2,2,4,3);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rectangleA);
    rectangleList.add(rectangleB);
    ResponseResultDto expected = ResponseResultDto.builder().result("No Intersection").build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.intersectionOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
    assertEquals(expected.getPointsOfIntersection(), result.getPointsOfIntersection());
  }

  @Test
  void containmentOfRectangles() {
    //Arrange
    Rectangle rect1 = new Rectangle(1,1, 5,4);
    Rectangle rect2 = new Rectangle(2,2,4,3);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rect1);
    rectangleList.add(rect2);
    ResponseResultDto expected = ResponseResultDto.builder().result("Containment").build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.containmentOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
  }

  @Test
  void containmentOfIdenticalRectangles() {
    //Arrange
    Rectangle rect1 = new Rectangle(1,1, 5,4);
    Rectangle rect2 = new Rectangle(1,1,5,4);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rect1);
    rectangleList.add(rect2);
    ResponseResultDto expected = ResponseResultDto.builder().result("Containment").build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.containmentOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
  }

  @Test
  void noContainmentOfRectangles() {
    Rectangle rect1 = new Rectangle(1,1, 5,4);
    Rectangle rect2 = new Rectangle(10,10,15,13);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rect1);
    rectangleList.add(rect2);
    ResponseResultDto expected = ResponseResultDto.builder().result("No containment").build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.containmentOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
  }

  @Test
  void noContainmentOfRectanglesIntersection() {
    Rectangle rect1 = new Rectangle(1,1, 5,4);
    Rectangle rect2 = new Rectangle(2,2,5.1,3);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rect1);
    rectangleList.add(rect2);
    ResponseResultDto expected = ResponseResultDto.builder()
        .result("Intersection - No Containment")
        .build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.containmentOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
  }

  @Test
  void properAdjacencyOfRectangles() {
    Rectangle rect1 = new Rectangle(1,1, 5,4);
    Rectangle rect2 = new Rectangle(4,1,8,4);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rect1);
    rectangleList.add(rect2);
    ResponseResultDto expected = ResponseResultDto.builder()
        .result("Adjacent (Partial)")
        .build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.adjacencyOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
  }

  @Test
  void sublineAdjacencyOfRectangles() {
    Rectangle rect1 = new Rectangle(1,1, 4,4);
    Rectangle rect2 = new Rectangle(4,2,5,2);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rect1);
    rectangleList.add(rect2);
    ResponseResultDto expected = ResponseResultDto.builder()
        .result("Adjacent (Sub-line)")
        .build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.adjacencyOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
  }

  @Test
  void partiallyAdjacencyOfRectangles() {
    Rectangle rect1 = new Rectangle(5,4, 9,6);
    Rectangle rect2 = new Rectangle(9,5,11,7);
    RectanglesRequestDto  rectangleDto = new RectanglesRequestDto();
    List<Rectangle> rectangleList = new ArrayList<>();
    rectangleList.add(rect1);
    rectangleList.add(rect2);
    ResponseResultDto expected = ResponseResultDto.builder()
        .result("Adjacent (Partial)")
        .build();
    Mockito.when(rectanglesRequestMapper.dtoToDomain(Mockito.any())).thenReturn(rectangleList);
    //Act
    ResponseResultDto result = rectangleFeaturesService.adjacencyOfRectangles(rectangleDto);

    //Assert
    assertEquals(expected.getResult(), result.getResult());
  }
}