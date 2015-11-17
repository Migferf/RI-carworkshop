package uo.ri.amp.model.types;

import java.io.Serializable;

public class IntervencionKey implements Serializable {
	private static final long serialVersionUID = 1L;

	long averia; // Tipo de clave artificial que hay en averia
	long mecanico; // "" ""

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (averia ^ (averia >>> 32));
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
		IntervencionKey other = (IntervencionKey) obj;
		if (averia != other.averia)
			return false;
		if (mecanico != other.mecanico)
			return false;
		return true;
	}

}
