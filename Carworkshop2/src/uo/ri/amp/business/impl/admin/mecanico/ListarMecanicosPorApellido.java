package uo.ri.amp.business.impl.admin.mecanico;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.MecanicoFinder;

public class ListarMecanicosPorApellido implements Command {

	
	private String apellidos;
	
	
	
	public ListarMecanicosPorApellido(String apellidos) {
		super();
		this.apellidos = apellidos;
	}



	@Override
	public Object execute() throws BusinessException {
		
		return MecanicoFinder.findByApellidos(apellidos);
	}

}
