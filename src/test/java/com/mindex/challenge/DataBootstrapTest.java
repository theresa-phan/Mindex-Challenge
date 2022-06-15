package com.mindex.challenge;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());
    }

    @Test
    public void employeeTest() {
        Employee employee = employeeRepository.findByEmployeeId("72b345ui-pll4-8623-88hj-p1234j72j93k");
        assertNotNull(employee);
        assertEquals("Captain", employee.getFirstName());
        assertEquals("America", employee.getLastName());
        assertEquals("Super Soldier", employee.getPosition());
        assertEquals("Special Ops", employee.getDepartment());
    }

    @Test
    public void compensationTest() {
        Employee employee = employeeRepository.findByEmployeeId("99j636mh-skf9-2929-77lk-q0987y45h88a");
        assertNotNull(employee);
        assertEquals("Matt", employee.getFirstName());
        assertEquals("Murdock", employee.getLastName());
        assertEquals("Lawyer", employee.getPosition());
        assertEquals("Justice", employee.getDepartment());
    }
}