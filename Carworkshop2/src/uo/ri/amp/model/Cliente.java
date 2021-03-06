package uo.ri.amp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.model.types.Address;

@Entity
@Table(name = "TClientes")
public class Cliente {

	@Id
	@GeneratedValue
	private long id;

	private String nombre;
	private String apellidos;
	private String dni;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "cliente")
	private Set<MedioPago> mediosPago = new HashSet<MedioPago>();
	@OneToMany(mappedBy = "cliente")
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();

	public Cliente(String dni) {
		this.dni = dni;
	}

	Cliente() {
	}

	public Cliente(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Set<MedioPago> getMediosPago() {
		return new HashSet<MedioPago>(mediosPago);
	}

	public Set<Vehiculo> getVehiculos() {
		return new HashSet<Vehiculo>(vehiculos);
	}

	Set<MedioPago> _getMediosPago() {
		return mediosPago;
	}

	Set<Vehiculo> _getVehiculos() {
		return vehiculos;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dni=" + dni + ", address=" + address + ", mediosPago="
				+ mediosPago + ", vehiculos=" + vehiculos + "]";
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
		Cliente other = (Cliente) obj;
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
