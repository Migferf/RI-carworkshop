package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.util.Jpa;

public class VehiculoFinder {

	public static List<Vehiculo> findAll()
	{
		return Jpa.getManager()
				.createNamedQuery("Vehiculo.findAll",Vehiculo.class).getResultList();
	}
	
	public static Vehiculo findByMatricula(String matricula)
	{
		return Jpa.getManager()
				.createNamedQuery("Vehiculo.findByMatricula",Vehiculo.class)
				.setParameter("matricula", matricula).getSingleResult();
	}
	
}
