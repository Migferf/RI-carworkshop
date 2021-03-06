package uo.ri.amp.ui.admin.action.curso;

import static uo.ri.amp.ui.util.Lector.*;

import java.util.ArrayList;
import java.util.List;

import alb.util.console.Console;
import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;

/**
 * Añade un curso a la base de datos.
 * @author UO223936
 *
 */
public class AñadirCursoAction implements Action {

	@Override
	public void execute() {

		//Datos
		String codigo = Console.readString("Introduzca el código del curso");
		String nombre = Console.readString("Introduzca el nombre del curso");
		String descripcion = Console.readString("Introduzca una descripción del curso");

		int horasTotales = NOT_VALID_INPUT;
		do {
			horasTotales = checkInt(Console.readString("Introduzca el número de horas totales del curso"));
		} while (horasTotales == NOT_VALID_INPUT);

		//Contenido curso
		List<TipoVehiculo> tipos;
		try {
			tipos = ServicesFactory.getAdminService().listarTiposVehiculo();

			System.out.println("A continuación introduzca el porcentaje de horas destinadas a cada tipo de vehículo,"
					+ "recuerde que los porcentajes deben sumar 100%.\nActualmente existen " + tipos.size()
					+ " tipos.");

			List<Double> porcentajes;
			double porc = 0;
			do {
				porcentajes = new ArrayList<Double>();
				porc = 0;
				for (TipoVehiculo tp : tipos) {
					double cantidad =NOT_VALID_INPUT;
					do {
						cantidad = checkDouble(Console.readString(tp.getNombre()));
					} while (cantidad==NOT_VALID_INPUT);
					
					porc = cantidad + porc;
					porcentajes.add(cantidad);
				}
			} while (!checkPorcSum(porc));
			
			//Realizar operación
			ServicesFactory.getAdminService().añadirCurso(new Curso(codigo, nombre, descripcion, horasTotales),
					porcentajes);
			
			System.out.println("Curso añadido correctamente");

		} catch (BusinessException e) {
			Printer.printBusinessException(e);
		}
	}

}
