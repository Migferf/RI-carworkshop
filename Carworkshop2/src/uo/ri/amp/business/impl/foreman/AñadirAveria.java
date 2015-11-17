package uo.ri.amp.business.impl.foreman;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class AñadirAveria implements Command {

	
	private Averia averia;
	
	public AñadirAveria(Averia averia) {
		this.averia=averia;
	}

	@Override
	public Object execute() throws BusinessException {
		
		
		Jpa.getManager().persist(averia);
		return null;
	}

}
