package com.util;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Stream;

@Component
public class FieldsValidator {

    public boolean anyNull(Object... objects) {
        return Stream.of(objects).anyMatch(Objects::isNull);
    }

}
