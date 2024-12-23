package com.smartech.mapstructdemo.util;

import java.util.Optional;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NameUtils {
    public static String getNamePart(String fullName, int partNumber) {
        return Optional.ofNullable(fullName)
            .map(name -> name.split("\\s"))
            .filter(names -> names.length > 1)
            .map(names -> names[partNumber])
            .orElse(null);
    }
}
