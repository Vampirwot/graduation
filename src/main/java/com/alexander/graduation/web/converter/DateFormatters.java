package com.alexander.graduation.web.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatters {
    public static class LocalDateFormatter implements Formatter<LocalDate> {

        private DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        @Override
        public LocalDate parse(String text, Locale locale) {
            return StringUtils.isEmpty(text) ? null : LocalDate.parse(text,formatter);
        }

        @Override
        public String print(LocalDate lt, Locale locale) {
            return lt.format(formatter);
        }
    }
}
