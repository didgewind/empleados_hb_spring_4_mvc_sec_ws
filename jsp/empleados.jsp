<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>
<p>
	<form:form modelAttribute="empleado">
		<form:errors path="*"/>
		<table>
			<tr>
				<td>Cif:</td>
				<td><form:input type="text" path="cif" /></td>
			</tr>
			<tr>
				<td><spring:message code="nombre" /></td>
				<td><form:input type="text" path="nombre" /></td>
			</tr>
			<tr>
				<td>Apellidos:</td>
				<td><form:input type="text" path="apellidos" /></td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td><form:input type="text" path="edad" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="muestra" value="Get1" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="muestraTodos" value="GetAll" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="inserta" value="Ins" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="modifica" value="Mod" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="elimina" value="Del" /></td>
			</tr>
		</table>

	</form:form>
</p>

<p>
<a href="gestEmpleados/empConDir.do">Datos extra</a> <a href="logout">logout</a>
</p>

<p>
		<c:choose>
			<c:when test="${opcion=='muestra'}">
				<table>
					<tr>
						<th>Cif</th>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Edad</th>
					</tr>
					<tr>
						<td>${empleado.cif}</td>
						<td>${empleado.nombre}</td>
						<td>${empleado.apellidos}</td>
						<td>${empleado.edad}</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${opcion=='muestraTodos'}">
				<table>
					<tr>
						<th>Cif</th>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Edad</th>
					</tr>
					<c:forEach items="${listaEmpleados}" var="empleadoamostrar">
						<tr>
							<td>${empleadoamostrar.cif}</td>
							<td>${empleadoamostrar.nombre}</td>
							<td>${empleadoamostrar.apellidos}</td>
							<td>${empleadoamostrar.edad}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>

		<c:when test="${opcion=='inserta' or opcion=='modifica' or opcion=='elimina'}">
			${mensaje}
		</c:when>

		</c:choose>

</p>
</body>
</html>