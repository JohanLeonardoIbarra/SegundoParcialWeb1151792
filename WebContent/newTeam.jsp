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
          <a class="navbar-brand" href="/GiroDItalia/teams/list">Navbar</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/GiroDItalia/teams/list">Home</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
	<div class="containder col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${team != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${team == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${team != null}">
							Editar Equipo
						</c:if>
						<c:if test="${team == null}">
							Agregar Nuevo Equipo
						</c:if>
					</h2>
				</caption>
				
				<c:if test="${team != null}">
					<input type="hidden" name="id" value="<c:out value='${team.id}'/>"/>
				</c:if>
				
				<fieldset class="form-group">
					<label>Id del equipo</label> <input type="text" value="<c:out value='${team.id}'/>" class="form-control" name="nombre" required="required" />
				</fieldset>
				<fieldset class="form-group">
					<label>Nombre</label> <input type="text" value="<c:out value='${team.name}'/>" class="form-control" name="email" />
				</fieldset>
				<fieldset class="form-group">
					<label>Pais</label> <select name="pais">
											<c:forEach var="pais" items="${paises}">
  												<option value="value1">${pais.name}</option>
  											</c:forEach>
										</select>
				</fieldset>
				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>