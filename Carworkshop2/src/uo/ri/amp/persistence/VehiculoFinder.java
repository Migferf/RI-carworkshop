package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Operaciones find de los vehículos.
 * @author UO223936
 *
 */
public class VehiculoFinder {

	/**
	 * Devuelve <b>todos</b> los vehículso de la base de datos.
	 * @return
	 */
	public static List<Vehiculo> findAll()
	{
		return Jpa.getManager()
				.createNamedQuery("Vehiculo.findAll",Vehiculo.class).getResultList();
	}
	
	/**
	 * Devuelve el matrículo asociado a la matrícula.
	 * @param matricula
	 * @return
	 */
	public static Vehiculo findByMatricula(String matricula)
	{
		List<Vehiculo> v= Jpa.getManager()
				.createNamedQuery("Vehiculo.findByMatricula",Vehiculo.class)
				.setParameter("matricula", matricula).getResultList();
		return !v.isEmpty()?v.get(0):null;
	}
	
}
