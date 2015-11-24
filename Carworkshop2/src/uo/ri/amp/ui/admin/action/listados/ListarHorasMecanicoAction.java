package uo.ri.amp.ui.admin.action.listados;

import static uo.ri.amp.ui.util.Lector.checkLong;

import java.util.List;
import java.util.Map;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.CollectionsPrinter;

/**
 * Lista las horas de los cursos de un mecánico.
 * @author nunse
 *
 */
public class ListarHorasMecanicoAction implements Action {

	public void execute() throws Exception {

		try
		{
		//Mecanico
		String apellidos = Console.readString(
				"Introduzca los apellidos del mecánico (puede ser sólo uno)");

		List<Mecanico> mecanicos = ServicesFactory.getAdminService()
				.listarMecanicosPorApellido(apellidos);
		
		CollectionsPrinter.listarMecanicos(mecanicos);
		
		long idMecanico = checkLong(Console
				.readString("Introduzca el identificador (ID) del mecánico"));
		//Realizar operación
		List<Double> horas = ServicesFactory.getAdminService()
				.listarHorasMecanico(idMecanico);
		
		CollectionsPrinter.listarHorasMecanico(horas);
		
		//Realizar operación
		Map<TipoVehiculo, Double> horasTipo = ServicesFactory.getAdminService()
				.listarHorasTipoMecanico(idMecanico);
		
		CollectionsPrinter.listarHorasTiposMecanico(horasTipo);
		}catch(BusinessException e)
		{
			Printer.printBusinessException(e);
		}

	}

}
