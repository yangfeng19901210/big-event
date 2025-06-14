package com.yy.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {
    
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizeLocalDateTimeFormat() {
        return builder -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(formatter);
            LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer(formatter);
            
            builder.serializerByType(LocalDateTime.class, serializer);
            builder.deserializerByType(LocalDateTime.class, deserializer);
        };
    }
}