package uo.ri.amp.ui.admin.action.curso;

import java.util.List;

import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.exception.BusinessException;


public class ListarCursos implements Action{
	
	@Override
	public void execute()
	{
	List<Curso> cursos;
	try {
		cursos = ServicesFactory.getAdminService().listarCursos();
		listarCursos(cursos);
		
	} catch (BusinessException e) {
		Printer.printBusinessException(e);
		e.printStackTrace();
	}
	
	
	}
	
	private void listarCursos(List<Curso> cursos)
	{
		for(Curso c: cursos)
		{
			System.out.println("Curso:"+c.getCodigo()
				+"\tHoras totales: "+c.getHorasTotales()
				+"\tNombre: "+c.getNombre()+"\tDescripción: "+c.getDescripcion());
		}
	}

}
