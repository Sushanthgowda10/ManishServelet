package com.sem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sem.domain.Employee;
import com.sem.helper.EmployeeHelper;

public class EmployeeDAO implements IEmployeeDAO {

	public EmployeeDAO() {

	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public List<Employee> ReadAllEmployees() {
		List<Employee> Emp = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(VIEW_EMPLOYEES_DATA);) {

			ResultSet rs = preparedStament.executeQuery();

			while (rs.next()) {
				String emp_id = rs.getString("emp_id");
				String is_id = rs.getString("is_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String adress = rs.getString("address");
				String date_of_birth = rs.getString("date_of_birth");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String contact_no = rs.getString("contact_no");
				String joining_date = rs.getString("joining_date");
				String emp_type = rs.getString("emp_type");
				String emp_status = rs.getString("emp_status");
				int exp_level = rs.getInt("exp_level");

				Emp.add(new Employee(emp_id, is_id, first_name, last_name, adress, date_of_birth, gender, email,
						contact_no, joining_date, emp_type, emp_status, exp_level));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Emp;
	}

	@Override
	public Employee ViewEmployee(String emp_id) {

		Employee EmpView = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(READ_EMPLOYEE_DATA);) {
			preparedStament.setString(1, emp_id);
			ResultSet rs = preparedStament.executeQuery();
			while (rs.next()) {
				String empid = rs.getString("emp_id");
				String is_id = rs.getString("is_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String adress = rs.getString("address");
				String date_of_birth = rs.getString("date_of_birth");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String contact_no = rs.getString("contact_no");
				String joining_date = rs.getString("joining_date");
				String emp_type = rs.getString("emp_type");
				String emp_status = rs.getString("emp_status");
				int exp_level = rs.getInt("exp_level");

				EmpView = new Employee(empid, is_id, first_name, last_name, adress, date_of_birth, gender, email,
						contact_no, joining_date, emp_type, emp_status, exp_level);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return EmpView;
	}

	@Override
	public boolean DeleteEmployee(String emp_id) {
        boolean rowDeleted= false;
        try (Connection connection = getConnection();
                PreparedStatement preparedstament = connection.prepareStatement(DELETE_EMPLOYEE_DATA);) {
        	preparedstament.setString(1, emp_id);
            rowDeleted = preparedstament.executeUpdate() > 0;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rowDeleted;
    }

//	@Override
//	public void InsertEmployee(Employee EmpInsert) {
//		try (Connection connection = getConnection();
//				PreparedStatement preparedStament = connection.prepareStatement(INSERT_EMPLOYEE_DATA);) {
//			preparedStament.setString(1, EmployeeHelper.getEmpID());
//			preparedStament.setString(2, EmployeeHelper.getISID(EmpInsert.getFirst_name(), EmpInsert.getLast_name()));
//			preparedStament.setString(3, EmpInsert.getFirst_name());
//			preparedStament.setString(4, EmpInsert.getLast_name());
//			preparedStament.setString(5, EmpInsert.getAdress());
//			preparedStament.setString(6, EmpInsert.getDate_of_birth());
//			preparedStament.setString(7, EmpInsert.getGender());
//			preparedStament.setString(8,
//					EmployeeHelper.getEmailID(EmpInsert.getFirst_name(), EmpInsert.getLast_name()));
//			preparedStament.setString(9, EmpInsert.getContact_no());
//			preparedStament.setString(10, EmployeeHelper.getCurrentDate());
//			preparedStament.setString(11, IEmployeeDAO.EMP_TYPE);
//			preparedStament.setString(12, EmpInsert.getEmp_status());
//			preparedStament.setInt(13, EmpInsert.getExp_level());
//			preparedStament.executeUpdate();
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
	@Override
	public void InsertEmployee(Employee EmpInsert) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(INSERT_EMPLOYEE_DATA);) {
			preparedStament.setString(1, EmpInsert.getEmp_id());
			preparedStament.setString(2, EmpInsert.getIs_id());
			preparedStament.setString(3, EmpInsert.getFirst_name());
			preparedStament.setString(4, EmpInsert.getLast_name());
			preparedStament.setString(5, EmpInsert.getAdress());
			preparedStament.setString(6, EmpInsert.getDate_of_birth());
			preparedStament.setString(7, EmpInsert.getGender());
			preparedStament.setString(9, EmpInsert.getEmail());
			preparedStament.setString(8, EmpInsert.getContact_no());
			preparedStament.setString(10, EmpInsert.getJoining_date());
			preparedStament.setString(11, EmpInsert.getEmp_type() );
			preparedStament.setString(12, EmpInsert.getEmp_status());
			preparedStament.setInt(13, EmpInsert.getExp_level());
			preparedStament.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public boolean UpdateEmployee(Employee EmpUpdate) {
		boolean rowUpdated = false;
		try {
		Connection conection= getConnection();
		PreparedStatement preparedStament = conection.prepareStatement(UPDATE_EMPLOYEE_DATA);
		preparedStament.setString(1, EmpUpdate.getFirst_name());
		preparedStament.setString(2, EmpUpdate.getLast_name());
		preparedStament.setString(3, EmpUpdate.getAdress() );
		preparedStament.setString(4, EmpUpdate.getGender());
		preparedStament.setString(5, EmpUpdate.getDate_of_birth());
		preparedStament.setString(6, EmpUpdate.getContact_no());
		preparedStament.setString(7, EmpUpdate.getEmp_id());
		rowUpdated = preparedStament.executeUpdate() > 0;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	@Override
	public String ProviToPermanent() {
		int results = 0 ;
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(SELECT_ALL_PROBATION_EMP);) {
			ResultSet rs = preparedStament.executeQuery();
			while (rs.next()) {
				String emp_id = rs.getString("emp_id");
				String joining_date = rs.getString("joining_date");
				PreparedStatement preparedStament1 = connection.prepareStatement(FETCH_MONTH_DIFFERNCE);
				preparedStament1.setString(1, joining_date);
				ResultSet rs2 = preparedStament1.executeQuery();
				rs2.next();
				if (rs2.getInt(1) > 6) {
					PreparedStatement preparedStament3 = connection.prepareStatement(UPDATE_P_TO_C);
					preparedStament3.setString(1, emp_id);
					preparedStament3.executeUpdate();
					results++;
				}
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ("No_Of_Records_P_to_C ="+ results);
	}

	public static void main(String[] args) {
//		EmployeeDAO e = new EmployeeDAO();
//		System.out.println(e.ReadAllEmployees());
//		System.out.println(e.ViewEmployee("abc"));
//		System.out.println(e.DeleteEmployee("xyz"));
//		System.out.println(e.ReadAllEmployees());
//		System.out.println(e.ProviToPermanent());
//		System.out.println(e.);
	}

	

}
