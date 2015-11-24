package uo.ri.amp.ui.foreman.action;

import static uo.ri.amp.ui.util.Lector.checkLong;

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
 * Borra una avería.
 * @author UO223936
 *
 */
public class BorrarAveriaAction implements Action{

	@Override
	public void execute() throws Exception {
		try
		{
		//Vehículo
		String matricula = Console.readString("Introduzca la matrícula del vehículo");

		Vehiculo vehiculo = ServicesFactory.getForemanService().findVehiculoByMatricula(matricula);

		if (vehiculo == null) {
			throw new BusinessException("No hay ningún vehículo con esa matrícula registrado");
		}
		System.out.println(vehiculo);
		
		List<Averia> averias=ServicesFactory.getForemanService().mostrarAveriasVehiculo(vehiculo);
		System.out.println("Se muestran las averías existentes en el vehículo");
		
		CollectionsPrinter.listarAverias(averias);
		
		//Avería
		long averiaId=checkLong(Console.readString("Introduzca un ID de las averías listadas anteriormente"));
		
		//Realizar operación
		ServicesFactory.getForemanService().borrarAveria(averiaId);
		
		System.out.println("Avería borrada correctamente");
		} catch(BusinessException e)
		{
			Printer.printBusinessException(e);
		}
		
	}
	

}
