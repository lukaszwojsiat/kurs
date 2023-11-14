package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.models.Square;
import pl.kurs.services.ShapeFactory;

import java.io.IOException;

public class SquareDeserializer extends StdDeserializer<Square> {
    public SquareDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Square deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jn = jsonParser.getCodec().readTree(jsonParser);
        return ShapeFactory.createSquare(
                jn.get("side").asDouble()
        );
    }
}
