package uo.ri.amp.model.types;

import java.io.Serializable;

public class SustitucionKey implements Serializable {

	private static final long serialVersionUID = 1L;

	long repuesto;
	IntervencionKey intervencion;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((intervencion == null) ? 0 : intervencion.hashCode());
		result = prime * result + (int) (repuesto ^ (repuesto >>> 32));
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
		SustitucionKey other = (SustitucionKey) obj;
		if (intervencion == null) {
			if (other.intervencion != null)
				return false;
		} else if (!intervencion.equals(other.intervencion))
			return false;
		if (repuesto != other.repuesto)
			return false;
		return true;
	}

}