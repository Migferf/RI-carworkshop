package uo.ri.amp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.amp.model.types.AsistenciaKey;

@Entity
@IdClass(AsistenciaKey.class)
@Table(name="TASISTENCIA")
public class Asistencia {
	
	@Id
	@ManyToOne
	private Mecanico mecanico;
	
	@Id
	@ManyToOne
	private Curso curso;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	private double porcentajeAsistencia;
	private boolean apto;

	Asistencia(){}
	
	public Asistencia(Mecanico mecanico, Curso curso, Date fechaInicio, Date fechaFin,
			double porcentajeAsistencia,boolean apto) {
		super();
		this.fechaInicio=fechaFin;
		this.fechaFin=fechaFin;
		this.porcentajeAsistencia=porcentajeAsistencia;
		this.apto=apto;
		Association.Asistir.link(this, mecanico, curso);
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getPorcentajeAsistencia() {
		return porcentajeAsistencia;
	}

	public void setPorcentajeAsistencia(double porcentajeAsistencia) {
		this.porcentajeAsistencia = porcentajeAsistencia;
	}

	public Curso getCurso() {
		return curso;
	}
	
	void _setCurso(Curso curso)
	{
		this.curso=curso;
	}

	public boolean isApto() {
		return apto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result
				+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Asistencia other = (Asistencia) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asistencia [mecanico=" + mecanico + ", curso=" + curso
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", porcentajeAsistencia=" + porcentajeAsistencia + ", apto="
				+ apto + "]";
	}
	
	
	
	
	
	

}
