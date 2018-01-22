package profe.empleados.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="direcciones")
public class Direccion implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String calle;
	private int cp;
	@OneToMany(mappedBy="direccion")
	private List<Empleado> lEmpleados;
	
	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direccion(String calle, int cp) {
		super();
		this.calle = calle;
		this.cp = cp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}



	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", cp=" + cp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public List<Empleado> getLEmpleados() {
		return lEmpleados;
	}

	public void setLEmpleados(List<Empleado> lEmpleados) {
		this.lEmpleados = lEmpleados;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
	
	
}
