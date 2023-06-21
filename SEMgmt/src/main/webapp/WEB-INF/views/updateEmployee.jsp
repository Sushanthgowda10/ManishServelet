<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Employee
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Home</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${employee != null}">
					<form action="update" method="post">
				</c:if>
				<%-- <c:if test="${employee == null}">
				<!-- 	<form action="insert" method="post"> -->
				</c:if> --%>

				<caption>
					<h2>
						<c:if test="${employee != null}">
            			Edit Employee
            		</c:if>
					<%-- 	<c:if test="${employee == null}">
            			Add New Employee
            		</c:if> --%>
					</h2>
				</caption>

				<c:if test="${employee != null}">
					<input type="hidden" name="id"
						value="<c:out value='${employee.emp_id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Employee Id</label> <input  readonly="readonly"  type="text"
						value="<c:out value='${employee.emp_id}' />"
						class="form-control" name="emp_id" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>ISID</label> <input  readonly="readonly" type="text"
						value="<c:out value='${employee.is_id}' />"
						class="form-control" name="is_id" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${employee.first_name}' />"
						class="form-control" name="first_name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${employee.last_name}' />"
						class="form-control" name="last_name">
				</fieldset>

				<fieldset class="form-group">
						<label>Gender</label> <br>
						<div
							style="display: flex; flex-direction: row-reverse; justify-content: space-evenly; width: 50%;">
							<input required="required" type="radio" value="<c:out value='${employee.gender}' />"
								class="form-check-input" name="gender">Female <input
								style="left: 10%" required="required" type="radio" value="<c:out value='${employee.gender}' />"
								class="form-check-input" name="gender">Male
						</div>
					</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${employee.adress}' />" class="form-control"
						name="adress">
				</fieldset>

				<fieldset class="form-group">
					<label>User email</label> <input readonly="readonly" type="text"
						value="<c:out value='${employee.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Date of birth</label> <input type="text"
						value="<c:out value='${employee.date_of_birth}' />"
						class="form-control" name="date_of_birth">
				</fieldset>

				<fieldset class="form-group">
					<label>Contact Number</label> <input pattern="[0-9]{10}" type="tel"
						value="<c:out value='${employee.contact_no}' />"
						class="form-control" name="contact_no">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Joining Date</label> <input readonly="readonly" type="text"
						value="<c:out value='${employee.joining_date}' />"
						class="form-control" name="joining_date">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee Type</label> <input readonly="readonly" type="text"
						value="<c:out value='${employee.emp_type}' />"
						class="form-control" name="emp_type">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee Status</label> <input readonly="readonly" type="text"
						value="<c:out value='${employee.emp_status}' />"
						class="form-control" name="emp_status">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Experience</label> <input readonly="readonly" type="text"
						value="<c:out value='${employee.exp_level}' />"
						class="form-control" name="emp_status">
				</fieldset>

				<button type="submit" class="btn btn-success">Save details</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>