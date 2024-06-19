/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2024-06-19
 * Author: XM
 */
package com.osxm.springbootency.chp04.data;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSerializerTests {

   // @Test
    public void timestampToStr() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
               // 创建一个特定的LocalDateTime对象  
        LocalDateTime specificTime = LocalDateTime.of(2024, 6, 18, 18, 30, 0);  
        // 将LocalDateTime转换为Instant（需要指定时区）  
        Instant instant = specificTime.atZone(ZoneId.systemDefault()).toInstant();  
  
        // 转换为自epoch以来的秒数（时间戳）  
        long timestampInMillis  = instant.toEpochMilli();  
        User user = new User();
        Timestamp timestamp = new Timestamp(timestampInMillis); 
        user.setId("001");
        user.setName("刘备");
        user.setBirthTimestamp(timestamp);
        String jsonStr = mapper.writeValueAsString(user);
        Assertions.assertEquals("{\"id\":\"001\",\"name\":\"刘备\",\"birthTimestamp\":\"2024-06-18 18:30:00.000 +08:00\"}", jsonStr);
    }

    @Test
    public void customDateSerializer() throws JsonProcessingException {

        User user = new User();
        user.setId("001");
        user.setName("刘备");
        user.setBirthString("2024/06/18");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(user);
        Assertions.assertEquals("{\"id\":\"001\",\"name\":\"刘备\",\"birthTimestamp\":null,\"birthString\":\"2024-06-18 00:00:00.000 +08:00\"}", jsonStr);
    }

}
