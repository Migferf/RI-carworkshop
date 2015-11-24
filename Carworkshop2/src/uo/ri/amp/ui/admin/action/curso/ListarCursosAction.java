package uo.ri.amp.ui.admin.action.curso;

import java.util.List;

import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.CollectionsPrinter;

/**
 * Lista los cursos.
 * @author UO223936
 *
 */
public class ListarCursosAction implements Action{
	
	@Override
	public void execute()
	{
	List<Curso> cursos;
	try {
		cursos = ServicesFactory.getAdminService().listarCursos();
		CollectionsPrinter.listarCursos(cursos);
		
	} catch (BusinessException e) {
		Printer.printBusinessException(e);
	}
	
	
	}

}
