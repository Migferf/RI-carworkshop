package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.persistence.util.Jpa;

public class TipoVehiculoFinder {
	
	public static List<TipoVehiculo> findAll()
	{
		return Jpa.getManager()
				.createNamedQuery("TipoVehiculo.findAll", TipoVehiculo.class)
				.getResultList();
	}

}
