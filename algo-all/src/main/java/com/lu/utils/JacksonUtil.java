package com.lu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author sheldon
 * @date 2022-10-12
 */
public class JacksonUtil {

    private static final Logger log = LoggerFactory.getLogger(JacksonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public JacksonUtil() {
    }

    public static String toJson(Object value) {
        String result = null;

        try {
            result = OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException var3) {
            log.error("write to String error", var3);
        }

        return result;
    }

    public static byte[] toBytes(Object value) {
        byte[] result = null;

        try {
            result = OBJECT_MAPPER.writeValueAsBytes(value);
        } catch (JsonProcessingException var3) {
            log.error("write to bytes error", var3);
        }

        return result;
    }

    public static <T> T parseObject(String content, Class<T> valueType) {
        T t = null;

        try {
            t = OBJECT_MAPPER.readValue(content, valueType);
        } catch (JsonProcessingException var4) {
            log.error("parse object error", var4);
        }

        return t;
    }

    public static <T> T parseObject(String content, TypeReference<T> valueTypeRef) {
        T t = null;

        try {
            t = OBJECT_MAPPER.readValue(content, valueTypeRef);
        } catch (JsonProcessingException var4) {
            log.error("parse object error", var4);
        }

        return t;
    }

    public static JsonNode parseObject(String content) {
        JsonNode jsonNode = null;

        try {
            jsonNode = OBJECT_MAPPER.readTree(content);
        } catch (JsonProcessingException var3) {
            log.error("parse object error", var3);
        }

        return jsonNode;
    }

    public static Map toMap(Object object) {
        try {
            String content = OBJECT_MAPPER.writeValueAsString(object);
            return OBJECT_MAPPER.readValue(content, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception var2) {
            log.error("Write to map error:{}", object, var2);
            return null;
        }
    }

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }


}
