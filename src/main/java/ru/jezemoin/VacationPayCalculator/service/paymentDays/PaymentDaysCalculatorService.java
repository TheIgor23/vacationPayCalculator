package ru.jezemoin.VacationPayCalculator.service.paymentDays;

import java.time.LocalDate;

public interface PaymentDaysCalculatorService {
    int calculatePaymentDays(int days, LocalDate startDate);
}
