package com.company.util;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by cic56 on 23.06.2017.
 */
public class DateUtil {
    public static final LocalDate NOW = LocalDate.of(3000, 1, 1);
    public static LocalDate of(int year, Month month){
        return LocalDate.of(year,month,1);
    }
}
