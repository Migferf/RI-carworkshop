package uo.ri.amp.ui.foreman.action;

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
 * Lista las averías de un vehículo.
 * @author UO223936
 *
 */
public class ListarAveriasVehiculoAction implements Action {

	@Override
	public void execute() throws Exception {

		try
		{
		
		//Vehiculo
		String matricula = Console.readString("Introduzca la matrícula del vehículo");

		Vehiculo vehiculo = ServicesFactory.getForemanService().findVehiculoByMatricula(matricula);

		if (vehiculo == null) {
			throw new BusinessException("No hay ningún vehículo con esa matrícula registrado");
		}
		System.out.println(vehiculo);

		//Realizar operación
		List<Averia> averias = ServicesFactory.getForemanService().mostrarAveriasVehiculo(vehiculo);
		System.out.println("Se muestran las averías existentes en el vehículo");
		
		CollectionsPrinter.listarAverias(averias);
		}catch(BusinessException e)
		{
			Printer.printBusinessException(e);
		}catch(Exception e)
		{
			Printer.printBusinessException(e);
		}

	}

	

}
