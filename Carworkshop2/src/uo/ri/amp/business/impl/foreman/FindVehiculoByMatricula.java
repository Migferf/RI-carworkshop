package uo.ri.amp.business.impl.foreman;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.VehiculoFinder;

public class FindVehiculoByMatricula implements Command {

	private String matricula;
	
	
	
	public FindVehiculoByMatricula(String matricula) {
		super();
		this.matricula = matricula;
	}



	@Override
	public Object execute() throws BusinessException {
		
		Vehiculo v=VehiculoFinder.findByMatricula(matricula);
		Asserts.assertNotNull(v);
		return v;
	}

}
