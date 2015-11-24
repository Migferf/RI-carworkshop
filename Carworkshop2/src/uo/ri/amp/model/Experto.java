package uo.ri.amp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.amp.model.types.ExpertoKey;

@Entity
@IdClass(ExpertoKey.class)
@Table(name="TEXPERTO")
public class Experto {
	
	@Id
	@ManyToOne
	private Mecanico mecanico;
	
	@Id
	@ManyToOne
	private TipoVehiculo tipoVehiculo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha_Certificado")
	private Date fechaCertificado;

	Experto(){}
	
	public Experto(Mecanico mecanico, TipoVehiculo tipoVehiculo) {
		super();
		Association.ExpertoEn.link(this, mecanico, tipoVehiculo);
		fechaCertificado=new Date();
		
	}

	public Date getFechaCertificado() {
		return fechaCertificado;
	}

	public void setFechaCertificado(Date fechaCertificado) {
		this.fechaCertificado = fechaCertificado;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}
	
	void _setMecanico(Mecanico mecanico)
	{
		this.mecanico=mecanico;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	void _setTipoVehiculo(TipoVehiculo tipoVehiculo)
	{
		this.tipoVehiculo=tipoVehiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Experto other = (Experto) obj;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
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
		return "Experto [mecanico=" + mecanico + ", tipoVehiculo="
				+ tipoVehiculo + ", fechaCertificado=" + fechaCertificado + "]";
	}
	
	
	

}
