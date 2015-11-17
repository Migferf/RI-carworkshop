package uo.ri.amp.business.impl;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.admin.curso.ListarCursos;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.exception.BusinessException;

public class AdminServiceImpl implements AdminService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarCursos() throws BusinessException {
		
		CommandExecutor ce=new CommandExecutor();
		
		return (List<Curso>) ce.execute(new ListarCursos());
	}

	

}
