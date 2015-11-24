package uo.ri.amp.ui.foreman.action;

import static uo.ri.amp.ui.util.Lector.checkDate;
import static uo.ri.amp.ui.util.Lector.checkLong;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.CollectionsPrinter;

/**
 * Modifica los datos de una avería.
 * @author nunse
 *
 */
public class ModificarAveriaAction implements Action {

	@Override
	public void execute() throws Exception {

		try {
			//Vehiculo
			String matricula = Console
					.readString("Introduzca la matrícula del vehículo");

			Vehiculo vehiculo = ServicesFactory.getForemanService()
					.findVehiculoByMatricula(matricula);

			if (vehiculo == null) {
				throw new BusinessException(
						"No hay ningún vehículo con esa matrícula registrado");
			}
			System.out.println(vehiculo);
			System.out.println("Vehiculo encontrado en la base de datos");
			
			List<Averia> averias = ServicesFactory.getForemanService()
					.mostrarAveriasVehiculo(vehiculo);
			System.out.println(
					"Se muestran las averías existentes en el vehículo");

			CollectionsPrinter.listarAverias(averias);

			//Avería
			long averiaId = checkLong(Console.readString(
					"Introduzca el ID de las averías listadas anteriormente que quiera actualizar"));

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = null;
			if (fecha == null) {
				do {
					fecha = checkDate(
							Console.readString(
									"Introduzca la fecha de alta de la avería (dd/MM/yyyy)"),
							formatter);
				} while (fecha == null);
			}
			String descripcion = Console.readString(
					"Introduzca una breve descripción de la avería");

			//Realizar operación
			ServicesFactory.getForemanService()
					.modificarAveria(averiaId, descripcion, fecha);

			System.out.println("Avería actualizada");
		} catch (BusinessException e) {
			Printer.printBusinessException(e);
		} catch (Exception e) {
			Printer.printBusinessException(e);
		}

	}

}
