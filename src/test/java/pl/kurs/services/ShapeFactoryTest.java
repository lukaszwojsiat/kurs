package pl.kurs.services;

import org.junit.Assert;
import org.junit.Test;
import pl.kurs.models.Circle;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Square;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShapeFactoryTest {

    @Test
    public void shouldCheckIfSquareExistInCacheAndReturnNewSquare() {
        double squareSide = 5;
        Assert.assertFalse(ShapeFactory.getShapes().stream().anyMatch(x -> x.getClass() == Square.class && ((Square) x).getSide() == squareSide));

        Square newSquare = ShapeFactory.createSquare(squareSide);
        Square squareFromCache = (Square) ShapeFactory.getShapes().stream()
                .filter(x -> x.getClass() == Square.class && ((Square) x).getSide() == squareSide)
                .findFirst()
                .orElseThrow();

        assertTrue(ShapeFactory.getShapes().stream().anyMatch(x -> x.getClass() == Square.class && ((Square) x).getSide() == squareSide));
        assertEquals(newSquare, squareFromCache);
    }

    @Test
    public void shouldCheckIfSquareExistInCacheAndReturnSquareFromCache() {
        double squareSide = 6;
        Assert.assertFalse(ShapeFactory.getShapes().stream().anyMatch(x -> x.getClass() == Square.class && ((Square) x).getSide() == squareSide));
        ShapeFactory.createSquare(squareSide);
        assertTrue(ShapeFactory.getShapes().stream().anyMatch(x -> x.getClass() == Square.class && ((Square) x).getSide() == squareSide));

        Square newSquare = ShapeFactory.createSquare(squareSide);
        Square squareFromCache = (Square) ShapeFactory.getShapes().stream()
                .filter(x -> x.getClass() == Square.class && ((Square) x).getSide() == squareSide)
                .findFirst()
                .orElseThrow();

        assertEquals(newSquare, squareFromCache);
    }

    @Test
    public void shouldCheckIfCircleExistInCacheAndReturnNewCircle() {
        double circleRadius = 5;
        Assert.assertFalse(ShapeFactory.getShapes().stream().anyMatch(x -> x.getClass() == Circle.class && ((Circle) x).getRadius() == circleRadius));

        Circle newCircle = ShapeFactory.createCircle(circleRadius);
        Circle circleFromCache = (Circle) ShapeFactory.getShapes().stream()
                .filter(x -> x.getClass() == Circle.class && ((Circle) x).getRadius() == circleRadius)
                .findFirst()
                .orElseThrow();

        assertTrue(ShapeFactory.getShapes().stream().anyMatch(x -> x.getClass() == Circle.class && ((Circle) x).getRadius() == circleRadius));
        assertEquals(newCircle, circleFromCache);
    }

    @Test
    public void shouldCheckIfCircleExistInCacheAndReturnCircleFromCache() {
        double circleRadius = 6;
        Assert.assertFalse(ShapeFactory.getShapes().stream().anyMatch(x -> x.getClass() == Circle.class && ((Circle) x).getRadius() == circleRadius));
        ShapeFactory.createCircle(circleRadius);
        assertTrue(ShapeFactory.getShapes().stream().anyMatch(x -> x.getClass() == Circle.class && ((Circle) x).getRadius() == circleRadius));

        Circle newCircle = ShapeFactory.createCircle(circleRadius);
        Circle circleFromCache = (Circle) ShapeFactory.getShapes().stream()
                .filter(x -> x.getClass() == Circle.class && ((Circle) x).getRadius() == circleRadius)
                .findFirst()
                .orElseThrow();

        assertEquals(newCircle, circleFromCache);
    }

    @Test
    public void shouldCheckIfRectangleExistInCacheAndReturnNewRectangle() {
        double rectangleWidth = 9;
        double rectangleHeight = 10;
        Assert.assertFalse(ShapeFactory.getShapes().stream()
                .anyMatch(x -> x.getClass() == Rectangle.class && ((Rectangle) x).getWidth() == rectangleWidth && ((Rectangle) x).getHeight() == rectangleHeight));

        Rectangle newRectangle = ShapeFactory.createRectangle(rectangleWidth, rectangleHeight);
        Rectangle rectangle = (Rectangle) ShapeFactory.getShapes().stream()
                .filter(x -> x.getClass() == Rectangle.class && ((Rectangle) x).getWidth() == rectangleWidth && ((Rectangle) x).getHeight() == rectangleHeight)
                .findFirst()
                .orElseThrow();

        assertTrue(ShapeFactory.getShapes().stream()
                .anyMatch(x -> x.getClass() == Rectangle.class && ((Rectangle) x).getWidth() == rectangleWidth && ((Rectangle) x).getHeight() == rectangleHeight));
        assertEquals(newRectangle, rectangle);
    }

    @Test
    public void shouldCheckIfRectangleExistInCacheAndReturnRectangleFromCache() {
        double rectangleWidth = 1;
        double rectangleHeight = 12;
        Assert.assertFalse(ShapeFactory.getShapes().stream()
                .anyMatch(x -> x.getClass() == Rectangle.class && ((Rectangle) x).getWidth() == rectangleWidth && ((Rectangle) x).getHeight() == rectangleHeight));
        ShapeFactory.createRectangle(rectangleWidth, rectangleHeight);
        assertTrue(ShapeFactory.getShapes().stream()
                .anyMatch(x -> x.getClass() == Rectangle.class && ((Rectangle) x).getWidth() == rectangleWidth && ((Rectangle) x).getHeight() == rectangleHeight));

        Rectangle newRectangle = ShapeFactory.createRectangle(rectangleWidth, rectangleHeight);
        Rectangle rectangle = (Rectangle) ShapeFactory.getShapes().stream()
                .filter(x -> x.getClass() == Rectangle.class && ((Rectangle) x).getWidth() == rectangleWidth && ((Rectangle) x).getHeight() == rectangleHeight)
                .findFirst()
                .orElseThrow();

        assertEquals(newRectangle, rectangle);
    }

}