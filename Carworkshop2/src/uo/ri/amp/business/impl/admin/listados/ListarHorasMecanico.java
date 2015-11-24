package uo.ri.amp.business.impl.admin.listados;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ListadosFinder;
import uo.ri.amp.persistence.MecanicoFinder;

public class ListarHorasMecanico implements Command {

	
	private long idMecanico;
	
	public ListarHorasMecanico(long idMecanico)
	{
		this.idMecanico=idMecanico;
	}
	
	public Object execute() throws BusinessException {

		Mecanico m=MecanicoFinder.findById(idMecanico);
		Asserts.assertNotNull(m);
		return ListadosFinder.listarHorasMecanico(m);
	}

}
