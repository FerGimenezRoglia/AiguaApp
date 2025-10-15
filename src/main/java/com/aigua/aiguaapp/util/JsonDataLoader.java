package com.aigua.aiguaapp.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class to read JSON files from resources
 * and parse LocalDateTime fields in multiple formats.
 * @author fer-develop
 */
public class JsonDataLoader {

    private final ObjectMapper objectMapper;

    public JsonDataLoader() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Flexible parser for ISO-like date formats
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                String value = p.getText();
                if (value == null || value.isEmpty()) {
                    return null;
                }

                try {
                    // ISO_DATE_TIME can parse both T03:00 and T03:00:00 automatically
                    return LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
                } catch (DateTimeParseException e) {
                    // fallback manual patterns for edge cases
                    String[] patterns = {
                            "yyyy-MM-dd'T'HH:mm:ss",
                            "yyyy-MM-dd'T'HH:mm"
                    };
                    for (String pattern : patterns) {
                        try {
                            return LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern));
                        } catch (Exception ignored) {}
                    }
                    throw new IOException("Unrecognized date format: " + value);
                }
            }
        });
        this.objectMapper.registerModule(module);
    }

    public <T> List<T> readList(String resourceName, Class<T[]> arrayClass) {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (in == null) {
                throw new IllegalStateException("Resource not found: " + resourceName);
            }
            T[] array = objectMapper.readValue(in, arrayClass);
            return Arrays.asList(array);
        } catch (Exception e) {
            e.printStackTrace(); // log visible in IntelliJ console
            throw new RuntimeException("Failed to read resource " + resourceName + ": " + e.getMessage(), e);
        }
    }
}