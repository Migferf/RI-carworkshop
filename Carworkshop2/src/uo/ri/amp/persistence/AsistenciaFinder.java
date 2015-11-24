package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Operaciones find de la base de datos para las asistencias.
 * @author UO223936
 *
 */
public class AsistenciaFinder {

	/**
	 * Devuelve la lista de asistencias de un curso.
	 * @param curso
	 * @return
	 */
	public static List<Asistencia> findByCurso(Curso curso) {
		List<Asistencia> as = Jpa.getManager()
				.createNamedQuery("Asistencia.findByCurso", Asistencia.class)
				.setParameter("curso", curso).getResultList();
		return !as.isEmpty() ? as : null;
	}

	/**
	 * Devuelve la asistencia de un mecánico a un curso.
	 * @param mecanico
	 * @param curso
	 * @return
	 * @throws BusinessException
	 */
	public static Asistencia findByIds(Mecanico mecanico, Curso curso)
			throws BusinessException {
		List<Asistencia> as = Jpa.getManager()
				.createNamedQuery("Asistencia.findByIds", Asistencia.class)
				.setParameter("mecanico", mecanico).setParameter("curso", curso)
				.getResultList();
		return (!as.isEmpty()) ? as.get(0) : null;

	}
}
