package profe.empleados.model;

import java.io.Serializable;
import java.util.Set;

public class Sala implements Serializable {

	private String id;
	private String nombre;
	private int capacidad;
	private Set<Evento> eventos;

	public Sala() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sala(String id, String nombre, int capacidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "id=" + id + " - nombre=" + nombre + " - capacidad="
				+ capacidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Sala other = (Sala) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}
	
}
