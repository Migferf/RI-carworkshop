package uo.ri.amp.ui.foreman.action;

import static uo.ri.amp.ui.util.Lector.checkDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;

/**
 * Añade una avería.
 * @author UO223936
 *
 */
public class AñadirAveriaAction implements Action {

	@Override
	public void execute() throws Exception {

		try
		{
		//Vehículo
		String matricula = Console.readString("Introduzca la matrícula del vehículo");

		Vehiculo vehiculo = ServicesFactory.getForemanService().findVehiculoByMatricula(matricula);

		System.out.println(vehiculo);
		System.out.println("Vehiculo encontrado en la base de datos, continue con los datos de la avería");
		
		//Fecha
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		if (fecha == null) {
			do {
				fecha = checkDate(Console.readString("Introduzca la fecha de alta de la avería (dd/MM/yyyy)"),
						formatter);
			} while (fecha == null);
		}
		//Descripción
		String descripcion=Console.readString("Introduzca una breve descripción de la avería");
		
		//Realizar operación
		ServicesFactory.getForemanService().añadirAveria(new Averia(vehiculo,fecha,descripcion));
		
		System.out.println("Avería registrada");
		}catch(BusinessException e)
		{
			Printer.printBusinessException(e);
		}catch(Exception e)
		{
			Printer.printBusinessException(e);
		}
		

	}

}
