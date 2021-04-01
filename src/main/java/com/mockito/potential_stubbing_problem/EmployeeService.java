package com.mockito.potential_stubbing_problem;

public class EmployeeService {

	EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public void addEmployee(Employee employee) {
		EmployeeEntity entity = new EmployeeEntity();

		entity.setId(employee.getId());
		entity.setName(employee.getName());
		entity.setSalary(employee.getSalary());
		entity.setRole(employee.getRole());

		employeeRepository.addEmployee(entity);

	}

}
