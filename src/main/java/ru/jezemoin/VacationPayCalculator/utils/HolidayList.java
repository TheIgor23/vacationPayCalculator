package ru.jezemoin.VacationPayCalculator.utils;

import java.time.LocalDate;
import java.util.List;

public class HolidayList {
    public static List<LocalDate> getHolidays(int current_year) {
        return List.of(
                LocalDate.of(current_year, 1, 1),
                LocalDate.of(current_year, 1, 2),
                LocalDate.of(current_year, 1, 3),
                LocalDate.of(current_year, 1, 4),
                LocalDate.of(current_year, 1, 5),
                LocalDate.of(current_year, 1, 6),
                LocalDate.of(current_year, 1, 7),
                LocalDate.of(current_year, 1, 8),
                LocalDate.of(current_year, 2, 23),
                LocalDate.of(current_year, 3, 8),
                LocalDate.of(current_year, 5, 1),
                LocalDate.of(current_year, 5, 9),
                LocalDate.of(current_year, 6, 12),
                LocalDate.of(current_year, 11, 4)
        );
    }
}
