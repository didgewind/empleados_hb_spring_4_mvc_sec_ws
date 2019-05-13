package profe.empleados.daos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import profe.empleados.model.Direccion;
import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;
import profe.empleados.model.Sala;
import profe.empleados.model.Teclado;

@Repository("daoMock")
@Primary
public class EmpleadosDAOMock implements EmpleadosDAO {

	private Map<String, Empleado> mpEmpleados = new HashMap<>();
	
	public EmpleadosDAOMock() {
		mpEmpleados.put("123452435T",new Empleado("123452435T", "Esthela", "Ruíz", 54)); 
		
/*		(new Empleado("223452435A", "Manuel", "Alonso", 64));   
		(new Empleado("323452435B", "Mirkka", "Touko", 22));    
		(new Empleado("523452435S", "Ethan", "Hawk", 47));      
		(new Empleado("623452435D", "Jesús", "Gutiérrez", 81)); */
	}
	
	@Override
	public Empleado getEmpleado(String cif) {
		Empleado eReturn = null;
		try {
			 eReturn = (Empleado) mpEmpleados.get(cif).clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eReturn;
	}

	@Override
	public Set<Empleado> getAllEmpleados() {
		Set<Empleado> lReturn = new HashSet<Empleado>();
		for (Empleado emp : mpEmpleados.values()) {
			try {
				lReturn.add((Empleado) emp.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lReturn;
	}

	public void setEmpleados(Map<String, Empleado> mpEmpleados) {
		this.mpEmpleados = mpEmpleados;
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		Empleado eAux = this.mpEmpleados.remove(cif);
		return (eAux != null);
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		if (this.existeEmpleado(emp.getCif())) {
			return false;
		} else {
			try {
				this.mpEmpleados.put(emp.getCif(), (Empleado) emp.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return true;
		}
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		if (!this.existeEmpleado(emp.getCif())) {
			return false;
		} else {
			try {
				this.mpEmpleados.put(emp.getCif(), (Empleado) emp.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return true;
		}
	}

	private boolean existeEmpleado(String cif) {
		return this.mpEmpleados.containsKey(cif);
	}
	
	@PostConstruct
	/**
	 * Para rellenar el dao con muchos m�s empleados program�ticamente
	 */
	public void completaDAO() {
		this.mpEmpleados = new HashMap<>();
		this.insertaEmpleado(new Empleado("123452435T", "Esthela", "Ruíz", 54));
		this.insertaEmpleado(new Empleado("223452435A", "Manuel", "Alonso", 64));
		this.insertaEmpleado(new Empleado("323452435B", "Mirkka", "Touko", 22));
		this.insertaEmpleado(new Empleado("523452435S", "Ethan", "Hawk", 47));
		this.insertaEmpleado(new Empleado("623452435D", "Jes�s", "Guti�rrez", 81));
		this.insertaEmpleado(new Empleado("723452435F", "Anne", "Ru�z", 69));
		this.insertaEmpleado(new Empleado("823452435G", "Nohem�", "Ru�z", 77));
		this.insertaEmpleado(new Empleado("923452435H", "Lorena", "Corujo", 54));
		this.insertaEmpleado(new Empleado("163452435J", "Amaya", "Valiente", 11));
		this.insertaEmpleado(new Empleado("153452435K", "Javier", "Bravo", 14));
		this.insertaEmpleado(new Empleado("143452435L", "Miguel", "Ciruelo", 87));
		this.insertaEmpleado(new Empleado("173452435E", "Pedro", "Conejero", 32));
	}


	public boolean eliminaAllEmpleados() {
		this.mpEmpleados.clear();
		return true;
	}
	
	@Override
	public Set<Direccion> getAllDirecciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evento getEvento(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sala getSala(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminaSala(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Nomina getNomina(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teclado getTeclado(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
