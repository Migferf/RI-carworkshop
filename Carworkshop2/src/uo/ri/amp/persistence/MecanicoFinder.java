package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Operaciones find para los mecánicos.
 * @author UO223936
 *
 */
public class MecanicoFinder {

	/**
	 * Devuelve el mecánico asociado al id.
	 * @param id
	 * @return
	 */
	public static Mecanico findById(Long id) {
		return Jpa.getManager().find(Mecanico.class, id);
	}

	/**
	 * Devuelve <b>todos</b> los mecánicos de la base de datos.
	 * @return
	 */
	public static List<Mecanico> findAll() {
		List<Mecanico> m = Jpa.getManager()
				.createNamedQuery("Mecanico.findAll", Mecanico.class)
				.getResultList();
		return !m.isEmpty() ? m : null;
	}

	/**
	 * Una lista de mecánicos que se correspondan con los apellidos proporcionados.
	 * Téngase presente que esta operación permite mostrar resultados en los que esté incluída la solución.
	 * <br><br>
	 * <i>Ejemplo: </i>
	 * <code> apellidos='Fer' devolvería a Pedro Fernández Constantino</code>
	 * @param apellidos
	 * @return
	 * @throws BusinessException
	 */
	public static List<Mecanico> findByApellidos(String apellidos)
			throws BusinessException {
		List<Mecanico> m = Jpa.getManager()
				.createNamedQuery("Mecanico.findByApellidos", Mecanico.class)
				.setParameter("apellidos", "%" + apellidos + "%")
				.getResultList();
		return !m.isEmpty() ? m : null;

	}

}
