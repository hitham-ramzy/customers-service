package com.jumia.task.util;

import com.jumia.task.entity.enums.CountryEnum;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ApplicationUtils {

    public static boolean isValidPhone(CountryEnum countryEnum, String phone) {
        Pattern pattern = Pattern.compile(countryEnum.regex);
        return pattern.matcher(phone).matches();
    }

    public static CountryEnum getCountry(String phone) {
        return Arrays.stream(CountryEnum.values()).filter(countryEnum -> phone.startsWith(mapCountryCodeToPhonePattern(countryEnum.code))).findFirst().orElse(null);
    }

    private static String mapCountryCodeToPhonePattern(String countryCode) {
        return "(" + countryCode.substring(1) + ")";
    }
}
