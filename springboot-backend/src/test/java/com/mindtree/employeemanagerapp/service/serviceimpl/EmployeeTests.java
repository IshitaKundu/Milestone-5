package com.mindtree.employeemanagerapp.service.serviceimpl;


import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mindtree.employeemanagerapp.controller.EmployeeController;
import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;
 
 
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeTests {
 
  @Autowired
  EmployeeRepository employeeRepository;
  
  
 
  @Test
  public void addNewEmployee() {
    Employee employee = new Employee("Ishita", "Kundu", "ishita@gmail.com");
    employeeRepository.save(employee);
    Assertions.assertThat(employee.getId()).isGreaterThan(0);
  }
  
  @Test
  public void findById() {
    employeeRepository.findById(2L).get();   
    assertEquals("abc", employeeRepository.findById(2L).get().getFirstName());
  }
  
  @Test
  public void deleteEmployeeById() {
    employeeRepository.deleteById(2L);
    List<Employee> employees = employeeRepository.findAll();
    for (Employee employee : employees) {
		System.out.println(employee.getFirstName());
	}
    assertEquals(0, employees.size());
  }
  
  
  
  
  
 
  
  
}
	
	
	
	
	
	

