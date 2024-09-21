package ru.jezemoin.VacationPayCalculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.jezemoin.VacationPayCalculator.service.paymentDays.PaymentDaysCalculatorService;
import ru.jezemoin.VacationPayCalculator.service.paymentDays.PaymentDaysCalculatorServiceImpl;
import ru.jezemoin.VacationPayCalculator.utils.HolidayList;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PaymentDaysCalculatorServiceImplTest {

	private final PaymentDaysCalculatorService paymentDaysCalculatorService = new PaymentDaysCalculatorServiceImpl();

	@Test
	public void testCalculatePaymentDays_withoutHolidays() {
		LocalDate startDate = LocalDate.of(2024, 9, 1);

		int days = 10;
		int workingDays = paymentDaysCalculatorService.calculatePaymentDays(days, startDate);

		assertEquals(7, workingDays, "Неверный расчет рабочих дней без праздников");
	}

	@Test
	public void testCalculatePaymentDays_withHolidays() {
		LocalDate startDate = LocalDate.of(2024, 5, 1);
		int days = 7;

		List<LocalDate> holidays = HolidayList.getHolidays(2024);

		int workingDays = paymentDaysCalculatorService.calculatePaymentDays(days, startDate);

		assertEquals(4, workingDays, "Неверный расчет рабочих дней с праздниками");
	}
}
