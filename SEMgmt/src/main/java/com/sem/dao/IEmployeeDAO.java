package com.sem.dao;

import java.util.List;

import com.sem.domain.Employee;

public interface IEmployeeDAO {
	String EMP_STATUS = "P";
	String jdbcURL = "jdbc:mysql://localhost:3306/servlets";
	String jdbcUsername = "root";
	String jdbcPassword = "Softtek@2022";
	String INSERT_EMPLOYEE_DATA = "insert into softtek_employee values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String VIEW_EMPLOYEES_DATA = "select * from softtek_employee";
	String DELETE_EMPLOYEE_DATA = "delete from softtek_employee where emp_id = ? ";
	String READ_EMPLOYEE_DATA = "select * from softtek_employee where emp_id = ? ";
	String UPDATE_P_TO_C = "update softtek_employee set emp_status = 'C' where emp_id=?";	
	String SELECT_ALL_PROBATION_EMP= "Select emp_id, joining_date from softtek_employee where emp_status = 'P'";
	String FETCH_MONTH_DIFFERNCE = "SELECT TIMESTAMPDIFF(MONTH, ?, now())";
	String UPDATE_EMPLOYEE_DATA = "update softtek_employee set first_name = ?, last_name = ?, address = ?, gender = ?, date_of_birth = ?, contact_no = ? where emp_id = ?";

	public List<Employee> ReadAllEmployees();

	public Employee ViewEmployee(String emp_id);

	//public int DeleteEmployee(String emp_id);
	
	//public int UpdateEmployee(String emp_id);

	public void InsertEmployee(Employee EmpInsert);
	
	public String ProviToPermanent();

	public boolean DeleteEmployee(String emp_id);

	public boolean UpdateEmployee(Employee EmpUpdate);
}
