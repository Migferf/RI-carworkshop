package uo.ri.amp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.amp.model.types.ContenidoCursoKey;

@Entity
@IdClass(ContenidoCursoKey.class)
@Table(name="TCONTENIDOCURSO")
public class ContenidoCurso {
	
	@Id
	@ManyToOne
	private Curso curso;
	
	@Id
	@ManyToOne
	private TipoVehiculo tipoVehiculo;
	
	@Column(name = "Porcentaje_Horas")
	private double porcentajeHoras;

	ContenidoCurso() {}
	
	public ContenidoCurso(Curso curso, TipoVehiculo tipoVehiculo, double porcentajeHoras) {
		super();
		this.porcentajeHoras=porcentajeHoras;
		Association.Contener.link(this, curso, tipoVehiculo);
		
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	void _setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Curso getCurso() {
		return curso;
	}
	
	void _setCurso(Curso curso)
	{
		this.curso=curso;
	}

	public double getPorcentajeHoras() {
		return porcentajeHoras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result
				+ ((tipoVehiculo == null) ? 0 : tipoVehiculo.hashCode());
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
		ContenidoCurso other = (ContenidoCurso) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (tipoVehiculo == null) {
			if (other.tipoVehiculo != null)
				return false;
		} else if (!tipoVehiculo.equals(other.tipoVehiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContenidoCurso [curso=" + curso + ", tipoVehiculo="
				+ tipoVehiculo + ", porcentajeHoras=" + porcentajeHoras + "]";
	}
	
	

	
	
	
	

}
