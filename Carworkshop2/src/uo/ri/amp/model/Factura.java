package uo.ri.amp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import alb.util.date.DateUtil;
import alb.util.math.Round;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.model.types.AveriaStatus;
import uo.ri.amp.model.types.FacturaStatus;

@Entity
@Table(name = "TFacturas")
public class Factura {

	@Id
	@GeneratedValue
	private long id;

	private Long numero;

	@Temporal(TemporalType.DATE)
	private Date fecha = new Date();
	private double importe;
	private double iva = 0.21;

	@Enumerated(EnumType.STRING)
	private FacturaStatus status = FacturaStatus.SIN_ABONAR;

	@OneToMany(mappedBy = "factura")
	private Set<Cargo> cargos = new HashSet<Cargo>();

	@OneToMany(mappedBy = "factura")
	private Set<Averia> asignadas = new HashSet<Averia>();

	Factura() {
	}

	public Factura(Long numero) {
		this.numero = numero;
	}

	public Factura(Long numero, Date fecha) {
		this.numero = numero;
		this.fecha = fecha;
	}

	public Factura(Long numero, List<Averia> averias) throws BusinessException {
		for (Averia a : averias)
			if (!a.getStatus().toString()
					.equals(AveriaStatus.TERMINADA.toString()))
				throw new BusinessException(
						"La avería no está terminada, no se puede facturar");
			else
				a.setStatus(AveriaStatus.FACTURADA);

		asignadas = new HashSet<Averia>(averias);
		this.numero = numero;
	}

	public Factura(Long numero, Date fecha, List<Averia> averias)
			throws BusinessException {
		this(numero, averias);
		this.iva = fecha.before(DateUtil.fromString("1/7/2012")) ? 0.18 : 0.21;
		this.fecha = fecha;
	}

	public double getImporte() {
		double importe = 0.0;
		for (Averia a : asignadas) {
			a.calcularImporte();
			importe += a.getImporte();
		}
		importe += importe * this.iva;
		return Round.twoCents(importe);
	}

	public Set<Cargo> getCargos() {
		return new HashSet<Cargo>(cargos);
	}

	public Set<Averia> getAsignadas() {
		return new HashSet<Averia>(asignadas);
	}

	Set<Cargo> _getCargos() {
		return cargos;
	}

	public Set<Averia> _getAsignadas() {
		return asignadas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public FacturaStatus getStatus() {
		return status;
	}

	public void setStatus(FacturaStatus status) {
		this.status = status;
	}

	public Long getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", importe="
				+ importe + ", iva=" + iva + ", status=" + status + ", cargos="
				+ cargos + ", averiras=" + asignadas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Factura other = (Factura) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public void addAveria(Averia averia) throws BusinessException {
		if (!averia.getStatus().toString()
				.equals(AveriaStatus.TERMINADA.toString()))
			throw new BusinessException(
					"La avería no está terminada, no se puede facturar");
		averia.setStatus(AveriaStatus.FACTURADA);
		Association.Facturar.link(this, averia);
	}

	public void removeAveria(Averia averia) {
		Association.Facturar.unlink(this, averia);
	}

	public Object getId() {
		return this.id;
	}
}
