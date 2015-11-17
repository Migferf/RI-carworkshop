package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Curso;
import uo.ri.amp.persistence.util.Jpa;

public class CursoFinder {
	
	public static List<Curso> findAll()
	{
		return Jpa.getManager()
				.createNamedQuery("Curso.findAll",Curso.class).getResultList();
	}
	
	public static Curso findByCodigo(long codigo)
	{
		return Jpa.getManager().
				createNamedQuery("Curso.findByCodigo",Curso.class)
				.setParameter("codigo", codigo).getSingleResult();
	}

}
