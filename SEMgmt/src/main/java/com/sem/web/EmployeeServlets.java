package com.sem.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sem.dao.EmployeeDAO;
import com.sem.dao.IEmployeeDAO;
import com.sem.domain.Employee;
import com.sem.helper.EmployeeHelper;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO empDAO;

	public EmployeeServlets() {

		// TODO Auto-generated constructor stub
	}

	public void init() {
		empDAO = new EmployeeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/P_to_C":
				comfirmEmployee(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/view":
				viewEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			case "/list":
				listEmployee(request, response);
				break;
			case "/":
				listEmployee(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDAO emoDAO = new EmployeeDAO();
		List<Employee> listEmployee = emoDAO.ReadAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/indexEmployee.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String emp_id = request.getParameter("emp_id");
		empDAO.DeleteEmployee(emp_id);
		response.sendRedirect("list");
	}

	private void viewEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDAO emoDAO = new EmployeeDAO();
		String emp_id = request.getParameter("emp_id");
		Employee ViewEmployee = emoDAO.ViewEmployee(emp_id);
		request.setAttribute("viewEmployee", ViewEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/viewEmployee.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addEmployee.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String emp_id = request.getParameter("emp_id");
		Employee existingUser = empDAO.ViewEmployee(emp_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/updateEmployee.jsp");
		request.setAttribute("employee", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String adress = request.getParameter("adress");
		String date_of_birth = request.getParameter("date_of_birth");
		String gender = request.getParameter("gender");
		String contact_no = request.getParameter("contact_no");
		String emp_type = request.getParameter("emp_type");

		Employee newEmployee = new Employee(EmployeeHelper.getEmpID(), EmployeeHelper.getISID(first_name, last_name),
				first_name, last_name, adress, date_of_birth, gender, contact_no,
				EmployeeHelper.getEmailID(first_name, last_name), EmployeeHelper.getCurrentDate(), emp_type,
				IEmployeeDAO.EMP_STATUS, 0);
		employeeDAO.InsertEmployee(newEmployee);
		response.sendRedirect("list");
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String emp_id = request.getParameter("emp_id");
		String is_id = request.getParameter("is_id");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String adress = request.getParameter("adress");
		String gender = request.getParameter("gender");
		String date_of_birth = request.getParameter("date_of_birth");
		String email = request.getParameter("email");
		String contact_no = request.getParameter("contact_no");
		String joining_date = request.getParameter("joining_date");
		String emp_type = request.getParameter("emp_type");
		String emp_status = request.getParameter("emp_status");
		String exp_level = request.getParameter("exp_level");

		Employee newEmployee = new Employee(emp_id, is_id, first_name, last_name, adress, date_of_birth, gender, email,
				contact_no, joining_date, emp_type, emp_status, 0);
		empDAO.UpdateEmployee(newEmployee);
		response.sendRedirect("list");
	}

	private void comfirmEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String rs = empDAO.ProviToPermanent();
		request.setAttribute("message", rs);
		response.sendRedirect("list");
	}
}
