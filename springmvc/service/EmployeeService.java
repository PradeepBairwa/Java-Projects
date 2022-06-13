package springmvc.service;

import java.util.List;

import springmvc.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	public List<Employee> getEmployees();
	public void deleteEmployee(int pid);
	public Employee getEmployee(int eid);

}
