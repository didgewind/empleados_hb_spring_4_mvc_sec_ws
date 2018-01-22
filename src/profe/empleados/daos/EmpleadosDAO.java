package profe.empleados.daos;

import java.util.Set;

import profe.empleados.model.Direccion;
import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;
import profe.empleados.model.Sala;
import profe.empleados.model.Teclado;

public interface EmpleadosDAO {

	public abstract Empleado getEmpleado(String cif);

	public abstract Set<Empleado> getAllEmpleados();

	public abstract boolean insertaEmpleado(Empleado emp);

	public abstract boolean modificaEmpleado(Empleado emp);

	public abstract boolean eliminaEmpleado(String cif);
	
	public abstract Set<Direccion> getAllDirecciones();

	public abstract Evento getEvento(long id);
	
	public abstract Sala getSala(String id);
	
	public abstract boolean eliminaSala(String id);
	
	public abstract Nomina getNomina(long id);
	
	public abstract Teclado getTeclado(String id);
	
}
