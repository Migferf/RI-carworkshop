package uo.ri.amp.persistence;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class AsistenciaFinder {

	
	public static Asistencia findByIds(Mecanico mecanico, Curso curso) throws BusinessException
	{
		try
		{
		return Jpa.getManager().createNamedQuery("Asistencia.findByIds", Asistencia.class)
				.setParameter("mecanico", mecanico).setParameter("curso",curso).getSingleResult();
		}catch(Exception e)
		{
			throw new BusinessException("No existe la asistencia del mecánico "
					+mecanico.getNombre()+" al curso "+curso.getCodigo());
		}
				
	}
}
