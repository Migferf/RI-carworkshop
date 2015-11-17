package uo.ri.amp.model.types;

import java.io.Serializable;

public class AsistenciaKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	long mecanico;
	long curso;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (curso ^ (curso >>> 32));
		result = prime * result + (int) (mecanico ^ (mecanico >>> 32));
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
		AsistenciaKey other = (AsistenciaKey) obj;
		if (curso != other.curso)
			return false;
		if (mecanico != other.mecanico)
			return false;
		return true;
	}
	
	
	

}
