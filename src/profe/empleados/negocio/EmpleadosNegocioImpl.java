package profe.empleados.negocio;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import profe.empleados.daos.EmpleadosDAO;
import profe.empleados.daos.EmpleadosDAOHB;
import profe.empleados.model.Direccion;
import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Sala;

@Service
@Transactional
public class EmpleadosNegocioImpl implements EmpleadosNegocio {

	/* dao inyectado por spring */
	@Resource(name="daoHbSpring")
	private EmpleadosDAO dao;
	
	/* dao resolución activa */
//	private EmpleadosDAO dao = new EmpleadosDAOHB();
	
	/* Esto es simplemente un ejemplo de autowired con required=false */
	@Autowired(required=false)
	private Date fecha;

	@Override
	public Empleado getEmpleado(String cif) {
		return dao.getEmpleado(cif);
	}

	@Override
	public Set<Empleado> getAllEmpleados() {
		return dao.getAllEmpleados();
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		dao.insertaEmpleado(emp);
		return true;
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		dao.modificaEmpleado(emp);
		return true;
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		dao.eliminaEmpleado(cif);
		return true;
	}

	public boolean insertaEmpleados(Collection<Empleado> emps) {
		for (Empleado emp : emps) {
			this.insertaEmpleado(emp);
		}
		return true;
	}

	public Set<Direccion> getAllDirecciones() {
		return dao.getAllDirecciones();
	}

	@Override
	public Evento getEvento(long id) {
		return dao.getEvento(id);
	}

	@Override
	public Sala getSala(String id) {
		return dao.getSala(id);
	}

	@Override
	public boolean eliminaSala(String id) {
		return dao.eliminaSala(id);
	}

	public void setDao(EmpleadosDAO dao) {
		this.dao = dao;
	}
}
