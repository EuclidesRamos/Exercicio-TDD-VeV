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
        }
        return e.getSalary();
    }
}
