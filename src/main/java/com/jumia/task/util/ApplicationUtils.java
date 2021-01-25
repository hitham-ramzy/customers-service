package com.jumia.task.util;

import com.jumia.task.entity.enums.CountryEnum;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * The type Application utils.
 */
public class ApplicationUtils {

    /**
     * Is valid phone boolean.
     *
     * @param countryEnum the country enum
     * @param phone       the phone
     * @return the boolean
     */
    public static boolean isValidPhone(CountryEnum countryEnum, String phone) {
        if (ObjectUtils.isEmpty(phone)) {
            return false;
        }
        Pattern pattern = Pattern.compile(countryEnum.regex);
        return pattern.matcher(phone).matches();
    }

    /**
     * Gets country.
     *
     * @param phone the phone
     * @return the country
     */
    public static CountryEnum getCountry(String phone) {
        if (ObjectUtils.isEmpty(phone)) {
            return null;
        }
        return Arrays.stream(CountryEnum.values()).filter(countryEnum -> phone.startsWith(mapCountryCodeToPhonePattern(countryEnum.code))).findFirst().orElse(null);
    }

    private static String mapCountryCodeToPhonePattern(String countryCode) {
        return "(" + countryCode.substring(1) + ")";
    }
}
