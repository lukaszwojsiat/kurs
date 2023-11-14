package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.models.Rectangle;
import pl.kurs.services.ShapeFactory;

import java.io.IOException;

public class RectangleDeserializer extends StdDeserializer<Rectangle> {
    public RectangleDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Rectangle deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
        return ShapeFactory.createRectangle(
                jn.get("width").asDouble(),
                jn.get("height").asDouble()
        );
    }
}
