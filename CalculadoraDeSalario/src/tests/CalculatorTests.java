package tests;

import models.Employee;
import calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    @Test
    void createEmployee() {
        Employee bob = new Employee("Bob Esponja", "bob.esponja@siricascudo.com", 1500.0, "Desenvolvedor");

        assertEquals("Bob Esponja", bob.getName());
        assertEquals("bob.esponja@siricascudo.com", bob.getEmail());
        assertEquals(1500, bob.getSalary());
        assertEquals("Desenvolvedor", bob.getRole());
    }

    @Test
    void CalculateSalaryDeveloper() {
        Employee e = new Employee("Bob Esponja", "bob.esponja@siricascudo.com", 3000.0, "Desenvolvedor");
        Employee e2 = new Employee("Lula Molusco", "lula.molusco@siricascudo.com", 2000.0, "Desenvolvedor");

        assertEquals(e.getSalary() * 0.8, Calculator.calculateSalary(e));
        assertEquals(e2.getSalary() * 0.9, Calculator.calculateSalary(e2));
    }
}
