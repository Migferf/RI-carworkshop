package uo.ri.amp.business.impl.admin.curso;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.CursoFinder;

public class ListarCursos implements Command{
	
	@Override
	public Object execute()throws BusinessException
	{
		try{
		return CursoFinder.findAll();
		}catch(Exception e)
		{
			throw new BusinessException("Error al intentar recuperar los tipos de vehículo");
		}
	}

}
