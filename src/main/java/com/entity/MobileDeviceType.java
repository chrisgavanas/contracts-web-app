package com.entity;

import java.util.Arrays;

public enum MobileDeviceType {

    MOBILE,
    TABLET,
    LAPTOP,
    UNKNOWN;

    public static MobileDeviceType map(String value) {
        return Arrays.stream(values())
                .filter(v -> v.toString().equals(value))
                .findFirst()
                .orElse(UNKNOWN);
    }
}