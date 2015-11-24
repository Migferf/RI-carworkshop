package uo.ri.amp.ui.foreman.action;

import static uo.ri.amp.ui.util.Lector.NOT_VALID_INPUT;
import static uo.ri.amp.ui.util.Lector.checkLong;

import java.util.List;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.CollectionsPrinter;

/**
 * Asigna una avería a un mecánico
 * @author UO223936
 *
 */
public class AsignarAveriaMecanicoAction implements Action {

	@Override
	public void execute() throws Exception {

		try {
			//Vehículo
			String matricula = Console
					.readString("Introduzca la matrícula del vehículo");

			Vehiculo vehiculo = ServicesFactory.getForemanService()
					.findVehiculoByMatricula(matricula);

			System.out.println(vehiculo);

			List<Averia> averias = ServicesFactory.getForemanService()
					.mostrarAveriasVehiculo(vehiculo);
			System.out.println(
					"Se muestran las averías existentes en el vehículo");

			CollectionsPrinter.listarAverias(averias);
			
			//Avería
			long averiaId = NOT_VALID_INPUT;
			do {
				averiaId = checkLong(Console.readString(
						"Introduzca un ID de las averías listadas anteriormente"));
			} while (averiaId == NOT_VALID_INPUT);

			//Mecanicos asignables
			List<Mecanico> mecanicosCapaces = ServicesFactory
					.getForemanService().listarMecanicosExpertos(averiaId);

			System.out.println(
					"A continuación se muestran los mecánicos expertos en ese tipo de vehículo: ");
			CollectionsPrinter.listarMecanicos(mecanicosCapaces);

			long idMecanico = NOT_VALID_INPUT;
			do {
				idMecanico = checkLong(Console.readString(
						"Introduzca el identificador (ID) del mecánico que quiera asignar: "));
			} while (idMecanico == NOT_VALID_INPUT);

			//Realizar operación
			ServicesFactory.getForemanService().asignarAveria(averiaId,
					idMecanico);

			System.out.println("Averia asignada correctamente");
		} catch (BusinessException e) {

			Printer.printBusinessException(e);
		}
	}

}
