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
    @Test
    void CalculateSalaryDBA() {
        Employee e = new Employee("Bob Esponja", "bob.esponja@siricascudo.com", 2000.0, "DBA");
        Employee e2 = new Employee("Lula Molusco", "lula.molusco@siricascudo.com", 1500.0, "DBA");

        assertEquals(e.getSalary() * 0.75, Calculator.calculateSalary(e));
        assertEquals(e2.getSalary() * 0.85, Calculator.calculateSalary(e2));
    }

    @Test
    void CalculateSalaryTester() {
        Employee e = new Employee("Bob Esponja", "bob.esponja@siricascudo.com", 2000.0, "Testador");
        Employee e2 = new Employee("Lula Molusco", "lula.molusco@siricascudo.com", 1500.0, "Testador");

        assertEquals(e.getSalary() * 0.75, Calculator.calculateSalary(e));
        assertEquals(e2.getSalary() * 0.85, Calculator.calculateSalary(e2));
    }

    @Test
    void CalculateSalaryManager() {
        Employee e = new Employee("Bob Esponja", "bob.esponja@siricascudo.com", 5000.0, "Gerente");
        Employee e2 = new Employee("Lula Molusco", "lula.molusco@siricascudo.com", 4000.0, "Gerente");

        assertEquals(e.getSalary() * 0.7, Calculator.calculateSalary(e));
        assertEquals(e2.getSalary() * 0.80, Calculator.calculateSalary(e2));
    }
}
