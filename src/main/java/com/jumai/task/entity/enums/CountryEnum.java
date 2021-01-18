package com.jumai.task.entity.enums;

public enum CountryEnum {

    Cameroon("+237", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
    Ethiopia("+251", "\\(251\\)\\ ?[1-59]\\d{8}$"),
    Morocco("+212", "\\(212\\)\\ ?[5-9]\\d{8}$"),
    Mozambique("+258", "\\(258\\)\\ ?[28]\\d{7,8}$"),
    Uganda("+256", "\\(256\\)\\ ?\\d{9}$");

    public String code;
    public String regex;

    CountryEnum(String code, String regex) {
        this.code = code;
        this.regex = regex;
    }
}
