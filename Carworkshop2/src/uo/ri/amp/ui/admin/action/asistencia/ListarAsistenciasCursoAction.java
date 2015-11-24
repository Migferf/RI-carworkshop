package uo.ri.amp.ui.admin.action.asistencia;

import java.util.List;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.CollectionsPrinter;

/**
 * Lista las asistencias de un curso.
 * @author UO223936
 *
 */
public class ListarAsistenciasCursoAction implements Action {

	public void execute() throws Exception {
		try
		{
		//Pedir curso
		String codigo = Console.readString("Introduzca el código del curso");

		//Realizar operación
		List<Asistencia> asistencias = ServicesFactory.getAdminService()
				.listarAsistenciasPorCurso(codigo);
		CollectionsPrinter.listarAsistenciasCurso(asistencias);
		}catch(BusinessException e)
		{
			Printer.printBusinessException(e);
		}

	}

}
