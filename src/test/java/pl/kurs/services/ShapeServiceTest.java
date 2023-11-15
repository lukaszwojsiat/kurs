package pl.kurs.services;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ShapeServiceTest {

    List<Shape> shapes;
    Circle circle = ShapeFactory.createCircle(20);
    Square square = ShapeFactory.createSquare(25);
    Rectangle rectangle = ShapeFactory.createRectangle(5, 2);
    String filePathToTestObjectMapper = "src/test/java/pl/kurs/services/shapeListToTestObjectMapper.json";
    File fileToTestObjectMapper;
    ShapeService shapeService;


    @Before
    public void init() throws IOException {
        shapeService = new ShapeService();
        shapes = new ArrayList<>();
        shapes.add(ShapeFactory.createCircle(4));
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(ShapeFactory.createRectangle(4, 1));
        shapes.add(ShapeFactory.createSquare(5));
        shapes.add(square);

        fileToTestObjectMapper = new File(filePathToTestObjectMapper);
        if (!fileToTestObjectMapper.exists())
            fileToTestObjectMapper.createNewFile();
    }

    @Test
    public void shouldFindLargestAreaShapeAndReturnCircleWithRadius20() {
        List<Shape> shapesForTest = shapes;
        Circle circleToAssert = circle;

        Shape largestAreaShape = shapeService.findShapeWithMaxArea(shapesForTest);

        assertEquals(circleToAssert, largestAreaShape);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldTrowNoSuchElementExceptionWhenFindingLargestAreaShape() {
        List<Shape> shapesForTest = new ArrayList<>();

        shapeService.findShapeWithMaxArea(shapesForTest);
    }

    @Test
    public void shouldFindLargestRectanglePerimeterAndReturnRectangleWithWidth5AndHeight2() {
        List<Shape> shapesForTest = shapes;
        Rectangle rectangleToAssert = rectangle;

        Shape largestPerimeterShape = shapeService.findShapeWithMaxPerimeter(shapesForTest, Rectangle.class);

        assertEquals(rectangleToAssert, largestPerimeterShape);
    }

    @Test
    public void shouldFindLargestCirclePerimeterAndReturnCircleWithRadius20() {
        List<Shape> shapesForTest = shapes;
        Circle circleToAssert = circle;

        Shape largestPerimeterShape = shapeService.findShapeWithMaxPerimeter(shapesForTest, Circle.class);

        assertEquals(circleToAssert, largestPerimeterShape);
    }

    @Test
    public void shouldFindLargestSquarePerimeterAndReturnSquareWithRadius20() {
        List<Shape> shapesForTest = shapes;
        Square squareToAssert = square;

        Shape largestPerimeterShape = shapeService.findShapeWithMaxPerimeter(shapesForTest, Square.class);

        assertEquals(squareToAssert, largestPerimeterShape);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionWhenFindingLargestPerimeterShape() {
        List<Shape> shapes = new ArrayList<>();

        shapeService.findShapeWithMaxPerimeter(shapes, Circle.class);
    }

    @Test
    public void shouldExportShapesListToFileAsJson() throws IOException {
        List<Shape> shapesToTest = shapes;
        String jsonToAssertWith = ObjectMapperHolder.INSTANCE.getObjectMapper().writeValueAsString(shapesToTest);
        FileReader fr = new FileReader(fileToTestObjectMapper);
        BufferedReader br = new BufferedReader(fr);

        shapeService.exportShapeListToJson(shapesToTest, filePathToTestObjectMapper);
        String jsonFromFile = br.readLine();

        assertEquals(jsonToAssertWith, jsonFromFile);
    }


    @Test
    public void shouldImportShapesListFromJson() throws IOException {
        List<Shape> shapesToTest = shapes;
        ObjectMapperHolder.INSTANCE.getObjectMapper().writeValue(fileToTestObjectMapper, shapesToTest);

        List<Shape> shapesFromJson = shapeService.importShapesFromJson(filePathToTestObjectMapper);

        assertEquals(shapesToTest, shapesFromJson);
    }

}