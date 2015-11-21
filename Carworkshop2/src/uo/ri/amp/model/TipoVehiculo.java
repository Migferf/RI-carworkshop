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
@Table(name = "TTiposVehiculo")
public class TipoVehiculo {

	@Id
	@GeneratedValue
	private long id;

	private String nombre;
	private double precioHora;
	
	@Column(name = "Horas_Experto")
	private int horasExperto;

	@OneToMany(mappedBy = "tipoVehiculo")
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
	
	@OneToMany(mappedBy="tipoVehiculo")
	private Set<ContenidoCurso> contenidos=new HashSet<ContenidoCurso>();
	
	@OneToMany(mappedBy="tipoVehiculo")
	private Set<Experto> expertos=new HashSet<Experto>();
	
	public TipoVehiculo(String nombre, double precioHora, int horasExperto) {
		super();
		this.nombre = nombre;
		this.precioHora = precioHora;
		this.horasExperto=horasExperto;
	}

	TipoVehiculo() {
	}

	public TipoVehiculo(String nombre) {
		super();
		this.nombre = nombre;
	}

	
	Set<Vehiculo> _getVehiculos() {
		return this.vehiculos;
	}

	public Set<Vehiculo> getVehiculos() {
		return new HashSet<Vehiculo>(vehiculos);
	}
	
	Set<ContenidoCurso> _getContenidos() {
		return contenidos;
	}

	
	public Set<ContenidoCurso> getContenidos() {
		return new HashSet<ContenidoCurso>(contenidos);
	}
		

	Set<Experto> _getExpertos() {
		return expertos;
	}
	
	public Set<Experto> getExpertos() {
		return new HashSet<Experto>(expertos);
	}

	public double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}

	public String getNombre() {
		return nombre;
	}
	
		
	public int getHorasExperto() {
		return horasExperto;
	}

	public void setHorasExperto(int horasExperto) {
		this.horasExperto = horasExperto;
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
		TipoVehiculo other = (TipoVehiculo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoVehiculo [nombre=" + nombre + ", precioHora=" + precioHora
				+ ", horasExperto=" + horasExperto + ", vehiculos=" + vehiculos
				+ "]";
	}
	
	

}
