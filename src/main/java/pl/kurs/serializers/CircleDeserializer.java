package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.models.Circle;
import pl.kurs.services.ShapeFactory;

import java.io.IOException;

public class CircleDeserializer extends StdDeserializer<Circle> {
    public CircleDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Circle deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
        return ShapeFactory.createCircle(
                jn.get("radius").asDouble()
        );
    }
}
