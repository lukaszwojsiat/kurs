package pl.kurs.services;

import com.fasterxml.jackson.core.type.TypeReference;
import pl.kurs.models.ObjectMapperHolder;
import pl.kurs.models.Shape;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ShapeService {

    public Shape findShapeWithMaxArea(List<Shape> shapeList) {
        return shapeList.stream()
                .max(Comparator.comparing(Shape::calculateArea))
                .orElseThrow();
    }

    public Shape findShapeWithMaxPerimeter(List<Shape> shapeList, Class<?> shapeClass) {
        return shapeList.stream()
                .filter(shapeClass::isInstance)
                .max(Comparator.comparing(Shape::calculatePerimeter))
                .orElseThrow();
    }

    public void exportShapeListToJson(List<Shape> shapes, String path) {
        try {
            ObjectMapperHolder.INSTANCE.getObjectMapper().writeValue(new File(path), shapes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Shape> importShapesFromJson(String path) {
        try {
            return ObjectMapperHolder.INSTANCE.getObjectMapper().readValue(new File(path), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
