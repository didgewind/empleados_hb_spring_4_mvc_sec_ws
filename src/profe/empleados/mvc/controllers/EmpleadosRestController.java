package profe.empleados.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import profe.empleados.model.Empleado;
import profe.empleados.negocio.EmpleadosNegocio;

@RestController
public class EmpleadosRestController {

	@Autowired
	private EmpleadosNegocio negocio;
	

	@RequestMapping("/{cif}")
	public Empleado getEmpleado(@PathVariable String cif) {
		return negocio.getEmpleado(cif);
	}
}
