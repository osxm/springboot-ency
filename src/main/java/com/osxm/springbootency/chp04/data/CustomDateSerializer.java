/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2024-06-19
 * Author: XM
 */
package com.osxm.springbootency.chp04.data;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<String> {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss.SSS XXX");

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        LocalDate date = LocalDate.parse(value, INPUT_FORMATTER);

        // 转换 LocalDate 为 ZonedDateTime，默认时区设置为系统的默认时区
        // ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
        String formattedDate = zonedDateTime.format(OUTPUT_FORMATTER);
        gen.writeString(formattedDate);
    }
}
