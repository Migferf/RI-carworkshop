package uo.ri.amp.model.types;

import java.io.Serializable;

public class ExpertoKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	long mecanico;
	long tipoVehiculo;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (mecanico ^ (mecanico >>> 32));
		result = prime * result + (int) (tipoVehiculo ^ (tipoVehiculo >>> 32));
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
		ExpertoKey other = (ExpertoKey) obj;
		if (mecanico != other.mecanico)
			return false;
		if (tipoVehiculo != other.tipoVehiculo)
			return false;
		return true;
	}
	
	

}
