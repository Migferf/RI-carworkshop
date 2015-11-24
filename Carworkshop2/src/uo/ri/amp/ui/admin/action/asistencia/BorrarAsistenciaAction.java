package uo.ri.amp.ui.admin.action.asistencia;

import static uo.ri.amp.ui.util.Lector.NOT_VALID_INPUT;
import static uo.ri.amp.ui.util.Lector.checkLong;

import java.util.List;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.CollectionsPrinter;

/**
 * Borra una asistencia de la base de datos.
 * @author UO223936
 *
 */
public class BorrarAsistenciaAction implements Action {

	@Override
	public void execute() throws Exception {
	
		try
		{
		//Pedir mecánico
		String apellidos=Console.readString("Introduzca los apellidos"
				+ " del mecánico al que quiera borrar la asistencia "
				+ "(puede ser solo un apellido)");
		
		List<Mecanico> mecanicos=ServicesFactory.getAdminService()
				.listarMecanicosPorApellido(apellidos);
		
		System.out.println("A continuación se muestran los mecánicos "
				+ "que se corresponden con esa búsqueda:");
		
		CollectionsPrinter.listarMecanicos(mecanicos);
		
		long idMecanico=NOT_VALID_INPUT;
		do {
			idMecanico=checkLong(Console.readString("Introduzca el identificador (ID)"
					+ " del que quiera borrar la asistencia"));
		} while (idMecanico==NOT_VALID_INPUT);
		
		//Pedir curso
		String codigo=Console.readString("Introduzca el código del curso cuya asistencia desee borrar");
		
		//Realizar operación
		ServicesFactory.getAdminService().borrarAsistencia(idMecanico, codigo);
		
		System.out.println("Asistencia eliminada correctamente");
		}catch(BusinessException e)
		{
			Printer.printBusinessException(e);
		}

	}

}
