package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "TVEHICULOS")
@Entity
public class Vehiculo {

	@Id
	@GeneratedValue
	private long id;

	private String marca;
	private String matricula;
	private String modelo;

	@Column(name = "NUM_AVERIAS")
	private int numAverias = 0;

	@OneToMany(mappedBy = "vehiculo")
	private Set<Averia> averias = new HashSet<Averia>();

	@JoinColumn(name = "TIPO_ID")
	@ManyToOne
	private TipoVehiculo tipoVehiculo;

	@ManyToOne
	private Cliente cliente;

	public Vehiculo(String matricula) {
		super();
		this.matricula = matricula;
	}

	public Vehiculo(String matricula, String marca, String modelo) {
		this.marca = marca;
		this.matricula = matricula;
		this.modelo = modelo;
	}

	Vehiculo() {
	}

	Set<Averia> _getAverias() {
		return averias;
	}

	public Set<Averia> getAverias() {
		return new HashSet<Averia>(averias);
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", matricula=" + matricula
				+ ", modelo=" + modelo + ", numAverias=" + numAverias + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumAverias() {
		return numAverias;
	}

	public void setNumAverias(int numAverias) {
		this.numAverias = numAverias;
	}

	public TipoVehiculo getTipo() {
		return tipoVehiculo;
	}

	void _setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	void _setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void removeAveria(Averia averia) {
		Association.Averiar.unlink(averia, this);
	}

	public long getId() {
		return this.id;
	}

}
