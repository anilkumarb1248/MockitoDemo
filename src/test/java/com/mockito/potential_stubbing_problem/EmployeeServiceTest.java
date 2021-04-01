package com.mockito.potential_stubbing_problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeRepository employeeRepository;
	
	@Captor
	ArgumentCaptor<EmployeeEntity> argumentCaptor;

	@Test
	void addEmployeeTest() {
		Employee employee = new Employee(100, "Anil", 1000, "TA");
		EmployeeEntity entity = new EmployeeEntity(100, "Anil", 1000, "TA");

		doNothing().when(employeeRepository).addEmployee(entity);
		employeeService.addEmployee(employee);
	}

	@Test
	void addEmployeeTest_without_ArgumentCaptor() {
		Employee employee = new Employee(100, "Anil", 1000, "TA");
		EmployeeEntity entity = new EmployeeEntity(100, "Anil", 1000, "TA");

		employeeService.addEmployee(employee);
		verify(employeeRepository).addEmployee(entity);
	}

@Test
void addEmployeeTest_with_ArgumentCaptor() {
	Employee employee = new Employee(100, "Anil", 1000, "TA");

	ArgumentCaptor<EmployeeEntity> argumentCaptor = ArgumentCaptor.forClass(EmployeeEntity.class);

	employeeService.addEmployee(employee);
	verify(employeeRepository).addEmployee(argumentCaptor.capture());
	EmployeeEntity entity = argumentCaptor.getValue();
	assertEquals("Anil", entity.getName());
}
}
