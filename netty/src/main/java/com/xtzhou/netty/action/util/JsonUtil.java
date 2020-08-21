package com.xtzhou.netty.action.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {
        //no instance
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            log.error("", e);
            return null;
        }
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("", e);
            return "";
        }
    }

}
