package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class MecanicoFinder {

	public static Mecanico findById(Long id) {
		return Jpa.getManager().find(Mecanico.class, id);
	}

	public static List<Mecanico> findAll() {
		return Jpa.getManager()
				.createNamedQuery("Mecanico.findAll", Mecanico.class)
				.getResultList();
	}
	
	public static List<Mecanico> findByApellidos(String apellidos) throws BusinessException
	{
		try
		{
		return Jpa.getManager()
				.createNamedQuery("Mecanico.findByApellidos", Mecanico.class)
				.setParameter("apellidos", "%"+apellidos+"%").getResultList();
		}catch(Exception e)
		{
			throw new BusinessException("No existen mecánicos con esos apellidos");
		}
	}

}
