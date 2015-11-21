package uo.ri.amp.business.impl.util;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.CursoFinder;

public class Asserts {

	public static void assertNotNull(Mecanico m) throws BusinessException
	{
		if(m==null)
		{
			throw new BusinessException("No existe el mecánico");
		}
	}
	
	public static void assertNotNull(Curso c) throws BusinessException
	{
		if(c==null)
		{
			throw new BusinessException("No existe el curso");
		}
	}
	
	public static void assertNotNull(Asistencia a) throws BusinessException
	{
		if(a==null)
		{
			throw new BusinessException("No existe la asistencia de ese mecánico al curso");
		}
	}
	public static void existeCodigoCurso(Curso curso) throws BusinessException
	{
		try {
			CursoFinder.findByCodigo(curso.getCodigo());
			
		} catch (BusinessException e) {
			return;
		}
		throw new BusinessException("El código del curso ya existía");
		
	}
}
