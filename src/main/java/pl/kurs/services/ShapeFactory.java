package pl.kurs.services;

import pl.kurs.models.Circle;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Shape;
import pl.kurs.models.Square;

import java.util.HashSet;
import java.util.Set;

public class ShapeFactory {
    private final static Set<Shape> shapes = new HashSet<>();

    public static Set<Shape> getShapes() {
        return shapes;
    }

    public static Square createSquare(double side) {
        Square squareToCheckIfExist = Square.createSquare(side);
        if (!shapes.contains(squareToCheckIfExist)) {
            shapes.add(squareToCheckIfExist);
            return squareToCheckIfExist;
        } else
            return (Square) shapes.stream().
                    filter(x -> x.equals(squareToCheckIfExist))
            .findFirst()
            .orElseThrow();
    }

    public static Rectangle createRectangle(double width, double height) {
        Rectangle rectangleToCheckIfExist = Rectangle.createRectangle(width, height);
        if (!shapes.contains(rectangleToCheckIfExist)) {
            shapes.add(rectangleToCheckIfExist);
            return rectangleToCheckIfExist;
        } else
            return (Rectangle) shapes.stream()
                    .filter(x -> x.equals(rectangleToCheckIfExist))
                    .findFirst()
                    .orElseThrow();
    }

    public static Circle createCircle(double radius) {
        Circle circleToCheckIfExist = Circle.createCircle(radius);
        if (!shapes.contains(circleToCheckIfExist)) {
            shapes.add(circleToCheckIfExist);
            return circleToCheckIfExist;
        } else
            return (Circle) shapes.stream()
                    .filter(x -> x.equals(circleToCheckIfExist))
                    .findFirst()
                    .orElseThrow();
    }
}
