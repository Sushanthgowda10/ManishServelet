<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Softtek Employee Management Application</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
.input-group.input-group-unstyled input.form-control {
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
}

.input-group-unstyled .input-group-addon {
	border-radius: 4px;
	border: 0px;
	background-color: transparent;
}
</style>
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

	<div class="ro">
		<div class="alert alert-success" id="alert" *ngIf='message'
			style="visibility: hidden;">${message}</div>

		<div class="container">
			<h3 class="text-center">List of Users</h3>

			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a> <a href="<%=request.getContextPath()%>/P_to_C"
					class="btn btn-success" id="pc"> Prob 2 Conf-</a> <a
					href="<%=request.getContextPath()%>/w" class="btn btn-success">Statistics</a>
				<div style="float: right; width: 200px; position: relative;"
					class="input-group input-group-unstyled">
					<input type="text" class="form-control" /> <span
						class="input-group-addon"> <i class="fa fa-search"
						style="position: absolute; right: 4%; bottom: 25%;"></i>
					</span>
				</div>
				&nbsp; <a style="float: right; color: white; margin-right: 10px;"
					href="<%=request.getContextPath()%>/new" class="btn btn-dark">
					Search User</a>&nbsp; <br> <br>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Employee Id</th>
						<th>Name</th>
						<th>ISID</th>
						<th>Email</th>
						<th>Contact Number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="emp" items="${listEmployee}">

						<tr>
							<td><c:out value="${emp.emp_id}" /></td>
							<td><c:out value="${emp.first_name} ${emp.last_name}" /></td>
							<td><c:out value="${emp.is_id}" /></td>
							<td><c:out value="${emp.email}" /></td>
							<td><c:out value="${emp.contact_no}" /></td>
							<td><a class="btn btn-primary btn-sm"
								href="edit?emp_id=<c:out value='${emp.emp_id}' />"><i
									class="fas fa-edit"></i> Edit</a> &nbsp; <a
								class="btn btn-danger btn-sm"
								href="delete?emp_id=<c:out value='${emp.emp_id}' />"><i
									class="fa fa-trash" aria-hidden="true"></i> Delete</a> &nbsp; <a
								class="btn btn-warning btn-sm"
								href="view?emp_id=<c:out value='${emp.emp_id}' />"><i
									class="fa-solid fa-eye"></i> View</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

	
	<script>
		document.getElementById("pc").addEventListener("click", alert);

		function alert() {
			document.getElementById("alert").style.visibility = visible;
		}
	</script>
</body>
</html>

