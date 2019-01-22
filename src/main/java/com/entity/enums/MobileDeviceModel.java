package com.entity.enums;

import java.util.Arrays;

public enum MobileDeviceModel {

    SAMSUNG,
    APPLE,
    XIAOMI,
    DELL,
    LENOVO,
    OTHER;

    public static MobileDeviceModel map(String value) {
        return Arrays.stream(values())
                .filter(v -> v.toString().equals(value))
                .findFirst()
                .orElse(OTHER);
    }

}
