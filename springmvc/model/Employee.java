package springmvc.model;

import javax.annotation.Generated; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	private Long empPhoneNumber;
	private String empJoiningDate;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getEmpPhoneNumber() {
		return empPhoneNumber;
	}
	public void setEmpPhoneNumber(Long empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}
	public String getEmpJoiningDate() {
		return empJoiningDate;
	}
	public void setEmpJoiningDate(String empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}
	public Employee(int empId, String empName, Long empPhoneNumber, String empJoiningDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPhoneNumber = empPhoneNumber;
		this.empJoiningDate = empJoiningDate;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhoneNumber=" + empPhoneNumber
				+ ", empJoiningDate=" + empJoiningDate + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	


}
