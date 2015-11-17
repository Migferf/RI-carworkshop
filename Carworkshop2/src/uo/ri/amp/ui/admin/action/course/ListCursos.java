package uo.ri.amp.ui.admin.action.course;

import java.util.List;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.exception.BusinessException;


public class ListCursos implements Action{
	
	@Override
	public void execute()
	{
	List<Curso> cursos;
	try {
		cursos = ServicesFactory.getAdminService().listarCursos();
		
		for(Curso c: cursos)
		{
			System.out.println("Curso:"+c.getCodigo()+"\t"+c.getDescripcion());
		}
	} catch (BusinessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

}
