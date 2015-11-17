package uo.ri.amp.business;

import java.util.List;

import uo.ri.amp.model.Curso;
import uo.ri.amp.model.exception.BusinessException;

public interface AdminService {
	
	public List<Curso> listarCursos() throws BusinessException;
}
