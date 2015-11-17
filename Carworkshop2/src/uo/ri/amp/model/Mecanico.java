package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TMecanicos")
public class Mecanico {

	@Id
	@GeneratedValue
	private long id;

	private String dni;
	private String apellidos;
	private String nombre;

	@OneToMany(mappedBy = "mecanico")
	private Set<Averia> asignadas = new HashSet<Averia>();
	@OneToMany(mappedBy = "mecanico")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();
	@OneToMany(mappedBy= "mecanico")
	private Set<Asistencia> asistencias=new HashSet<Asistencia>();
	@OneToMany(mappedBy="mecanico")
	private Set<Experto> expertos=new HashSet<Experto>();

	public Mecanico(String dni) {
		super();
		this.dni = dni;
	}

	Mecanico() {}

	public Mecanico(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombre = nombre;
	}

	Set<Averia> _getAsignadas() {
		return asignadas;
	}

	public Set<Averia> getAsignadas() {
		return new HashSet<Averia>(asignadas);
	}

	Set<Intervencion> _getIntervenciones() {
		return intervenciones;
	}

	public Set<Intervencion> getIntervenciones() {
		return new HashSet<Intervencion>(intervenciones);
	}
	
	Set<Asistencia> _getAsistencias() {
		return asistencias;
	}

	public Set<Asistencia> getAsistencias() {
		return new HashSet<Asistencia>(asistencias);
	}
	
	

	Set<Experto> _getExpertos() {
		return expertos;
	}
	
	public Set<Experto> getExpertos() {
		return new HashSet<Experto>(expertos);
	}

	@Override
	public String toString() {
		return "Mecanico [dni=" + dni + ", apellidos=" + apellidos
				+ ", nombre=" + nombre + ", averias=" + asignadas
				+ ", intervenciones=" + intervenciones + "]";
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Mecanico other = (Mecanico) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public Object getId() {
		return this.id;
	}
}
