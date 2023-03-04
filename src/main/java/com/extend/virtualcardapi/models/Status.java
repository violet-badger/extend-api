package com.extend.virtualcardapi.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Status {
    PENDING("PENDING"),
    CLEARED("CLEARED"),
    DECLINED("DECLINING");

    private String code;

    private Status(String code) {
        this.code=code;
    }

    @JsonCreator
    public static Status decode(final String code) {
        return Stream.of(Status.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return code;
    }
}
