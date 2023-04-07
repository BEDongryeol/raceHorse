package com.racehorse.race.clinic.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Copyright demo1 Inc since 2023/04/07
 * Created by Larry on 2023/04/07
 * Email : inwoo.server@gmail.com
 */
public class LocalDateUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.KOREA);

    public static LocalDate fromString(String stringDate) {
        return LocalDate.parse(stringDate, DATE_TIME_FORMATTER);
    }
}
