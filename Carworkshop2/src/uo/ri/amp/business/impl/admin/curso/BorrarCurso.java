package uo.ri.amp.business.impl.admin.curso;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.CursoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class BorrarCurso implements Command {

	private String codigo;
	
	
	
	public BorrarCurso(String codigo) {
		super();
		this.codigo = codigo;
	}



	public Object execute() throws BusinessException {
		
		Curso curso=CursoFinder.findByCodigo(codigo);
		Asserts.assertNotNull(curso);
		Asserts.assertCanBeRemoved(curso);
		
		for(ContenidoCurso cc: curso.getContenidos())
		{
			Jpa.getManager().remove(cc);
		}
		Jpa.getManager().remove(curso);
		return null;
	}

}
