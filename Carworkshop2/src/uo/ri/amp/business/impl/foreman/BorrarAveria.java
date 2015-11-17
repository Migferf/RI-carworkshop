package uo.ri.amp.business.impl.foreman;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AveriaFinder;
import uo.ri.amp.persistence.VehiculoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class BorrarAveria implements Command {

	private long averiaId;
	
	public BorrarAveria(long averiaId) {
		
		this.averiaId=averiaId;
	}

	@Override
	public Object execute() throws BusinessException {
		
		Averia averia=AveriaFinder.findById(averiaId);
		
		Jpa.getManager().remove(averia);
		
		return null;
	}

}
