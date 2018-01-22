package profe.empleados.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(* profe.empleados.negocio.*.*(..))")
	public void allNegocioMethods() {}
	
	@Pointcut("execution(* profe.empleados.negocio.*.getAllEmpleados())")
	public void getEmpleadosMethod() {}
	
	@Pointcut("execution(* profe.empleados.ui.GestorEmpSpring.listaEmpleados())")
	public void listaEmpleadosMethod() {}
	
	@Before("allNegocioMethods()")
	public void logBefore(JoinPoint jp) {
		System.out.println("Antes de ejecutar el método " + jp.getSignature() +
				"del objeto " + jp.getTarget());
	}
	
	@Before("listaEmpleadosMethod()")
	public void bfListaEmpleados(JoinPoint jp) {
		System.out.println("Voy a listar los empleados");
	}
	
/*	@Around("getEmpleadosMethod()")
	public Object logAround(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Advice Around kicking in");
		Set<Empleado> empleados = (Set<Empleado>) jp.proceed();
		empleados.add(new Empleado("asdfasdf$", "aa", "bb", 32));
		return empleados;
	}*/

}
