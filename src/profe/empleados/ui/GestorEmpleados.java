package profe.empleados.ui;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ManagedSessionContext;

import profe.empleados.daos.EmpleadosDAO;
import profe.empleados.model.Direccion;
import profe.empleados.model.Empleado;
import profe.empleados.model.Evento;
import profe.empleados.model.Nomina;
import profe.empleados.model.Sala;
import profe.empleados.model.Teclado;
import profe.empleados.negocio.EmpleadosNegocio;
import profe.empleados.negocio.EmpleadosNegocioImpl;
import profe.empleados.util.HibernateUtil;

public class GestorEmpleados {

	private EmpleadosNegocio negocio = new EmpleadosNegocioImpl();
	private EmpleadosDAO dao;
	
	public static void main(String[] args) {
		new GestorEmpleados().go();
	}
	
	private void preGo() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ManagedSessionContext.bind(session);
		Transaction tx = session.beginTransaction();
		testGetTeclado();
		tx.commit();
		
		tx = session.beginTransaction();
		testGetDirYEmps();
		tx.commit();

		
		HibernateUtil.shutdown();
	}

	private void go() {
		System.out.println("Comienzo de la app...");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			listaEmpleados();
			tx.commit();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		}
		HibernateUtil.shutdown();
		System.out.println("Fin de la aplicaci�n");
	}

	private void testGetNomina() {
		Nomina nomina = dao.getNomina(1);
		System.out.println(nomina);
		System.out.println(nomina.getEmpleado());
	}
	
	private void testGetTeclado() {
		Teclado teclado = dao.getTeclado("PD001");
		System.out.println(teclado);
		System.out.println(teclado.getOrdenador());
	}
	
	
	private void listaEmpleados() {
		for (Empleado emp : negocio.getAllEmpleados()) {
			System.out.println(emp);
		}
	}
	
	private void testGetEmpleado() {
		Empleado emp = negocio.getEmpleado("01293474E");
		System.out.println(emp);
		System.out.println("Regalo: " + emp.getRegalo());
		System.out.println(emp.getDireccion());
		System.out.println(emp.getOrdenador());
		System.out.println(emp.getOrdenador().getEmpleado());
	}
	
	private void testInsertaEmpleados() {
//		negocio.eliminaAllEmpleados();
		List<Empleado> lEmps = new ArrayList<>();
		// a�adimos empleados a la lista
		lEmps.add(new Empleado("12431235T", "aaa", "kkk", 43));
		lEmps.add(new Empleado("23432466E", "Luc�a", "Vargas", 34));
		lEmps.add(new Empleado("12431235T", "Luis", "Tosar", 43));
		negocio.insertaEmpleados(lEmps);
	}
	
	private void listaDirecciones() {
		for (Direccion dir : negocio.getAllDirecciones()) {
			System.out.println(dir);
		}

	}
	
	private void testGetDirYEmps() {
		Direccion dir = (new ArrayList<Direccion>(negocio.getAllDirecciones())).get(0);
		System.out.println(dir);
		System.out.println(dir.getLEmpleados());
	}
	
	private void testInsertaEmpYDir() {
		Empleado emp = new Empleado("32452435U", "Elvira", "Lindo", 53);
		emp.setDireccion(new Direccion("Manuel Alfaro", 66666));
		negocio.insertaEmpleado(emp);
	}
	
	private void testGetEventoSala() {
		Sala sala = negocio.getSala("SLPIT");
		System.out.println("Sala y eventos asociados");
		System.out.println("------------------------");
		System.out.println(sala);
		for (Evento evento : sala.getEventos()) {
			System.out.println(evento);
		}
		System.out.println();
		System.out.println("Evento y sala asociada");
		Evento evento = negocio.getEvento(1);
		System.out.println(evento);
		System.out.println(evento.getSala());
	}
	
	private void addSalaAEvento() {
		Sala sala = negocio.getSala("SLSOC");
		Evento evento = negocio.getEvento(3);
		sala.getEventos().add(evento);
		evento.setSala(sala);
	}
	
	private void testEliminaSala() {
		negocio.eliminaSala("SLPIT");
	}
}
