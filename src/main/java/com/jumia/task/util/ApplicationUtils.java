package com.jumia.task.util;

import com.jumia.task.entity.enums.CountryEnum;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApplicationUtils {
    static final Pattern pattern;

    static {
        String regex = Arrays.stream(CountryEnum.values()).map(countryEnum -> countryEnum.regex).collect(Collectors.joining("||"));
        pattern = Pattern.compile(regex);
    }

    public static boolean isValidPhone(String phone) {
        return pattern.matcher(phone).matches();
    }

    public static CountryEnum getCountry(String phone) {
        return Arrays.stream(CountryEnum.values()).filter(countryEnum -> Pattern.compile(countryEnum.regex).matcher(phone).matches()).findFirst().orElse(null);
    }
}
