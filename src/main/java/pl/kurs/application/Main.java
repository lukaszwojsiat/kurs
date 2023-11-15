package pl.kurs.application;

import pl.kurs.models.*;
import pl.kurs.services.ShapeFactory;
import pl.kurs.services.ShapeService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Square square = ShapeFactory.createSquare(2);
        Square square2 = ShapeFactory.createSquare(3);
        Square square3 = ShapeFactory.createSquare(2);
        Circle circle = ShapeFactory.createCircle(5);
        Rectangle rectangle = ShapeFactory.createRectangle(2, 3);

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(square);
        shapeList.add(circle);
        shapeList.add(square2);
        shapeList.add(square3);
        shapeList.add(rectangle);
        shapeList.add(ShapeFactory.createCircle(50));



        ShapeService shapeService = new ShapeService();
        System.out.println("shapeService.findShapeWithMaxArea(shapeList) = " + shapeService.findShapeWithMaxArea(shapeList));
        System.out.println("shapeService.findShapeWithMaxPerimeter(shapeList, Square.class) = " + shapeService.findShapeWithMaxPerimeter(shapeList, Square.class));

        shapeService.exportShapeListToJson(shapeList, "src/main/resources/shapeList.json");
        List<Shape> listFromJson = shapeService.importShapesFromJson("src/main/resources/shapeList.json");

        System.out.println("---------------");
        System.out.println("Zaliczylem test (?)");
    }
}
