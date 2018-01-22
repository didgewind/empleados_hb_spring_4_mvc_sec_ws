package profe.empleados.daos;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import profe.empleados.model.Direccion;
import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;
import profe.empleados.model.Sala;
import profe.empleados.model.Teclado;
import profe.empleados.util.HibernateUtil;

public class EmpleadosDAOHB implements EmpleadosDAO {

	/* * Devuelve la sesi�n activa para ser utilizada dentro del DAO */
	private Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	@Override
	public Empleado getEmpleado(String cif) {
		return (Empleado) getSession().get(Empleado.class, cif);
	}

	@Override
	public Set<Empleado> getAllEmpleados() {
		return new HashSet<Empleado>(getSession().createQuery("from Empleado").list());
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		getSession().persist(emp);
		return true;
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		getSession().update(emp);
		return true;
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		/* Mejor así por si hay cascade delete en alguna relación */
		Empleado empAux = this.getEmpleado(cif);
		getSession().delete(empAux);
		return true;
	}

	@Override
	public Set<Direccion> getAllDirecciones() {
		return new HashSet<Direccion>(getSession().createQuery("from Direccion").list());
	}

	@Override
	public Evento getEvento(long id) {
		return (Evento) getSession().get(Evento.class, id);
	}

	@Override
	public Sala getSala(String id) {
		return (Sala) getSession().get(Sala.class, id);
	}

	@Override
	public boolean eliminaSala(String id) {
		Sala sala = (Sala) getSession().get(Sala.class, id);
		getSession().delete(sala);
		return true;
	}

	@Override
	public Nomina getNomina(long id) {
		return (Nomina) getSession().get(Nomina.class, id);
	}

	@Override
	public Teclado getTeclado(String id) {
		return (Teclado) getSession().get(Teclado.class, id);
	}

}
