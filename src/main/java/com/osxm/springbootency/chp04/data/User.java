/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2024-06-19
 * Author: XM
 */
package com.osxm.springbootency.chp04.data;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class User {

    private String id;

    private String name;

    //出生年月日，时分秒
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS XXX", locale = "zh", timezone = "GMT+8")
    private Timestamp birthTimestamp;

    @JsonSerialize(using = CustomDateSerializer.class)
    private String birthString;

    public String getBirthString() {
        return birthString;
    }

    public void setBirthString(String birthString) {
        this.birthString = birthString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBirthTimestamp() {
        return birthTimestamp;
    }

    public void setBirthTimestamp(Timestamp birthTimestamp) {
        this.birthTimestamp = birthTimestamp;
    }


}
