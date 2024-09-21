package ru.jezemoin.VacationPayCalculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.jezemoin.VacationPayCalculator.service.vacationPay.VacationPayCalculatorService;
import ru.jezemoin.VacationPayCalculator.service.vacationPay.VacationPayCalculatorServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacationPayCalculatorServiceImplTest {
    private final VacationPayCalculatorService vacationPayCalculatorService = new VacationPayCalculatorServiceImpl();

    @Test
    public void testCalculateVacationPay() {
        BigDecimal averageSalary = new BigDecimal("60000");
        int vacationDays = 10;

        BigDecimal vacationPay = vacationPayCalculatorService.calculateVacation(averageSalary, vacationDays);
        BigDecimal expected = new BigDecimal("17815.80");

        assertEquals(expected, vacationPay, "Неверный расчет отпускных");
    }

    @Test
    public void testCalculateVacationPay_zeroSalary() {
        BigDecimal averageSalary = BigDecimal.ZERO;
        int vacationDays = 10;

        BigDecimal vacationPay = vacationPayCalculatorService.calculateVacation(averageSalary, vacationDays);
        BigDecimal expected = BigDecimal.ZERO;

        assertEquals(expected.stripTrailingZeros(), vacationPay.stripTrailingZeros(), "Неверный расчет отпускных при 0 зарплате");
    }
}
