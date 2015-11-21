package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TCURSO")
public class Curso {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String codigo;
	private String nombre;
	private String descripcion;
	@Column(name = "Horas_Totales")
	private int horasTotales;
	
	@OneToMany(mappedBy="curso")
	private Set<Asistencia> asistencias=new HashSet<Asistencia>();
	
	@OneToMany(mappedBy="curso")
	private Set<ContenidoCurso> contenidos=new HashSet<ContenidoCurso>();

	Curso(){}
	
	
	

	public Curso(String codigo, String nombre, String descripcion, int horasTotales) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horasTotales = horasTotales;				
	}




	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(int horasTotales) {
		this.horasTotales = horasTotales;
	}

	public long getId() {
		return id;
	}

	
	
	Set<Asistencia> _getAsistencias() {
		return asistencias;
	}

	Set<ContenidoCurso> _getContenidos() {
		return contenidos;
	}
	
	public Set<Asistencia> getAsistencias() {
		return new HashSet<Asistencia>(asistencias);
	}

	public Set<ContenidoCurso> getContenidos() {
		return new HashSet<ContenidoCurso>(contenidos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", horasTotales="
				+ horasTotales + "]";
	}
	
	

	
	

}
