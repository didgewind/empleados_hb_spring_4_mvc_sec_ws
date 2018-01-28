<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<body>
<p>
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
</p>
Dirección: ${empleado.direccion}
<p>
<a href="../gestEmpleados.do">Volver atrás</a>
</p>				
</body>
</html>