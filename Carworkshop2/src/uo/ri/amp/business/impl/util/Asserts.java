package uo.ri.amp.business.impl.util;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.CursoFinder;

/**
 * Clase útil para comprobar integridad en la aplicación.
 * @author UO223936
 *
 */
public class Asserts {

	public static void assertNotNull(Mecanico m) throws BusinessException {
		if (m == null) {
			throw new BusinessException("No existe el mecánico");
		}
	}

	public static void assertNotNull(Curso c) throws BusinessException {
		if (c == null) {
			throw new BusinessException("No existe el curso");
		}
	}

	public static void assertNotNull(Asistencia a) throws BusinessException {
		if (a == null) {
			throw new BusinessException(
					"No existe la asistencia de ese mecánico al curso");
		}
	}
	
	
	public static void assertNotNull(Averia a) throws BusinessException
	{
		if(a==null)
		{
			throw new BusinessException("No existe esa avería");
		}
	}

	public static void existeCodigoCurso(Curso curso) throws BusinessException {
		if (CursoFinder.findByCodigo(curso.getCodigo()) != null) {
			throw new BusinessException(
					"El curso ya existía en la base de datos con ese código");
		}

	}

	public static void assertCanBeRemoved(Curso curso)
			throws BusinessException {

		if (curso.getAsistencias().size() != 0) {
			throw new BusinessException(
					"No se puede borrar el curso, hay mecánicos que asisten a él");
		}

	}

	public static void assertNotNull(Vehiculo v) throws BusinessException {
		
		if(v==null)
		{
			throw new BusinessException("No existe el vehículo");
		}
		
	}
}
