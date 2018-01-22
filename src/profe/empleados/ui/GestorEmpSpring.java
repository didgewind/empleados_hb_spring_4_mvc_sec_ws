package profe.empleados.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import profe.empleados.model.Empleado;
import profe.empleados.negocio.EmpleadosNegocio;
import profe.empleados.util.HibernateUtil;

public class GestorEmpSpring {

	private EmpleadosNegocio negocio;
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "beans.xml" });
		GestorEmpSpring gestor = (GestorEmpSpring) context.getBean("gestor");
		System.out.println("Contenedor inicializado");
		context.registerShutdownHook();
		gestor.go();
		System.out.println("Fin de la app");
	}
	
	public void go() {
		listaEmpleados();
	}
	
	public void testInsertaEmpleados() {
		List<Empleado> lEmps = new ArrayList<>();
		lEmps.add(new Empleado("12431235T", "aaa", "kkk", 43));
		lEmps.add(new Empleado("23432466E", "Lucía", "Vargas", 34));
		lEmps.add(new Empleado("12431235T", "Luis", "Tosar", 43));
		negocio.insertaEmpleados(lEmps);
	}
	
	
	public void goNoIntegrado() {
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
	
	}

	@Resource
	public void setNegocio(EmpleadosNegocio negocio) {
		this.negocio = negocio;
	}

	public void listaEmpleados() {
		for (Empleado emp : negocio.getAllEmpleados()) {
			System.out.println(emp);
		}
	}
	
	@Transactional
	public void testGetEmpleado() {
		Empleado emp = negocio.getEmpleado("01293474E");
		System.out.println(emp);
		System.out.println(emp.getDireccion());
		System.out.println("Regalo: " + emp.getRegalo());
		System.out.println(emp.getDireccion());
		System.out.println(emp.getOrdenador());
		System.out.println(emp.getOrdenador().getEmpleado());
	}

}
