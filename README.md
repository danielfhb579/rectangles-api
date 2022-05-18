# rectangles-exercise

## Description

The rectangles API is used to analyze rectangles and features among rectangles in a two-dimensional 
plane. The current version validate 3 features among 2 rectangles. To evaluate the features 
you must provide 2 rectangles defined by the bottom left point and the upper right point. The
rectangles defined by these points will always have its sides parallel to the x-axis and y-axis.
The points of the rectangles are constrained by the definition of the data type double and 
accepts positive and negative values in every quadrant of the xy-coordinates.

The features develop to evaluate in the rectangles API are:
1. Intersection: determine whether two rectangles have one or more intersecting lines and produce a result 
identifying the points of intersection. The expected result for this feature is a message with the result indicating
whether there is an intersection and if there is returns a set with the points.
![Intersection](https://github.com/danielfhb579/rectangles-api/blob/main/intersetion.jpg?raw=true)
2. Containment: determine whether a rectangle is wholly contained within another rectangle. The current version 
identifies the one greater area and then performs the validation of containment. There is not needed to specify the order
in which one rectangle contains the other.
   ![Containment](https://github.com/danielfhb579/rectangles-api/blob/main/containment.jpg?raw=true)
3. Adjacency: detect whether two rectangles are adjacent. Adjacency is defined as the sharing of at least one side.
   - Proper: adjacent lines that share one side of a rectangle, and it is equal to a side of another rectangle.
   - Sub-line: adjacent lines that share one side of a rectangle that exists as a set of points wholly contained on 
     some other side of another rectangle
   - Partial: adjacent lines where a line segment on a side of a rectangle exists as a set of points on some side of 
     another rectangle.
     ![Adjacency](https://github.com/danielfhb579/rectangles-api/blob/main/adjacency.jpg?raw=true)

---
Features, definitions & rules
---

1. Input features
   - Listen HTTP POST to process request and response

   #### API contracts
      Request
```json
{
   "type": "rectangle",
   "Rectangles": [
   {
   "bottomLeftX": 5,
   "bottomLeftY": 4,
   "upperRightX": 9,
   "upperRightY": 6
   },
   {
   "bottomLeftX": 9,
   "bottomLeftY": 5,
   "upperRightX": 11,
   "upperRightY": 7
   }
   ]
   }
```

2. Libraries and technologies integrated:

   ##### FOR PROGRAMMING
    - Java JDK 11
    - SpringBoot
    - Lombok
    - Springdocs & Swagger-UI (Contracts)


   ##### FOR TESTING
    - JUnit 5
