package uo.ri.amp.business.impl.foreman;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AveriaFinder;
import uo.ri.amp.persistence.ExpertosFinder;

public class ListarMecanicosExpertos implements Command {

	private long averiaId;
	
	
	
	public ListarMecanicosExpertos(long averiaId) {
		super();
		this.averiaId = averiaId;
	}



	@Override
	public Object execute() throws BusinessException {
		
		Averia a=AveriaFinder.findById(averiaId);
		Asserts.assertNotNull(a);
		
		return ExpertosFinder.expertosTipoVehiculo(a.getVehiculo().getTipo());
	}

}
