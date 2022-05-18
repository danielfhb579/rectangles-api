package com.danielhernandez.RectanglesExercise.domain.rectangles;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Line {

    /**
     * The X coordinate of the start point of the line segment.
     */
    private final double x1;

    /**
     * The Y coordinate of the start point of the line segment.
     */
    private final double y1;

    /**
     * The X coordinate of the end point of the line segment.
     */
    private final double x2;

    /**
     * The Y coordinate of the end point of the line segment.
     */
    private final double y2;

    public Line(double x1, double y1, double x2, double y2) {
        if (x2 < x1 || y2 < y1) {
            throw new IllegalArgumentException("Invalid line");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public double length(){
        double terminalPointX = this.x2 - this.x1;
        double terminalPointY = this.y2 - this.y1;
        return Math.sqrt(Math.pow(terminalPointX,2) + Math.pow(terminalPointY, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Double.compare(line.x1, x1) == 0 && Double.compare(line.y1, y1) == 0 && Double.compare(line.x2, x2) == 0 && Double.compare(line.y2, y2) == 0;
    }


}
