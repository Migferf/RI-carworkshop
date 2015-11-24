package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Operaciones find para los tipos de vehículo
 * @author UO223936
 *
 */
public class TipoVehiculoFinder {
	
	/**
	 * Devuelve <b>todos</b> los tipos de vehículo de la base de datos.
	 * @return
	 */
	public static List<TipoVehiculo> findAll()
	{
		return Jpa.getManager()
				.createNamedQuery("TipoVehiculo.findAll", TipoVehiculo.class)
				.getResultList();
	}

}
