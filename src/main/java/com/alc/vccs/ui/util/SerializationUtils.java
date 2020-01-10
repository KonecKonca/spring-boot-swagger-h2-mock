package com.alc.vccs.ui.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Slf4j
@UtilityClass
public class SerializationUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static <T> Optional<String> toOptionalJsonString(T object) {
        try {
            return Optional.of(toJsonString(object));
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize instance of " + object.getClass(), e);
            return Optional.empty();
        }
    }

    public static <T> String toJsonString(T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static<T> Map<String, String> fromJsonToMap(T object)  {
        String json = toOptionalJsonString(object).get();
        try {
            return mapper.readValue(json, new TypeReference<Map<String, String>>(){});
        } catch (IOException e) {
            log.error("Unable to convert from json to map instance of " + object.getClass(), e);
            return Collections.emptyMap();
        }
    }
    
    public static <T> T fromJsonToObject(String json, Class<T> clazz) throws JsonParseException, IOException, JsonMappingException {
        return mapper.readValue(json, clazz);
    }

}
