package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Curso;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Operaciones find para los cursos.
 * @author UO223936
 *
 */
public class CursoFinder {

	/**
	 * Devuelve <b>todos</b> los cursos.
	 * @return
	 */
	public static List<Curso> findAll() {
		List<Curso> cus = Jpa.getManager()
				.createNamedQuery("Curso.findAll", Curso.class).getResultList();
		return !cus.isEmpty() ? cus : null;
	}

	/**
	 * Devuelve el curso que se corresponda con el código.
	 * @param codigo
	 * @return
	 * @throws BusinessException
	 */
	public static Curso findByCodigo(String codigo) throws BusinessException {

		List<Curso> c= Jpa.getManager()
				.createNamedQuery("Curso.findByCodigo", Curso.class)
				.setParameter("codigo", codigo).getResultList();
		return !c.isEmpty()?c.get(0):null;

	}

}
