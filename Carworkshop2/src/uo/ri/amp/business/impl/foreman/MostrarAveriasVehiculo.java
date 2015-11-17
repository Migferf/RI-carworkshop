package uo.ri.amp.business.impl.foreman;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AveriaFinder;

public class MostrarAveriasVehiculo implements Command {

	private Vehiculo vehiculo;
	
	
	
	public MostrarAveriasVehiculo(Vehiculo vehiculo) {
		super();
		this.vehiculo = vehiculo;
	}


	@Override
	public Object execute() throws BusinessException {
		
		
		return AveriaFinder.findByVehiculoId(vehiculo.getId());
	}

}
