<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Equipos del Giro</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="">Navbar</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="#">Home</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <br/>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Equipos</h3>
			<hr>
			<div class="container text-left">
				<a href="<%= request.getContextPath()%>/teams/new" class="btn btn-success">Agregar Usuario</a>
			</div>
			<br>
			<table class="table table-bordered">
			<thead>
				<tr>
                <th>Imagen</th>
				<th>ID</th>
				<th>Nombre</th>
				<th>Pais</th>
				<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${teams}">
				<tr>
                    <td>
                        <img src="img/${team.id}.png" alt="${team.id}">
                    </td>
					<td>
						<c:out value="${team.id}"/>
					</td>
					<td>
						<c:out value="${team.name}"/>
					</td>
					<td>
						<c:out value="${team.country}"/>
					</td>
					<td>
						<a href="edit?id=<c:out value='${team.id}'/>">Editar</a>
						<a href="delete?id=<c:out value='${team.id}'/>">Borrar</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
	</div>
</body>
</html>