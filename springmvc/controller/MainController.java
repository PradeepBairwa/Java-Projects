package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import springmvc.model.Employee;
import springmvc.service.EmployeeService;
import springmvc.serviceImpl.EmployeeServiceImpl;

@Controller
public class MainController {
	
//	@Autowired
//	 private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String home(Model m) {
//	List<Employee> employees=	employeeServiceImpl.getEmployees();
		List<Employee> employees=	employeeService.getEmployees();
	    m.addAttribute("employees",employees);
	    System.out.println(m);
		return "index";
	}
	//add employee form
	@RequestMapping("/add-employee")
	public String addEmployee(Model m) {
		m.addAttribute("title","Add Employee");
		return "add_employee_form";
	}
	
	//handle employee form
	@RequestMapping(value="/handle-employee",method = RequestMethod.POST)
	public RedirectView handleEmployee(@ModelAttribute Employee employee,HttpServletRequest request) {
		System.out.println(employee.getEmpId());
//		employeeServiceImpl.addEmployee(employee);
		employeeService.addEmployee(employee);
		 RedirectView redirectView =new RedirectView();
		 redirectView.setUrl(request.getContextPath()+"/");
		 return redirectView;
	}
	
	
	//delete handler
	@RequestMapping("/delete/{empId}")
	public RedirectView deleteEmployee(@PathVariable("empId")int empId, HttpServletRequest request) {
//		employeeServiceImpl.deleteEmployee(empId);
		employeeService.deleteEmployee(empId);

		RedirectView redirectView =new RedirectView();
		 redirectView.setUrl(request.getContextPath()+"/");
		 return redirectView;
	}
	
	//update handler
	@RequestMapping("/update/{empId}")
	public String updateForm(@PathVariable("empId") int empId,Model m) {
//	Employee employee=	this.employeeServiceImpl.getEmployee(empId);
		Employee employee=	this.employeeService.getEmployee(empId);

		m.addAttribute("employee",employee);
		return "update_form";
	}

}
