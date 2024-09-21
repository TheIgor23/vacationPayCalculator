package ru.jezemoin.VacationPayCalculator.service.vacationPay;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class VacationPayCalculatorServiceImpl implements VacationPayCalculatorService{
    private final double AVERAGE_DAYS_MONTH = 29.3;
    private final double NDFL_PERCENT = 0.13;
    @Override
    public BigDecimal calculateVacation(BigDecimal averageSalary, int vacationDays) {
        BigDecimal salaryPerDay = averageSalary.divide(BigDecimal.valueOf(AVERAGE_DAYS_MONTH), 2, RoundingMode.HALF_EVEN);
        BigDecimal paymentWithoutNDFL = salaryPerDay.multiply(BigDecimal.valueOf(vacationDays));
        BigDecimal NDFLAmount = paymentWithoutNDFL.multiply(BigDecimal.valueOf(NDFL_PERCENT)).setScale(0, RoundingMode.HALF_EVEN);
        return paymentWithoutNDFL.subtract(NDFLAmount);
    }
}
