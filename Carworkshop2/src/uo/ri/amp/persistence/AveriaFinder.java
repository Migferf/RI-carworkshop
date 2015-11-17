package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Averia;
import uo.ri.amp.persistence.util.Jpa;

public class AveriaFinder {

	public static List<Averia> findByMatricula(List<Long> idsAveria) {

		return null;
	}

	public static List<Averia> findByVehiculoId(long vehiculoId) {

		return Jpa.getManager()
				.createNamedQuery("Averia.findByVehiculoId",Averia.class)
				.setParameter("vehiculo_id", vehiculoId).getResultList();
	}
	
	public static Averia findById(long id)
	{
		return Jpa.getManager()
				.createNamedQuery("Averia.findById",Averia.class)
				.setParameter("id", id).getSingleResult();
	}

}
