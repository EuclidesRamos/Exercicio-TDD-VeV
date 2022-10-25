package calculator;

import models.Employee;

public class Calculator {
    public static Double calculateSalary(Employee e) {
        if (e.getRole().equals("Desenvolvedor")){
            if(e.getSalary() >= 3000){
                return e.getSalary()*0.8;
            } else {
                return e.getSalary()*0.9;
            }
        } else if ((e.getRole().equals("DBA")) || (e.getRole().equals("Testador"))) {
            if (e.getSalary() >= 2000) {
                return e.getSalary() * 0.75;
            } else {
                return e.getSalary() * 0.85;
            }
        }
        return e.getSalary();
    }
}
