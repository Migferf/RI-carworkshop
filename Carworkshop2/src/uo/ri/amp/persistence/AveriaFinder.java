package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Averia;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Operaciones find para las averías en la base de datos.
 * @author UO223936
 *
 */
public class AveriaFinder {

	/**
	 * Devuelve todas las averías de un coche identificado por su matrícula
	 * @param idsAveria
	 * @return
	 */
	public static List<Averia> findByMatricula(List<Long> idsAveria) {

		return null;
	}

	/**
	 * Devuelve todas las averías de un coche identificado por su id de base de datos.
	 * @param vehiculoId
	 * @return
	 */
	public static List<Averia> findByVehiculoId(long vehiculoId) {

		List<Averia> av = Jpa.getManager()
				.createNamedQuery("Averia.findByVehiculoId", Averia.class)
				.setParameter("vehiculo_id", vehiculoId).getResultList();
		return !av.isEmpty() ? av : null;
	}

	/**
	 * Devuelve la avería que corresponda con su identificador.
	 * @param id
	 * @return
	 */
	public static Averia findById(long id) {
		List<Averia> av= Jpa.getManager()
				.createNamedQuery("Averia.findById", Averia.class)
				.setParameter("id", id).getResultList();
		return !av.isEmpty()?av.get(0):null;
	}

}
