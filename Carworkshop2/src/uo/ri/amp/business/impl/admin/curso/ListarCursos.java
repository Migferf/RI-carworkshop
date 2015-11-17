package uo.ri.amp.business.impl.admin.curso;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.persistence.CursoFinder;

public class ListarCursos implements Command{
	
	@Override
	public Object execute()
	{
		return CursoFinder.findAll();
	}

}
