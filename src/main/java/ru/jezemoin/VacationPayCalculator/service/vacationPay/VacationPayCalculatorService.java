package ru.jezemoin.VacationPayCalculator.service.vacationPay;

import java.math.BigDecimal;

public interface VacationPayCalculatorService {
    BigDecimal calculateVacation(BigDecimal averageSalary, int vacationDays);
}
