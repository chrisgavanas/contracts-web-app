package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
public class UtilHelper {

    private static final String PLATE_NUMBER_FORMAT = "[ABEHIKMNOPTXYZ]{3}-[0123456789]{4}";
    private final Pattern pattern = Pattern.compile(PLATE_NUMBER_FORMAT);

    private final Range<Integer> range;
    private final Integer decimalDigitsAllowed;

    @Autowired
    public UtilHelper(@Value("${bonus.malus.range.lower.bound}") Integer lowerBound,
                      @Value("${bonus.malus.range.upper.bound}") Integer upperBound,
                      @Value("${decimal.digits.allowed}") Integer decimalDigitsAllowed) {
        this.decimalDigitsAllowed = decimalDigitsAllowed;
        range = Range.
                from(Range.Bound.inclusive(lowerBound)).
                to(Range.Bound.inclusive(upperBound));
    }

    public boolean anyNull(Object... objects) {
        return Stream.of(objects).anyMatch(Objects::isNull);
    }

    public boolean invalidVehiclePlateFormat(String plateNumber) {
        return !pattern.matcher(plateNumber).matches();
    }

    public boolean valueOutOfRange(Integer value) {
        return !range.contains(value);
    }

    public boolean invalidAmount(Double amount) {
        return amount < 0 || BigDecimal.valueOf(amount).scale() > decimalDigitsAllowed;
    }


}
