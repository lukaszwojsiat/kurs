package pl.kurs.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import pl.kurs.serializers.*;


public enum ObjectMapperHolder {
    INSTANCE;

    private final ObjectMapper objectMapper;

    ObjectMapperHolder() {
        objectMapper = create();
    }

    public ObjectMapper getObjectMapper(){
        return objectMapper;
    }

    private static ObjectMapper create (){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDefaultTyping(new ObjectMapper.DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping.NON_FINAL,
                BasicPolymorphicTypeValidator.builder()
                        .build()) {
            {
                init(JsonTypeInfo.Id.NAME, null);
                inclusion(JsonTypeInfo.As.PROPERTY);
                typeProperty("type");
            }

            @Override
            public boolean useForType(JavaType t) {
                return !t.isContainerType() && super.useForType(t);
            }
        });

        SimpleModule sm1 = new SimpleModule("deserializers");
        sm1.addDeserializer(Square.class, new SquareDeserializer(Square.class));
        sm1.addDeserializer(Circle.class, new CircleDeserializer(Circle.class));
        sm1.addDeserializer(Rectangle.class, new RectangleDeserializer(Rectangle.class));
        objectMapper.registerModules(sm1);

        return objectMapper;
    }
}
