# rectangles-exercise

##Description

The rectangles API is used to analyze rectangles and features among rectangles in a two-dimensional 
plane. The current version is able to validate 3 features among 2 rectangles. To evaluate the features 
you must provide 2 rectangles defined by the bottom left point and the upper right point. The
rectangles defined by these points will always have its sides parallel to the x-axis and y-axis.
The points of the rectangles are constrained by the definition of the data type double and 
accepts positive and negative values in every quadrant of the xy-coordinates.

The features develop to evaluate in the rectangles API are:
1. Intersection: 
2. Containment:
3. Adjacency:

---
Features, definitions & rules
---

1. Input features
   - Listen HTTP POST to process request and response

   1. API contracts
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
