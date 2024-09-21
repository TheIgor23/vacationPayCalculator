package ru.jezemoin.VacationPayCalculator.controller;

import jakarta.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jezemoin.VacationPayCalculator.dto.VacationPayResponse;
import ru.jezemoin.VacationPayCalculator.service.paymentDays.PaymentDaysCalculatorService;
import ru.jezemoin.VacationPayCalculator.service.vacationPay.VacationPayCalculatorService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@Validated
public class VacationPayCalculatorController {
    private final VacationPayCalculatorService vacationCalculatorService;
    private final PaymentDaysCalculatorService paymentDaysCalculatorService;

    public VacationPayCalculatorController(VacationPayCalculatorService vacationCalculatorService, PaymentDaysCalculatorService paymentDaysCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
        this.paymentDaysCalculatorService = paymentDaysCalculatorService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<VacationPayResponse> calculate(
            @RequestParam("averageSalary") @Min(value = 0,message = "salary must be greater or equal than 0") BigDecimal averageSalary,
            @RequestParam("vacationDays") @Min(value = 0,message = "vacation days must be greater or equal than 0") int vacationDays,
            @RequestParam(value = "vacationDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate vacationDate)
    {
        if(vacationDate != null){
            vacationDays = paymentDaysCalculatorService.calculatePaymentDays(vacationDays, vacationDate);
        }
        BigDecimal payment = vacationCalculatorService.calculateVacation(averageSalary, vacationDays);
        return ResponseEntity.ok().body(new VacationPayResponse(payment));
    }
}
