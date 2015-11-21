package uo.ri.amp.business.impl.admin.asistencia;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AsistenciaFinder;
import uo.ri.amp.persistence.CursoFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class BorrarAsistencia implements Command {

	private long idMecanico;
	private String codigo;
	
	
	
	public BorrarAsistencia(long idMecanico, String codigo) {
		super();
		this.idMecanico = idMecanico;
		this.codigo = codigo;
	}



	@Override
	public Object execute() throws BusinessException {
		
		Mecanico m=MecanicoFinder.findById(idMecanico);
		Asserts.assertNotNull(m);
		
		Curso c=CursoFinder.findByCodigo(codigo);
		Asserts.assertNotNull(c);
		
		Asistencia a=AsistenciaFinder.findByIds(m, c);
		Asserts.assertNotNull(a);
		
		Jpa.getManager().remove(a);
		
		return null;
	}
	
	

}
