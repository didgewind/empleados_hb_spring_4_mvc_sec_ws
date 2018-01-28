package profe.mvc.empleados.webconfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import profe.mvc.empleados.security.WebSecurityConfig;

public class MvcWebAI extends AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebSecurityConfig.class };
	}

    protected Class<?>[] getServletConfigClasses() {
		return new Class[] {EmpleadosWebConfigurator.class };
    }

	protected String[] getServletMappings() {
		return new String[] {"*.do"};
	}

}
