# Приложение "Калькулятор отпускных".

Микросервис на SpringBoot + Java 17

_НДФЛ учитывается при рассчетах_
# API

### Без учета выходных и праздников
##### Parameters
    vacationDays: количество дней отпуска
    
    averageSalary: средняя зарплата за 12 месяцев

http://localhost:8080/api/calculate?averageSalary=50500&vacationDays=10

##### Response
    {
        "vacationPay": 14994.50
    }

### С учетом выходных и праздников
##### Parameters
    vacationDays: количество дней отпуска

    averageSalary: средняя зарплата за 12 месяцев

    vacationDate: дата начала отпуска
    
    

http://localhost:8080/api/calculate?averageSalary=50500&vacationDays=10&vacationDate=2024-05-02
#### Response:
    {
        "vacationPay": 8997.30
    }