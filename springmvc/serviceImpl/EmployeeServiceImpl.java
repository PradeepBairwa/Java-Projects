package springmvc.serviceImpl;

import java.util.List; 

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.TransactionManager;

import springmvc.model.Employee;
import springmvc.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	 private HibernateTemplate hibernateTemplate;
	

//	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(employee);

	}

//	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees=this.hibernateTemplate.loadAll(Employee.class);
		return employees;
	}

	
//	@Override
	@Transactional
	
	public void deleteEmployee(int pid) {
		// TODO Auto-generated method stub
		Employee p = this.hibernateTemplate.load(Employee.class, pid);
		this.hibernateTemplate.delete(p);
	}

//	@Override
	public Employee getEmployee(int eid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Employee.class, eid);
	}

}
