package uo.ri.amp.business.impl.admin.asistencia;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AsistenciaFinder;
import uo.ri.amp.persistence.CursoFinder;

public class ListarAsistenciasPorCurso implements Command {

	
	private String codigo;
	
	
	public ListarAsistenciasPorCurso(String codigo) {
		super();
		this.codigo = codigo;
	}


	public Object execute() throws BusinessException {
		
		Curso c= CursoFinder.findByCodigo(codigo);
		return AsistenciaFinder.findByCurso(c);
	}

}
