package uo.ri.amp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import alb.util.math.Round;
import uo.ri.amp.model.types.AveriaStatus;

@Entity
@Table(name = "TAverias")
public class Averia {

	@Id
	@GeneratedValue
	private long id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;
	private double importe = 0.0;

	@Enumerated(EnumType.STRING)
	private AveriaStatus status = AveriaStatus.ABIERTA;

	@ManyToOne
	private Vehiculo vehiculo;

	@ManyToOne
	private Mecanico mecanico;

	@ManyToOne
	private Factura factura;

	@OneToMany(mappedBy = "averia")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();

	public Averia(Vehiculo vehiculo,Date fecha, String descripcion) {
		super();
		this.fecha = fecha;
		this.vehiculo = vehiculo;
		this.descripcion=descripcion;
		status=AveriaStatus.ABIERTA;
		Association.Averiar.link(this, vehiculo);
	}
	Averia() {
	}

	public Set<Intervencion> getIntervenciones() {
		return new HashSet<Intervencion>(intervenciones);
	}

	Set<Intervencion> _getIntervenciones() {
		return intervenciones;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	void _setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Mecanico getMecanico() {
		return this.mecanico;
	}

	public void asignarMecanico(Mecanico m)
	{
		Association.Asignar.link(m,this);
	}
	
	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public Factura getFactura() {
		return this.factura;
	}

	void _setFactura(Factura factura) {
		this.factura = factura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public AveriaStatus getStatus() {
		return status;
	}

	public void setStatus(AveriaStatus status) {
		this.status = status;
	}

	public void setIntervenciones(Set<Intervencion> intervenciones) {
		this.intervenciones = intervenciones;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha)
	{
		this.fecha=fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result
				+ ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		Averia other = (Averia) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Averia [descripcion=" + descripcion + ", fecha=" + fecha
				+ ", importe=" + importe + ", status=" + status + ", vehiculo="
				+ vehiculo + ", mecanico=" + mecanico + ", factura=" + factura
				+ ", intervenciones=" + intervenciones + "]";
	}

	public void calcularImporte() {
		double suma = 0.0;
		for (Intervencion i : this.intervenciones) {
			suma += ((double) i.getMinutos() / 60)
					* this.vehiculo.getTipo().getPrecioHora();
			for (Sustitucion s : i._getSustituciones())
				suma += s.getCantidad() * s.getRepuesto().getPrecio();
		}
		this.importe = Round.twoCents(suma);
	}

	public long getId() {
		return this.id;
	}

}
