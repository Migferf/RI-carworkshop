package uo.ri.amp.model.types;

import java.io.Serializable;

public class ContenidoCursoKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	long curso;
	long tipoVehiculo;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (curso ^ (curso >>> 32));
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
		ContenidoCursoKey other = (ContenidoCursoKey) obj;
		if (curso != other.curso)
			return false;
		if (tipoVehiculo != other.tipoVehiculo)
			return false;
		return true;
	}
	
	
}
