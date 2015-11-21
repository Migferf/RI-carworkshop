package uo.ri.amp.business.impl.admin;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.TipoVehiculoFinder;

public class ListarTiposVehiculo implements Command {

	@Override
	public Object execute() throws BusinessException {
		return TipoVehiculoFinder.findAll();
	}

}
