package com.danielhernandez.RectanglesExercise.domain.rectangles;

import lombok.Getter;

/**
 *  The {@code Rectangle} class is a
 */
@Getter
public class Rectangle {

    private final double minX;
    private final double minY;
    private final double maxX;
    private final double maxY;

    private final double width;
    private final double height;


    public Rectangle(double minX, double minY, double maxX, double maxY) {
        if (maxX == minX && maxY == minY) {
            throw new IllegalArgumentException("Invalid rectangle same points");
        }
        if (maxX < minX || maxY < minY) {
            throw new IllegalArgumentException("Invalid rectangle");
        }
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.width = Math.abs(maxX-minX);
        this.height = Math.abs(maxY-minY);
    }

    public double area(){
        return width*height;
    }
}
