package ru.jezemoin.VacationPayCalculator.service.paymentDays;

import org.springframework.stereotype.Service;
import ru.jezemoin.VacationPayCalculator.utils.HolidayList;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PaymentDaysCalculatorServiceImpl implements PaymentDaysCalculatorService{
    @Override
    public int calculatePaymentDays(int days, LocalDate startDate) {
        List<LocalDate> dates = Stream.iterate(startDate, nextDate -> nextDate.plusDays(1)).limit(days).toList();
        List<LocalDate> holidays = HolidayList.getHolidays(startDate.getYear());
        return (int) dates.stream()
                .filter(date -> !holidays.contains(date) && !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY ))
                .count();
    }
}
