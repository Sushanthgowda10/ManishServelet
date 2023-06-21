<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					Employee Management App </a>
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
				<form action="insert" method="post">
					<caption>
						<h2>Add New Employee</h2>
					</caption>


					<fieldset class="form-group">
						<label>First Name</label> <input required="required" type="text"
							class="form-control" name="first_name">
					</fieldset>

					<fieldset class="form-group">
						<label>Last Name</label> <input required="required" type="text"
							class="form-control" name="last_name">
					</fieldset>


					<fieldset class="form-group">
						<label>Gender</label> <br>
						<div
							style="display: flex; flex-direction: row-reverse; justify-content: space-evenly; width: 50%;">
							<input required="required" type="radio" value="F"
								class="form-check-input" name="gender">Female <input
								style="left: 10%" required="required" type="radio" value="M"
								class="form-check-input" name="gender">Male
						</div>
					</fieldset>

					<fieldset class="form-group">
						<label>Address</label> <input required="required" type="text"
							class="form-control" name="adress">
					</fieldset>

					<fieldset class="form-group">
						<label>Date of birth (YYYY-MM-DD)</label> <input required="required"
							type="text" class="form-control" name="date_of_birth">
					</fieldset>

					<fieldset class="form-group">
						<label>Contact Number</label> <input type="tel"  required="required"
						 pattern="[0-9]{10}" class="form-control" name="contact_no">
					</fieldset>

					<fieldset class="form-group">
					<label>Employee Type</label> <br>
						<div
							style="display: flex; flex-direction: row-reverse; justify-content: space-around; width: 90%;">
							<input style="margin-right: -7%"  type="radio" value="FTE" required="required"
								class="form-check-input" name="emp_type">Full Time Employee <input
								style="left: 8%" type="radio" value="CON" required="required"
								class="form-check-input" name="emp_type">Contract Employee
						</div>
					</fieldset>
					<br>
					<button type="submit" class="btn btn-success">Save Details</button>
				</form>

				<%-- <fieldset class="form-group">
						<label>Employee Status</label> <input type="text"
							value="<c:out value='${employee.emp_status}' />"
							class="form-control" name="emp_status">
					</fieldset> 


				<<fieldset class="form-group">
						<label>Joining Date</label> <input type="text"
							value="<c:out value='${employee.joining_date}' />"
							class="form-control" name="joining_date">
					</fieldset> 

				<fieldset class="form-group">
						<label>Experience</label> <input type="text"
							value="<c:out value='${employee.exp_level}' />"
							class="form-control" name="emp_status">
					</fieldset> 

				
					value="<c:out value='${employee.first_name}' />"
					value="<c:out value='${employee.last_name}' />"
					value="<c:out value='${employee.gender}' />"
					value="<c:out value='${employee.adress}' />".
					value="<c:out value='${employee.date_of_birth}' />"
					value="<c:out value='${employee.contact_no}' />"
					value="<c:out value='${employee.emp_type}' />"
					
					 <fieldset class="form-group">
						<label>User email</label> <input type="text"
							value="<c:out value='${employee.email}' />" class="form-control"
							name="email">
					</fieldset>
					
					<<c:if test="${employee == null}">
						<input type="hidden" name="id"
							value="<c:out value='${employee.emp_id}' />" />
					</c:if> 

				<fieldset class="form-group">
						<label>Employee Id</label> <input type="text"
							value="<c:out value='${employee.emp_id}' />" class="form-control"
							name="emp_id">
					</fieldset>

					<fieldset class="form-group">
						<label>ISID</label> <input type="text"
							value="<c:out value='${employee.is_id}' />" class="form-control"
							name="is_id">
					</fieldset> --%>
			</div>
		</div>
	</div>
</body>
</html>