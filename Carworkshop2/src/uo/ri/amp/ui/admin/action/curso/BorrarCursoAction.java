package uo.ri.amp.ui.admin.action.curso;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.exception.BusinessException;

/**
 * Borra un curso.
 * @author UO223936
 *
 */
public class BorrarCursoAction implements Action {

	@Override
	public void execute() throws Exception {
		try
		{
		//Codigo
		String codigo=Console.readString("Introduce el código del curso");
		
		//Realizar operación
		ServicesFactory.getAdminService().borrarCurso(codigo);
		
		System.out.println("Curso borrado correctamente");
		}catch(BusinessException e)
		{
			Printer.printBusinessException(e);
		}

	}

}
