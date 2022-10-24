package Tests;

import Models.Employee;
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
}
