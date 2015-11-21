package uo.ri.amp.ui.foreman.action;

import static uo.ri.amp.ui.util.Lector.checkDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;

public class AñadirAveriaAction implements Action {

	@Override
	public void execute() throws Exception {

		String matricula = Console.readString("Introduzca la matrícula del vehículo");

		Vehiculo vehiculo = ServicesFactory.getForemanService().findVehiculoByMatricula(matricula);

		if (vehiculo == null) {
			throw new BusinessException("No hay ningún vehículo con esa matrícula registrado");
		}
		System.out.println(vehiculo);
		System.out.println("Vehiculo encontrado en la base de datos, continue con los datos de la avería");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		if (fecha == null) {
			do {
				fecha = checkDate(Console.readString("Introduzca la fecha de alta de la avería (dd/MM/yyyy)"),
						formatter);
			} while (fecha == null);
		}
		String descripcion=Console.readString("Introduzca una breve descripción de la avería");
		
		ServicesFactory.getForemanService().añadirAveria(new Averia(vehiculo,fecha,descripcion));
		
		System.out.println("Avería registrada");

	}

}
