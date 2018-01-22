package profe.empleados.model;

import java.io.Serializable;
import java.util.Set;

public class Empleado implements Serializable, Cloneable {

	private String cif;
	private String nombre;
	private String apellidos;
	private int edad;
	private Direccion direccion;
	private Regalo regalo;
	private Ordenador ordenador;
	
/*	@CollectionOfElements 
		@JoinTable(
			name="dir_email", joinColumns = @JoinColumn(name="cif") )
		@Column(name="dir_email")
	@ElementCollection
	   @CollectionTable(name="Nicknames", joinColumns=@JoinColumn(name="user_id"))
	   @Column(name="nickname")*/
    private Set<String> dirEmails;
	
	public Empleado() {}

	public Empleado(String cif, String nombre, String apellidos, int edad) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
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
		Empleado other = (Empleado) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Set<String> getDirEmails() {
		return dirEmails;
	}

	public void setDirEmails(Set<String> dirEmails) {
		this.dirEmails = dirEmails;
	}

	public Regalo getRegalo() {
		return regalo;
	}

	public void setRegalo(Regalo regalo) {
		this.regalo = regalo;
	}

	public Ordenador getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(Ordenador ordenador) {
		this.ordenador = ordenador;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	

}
