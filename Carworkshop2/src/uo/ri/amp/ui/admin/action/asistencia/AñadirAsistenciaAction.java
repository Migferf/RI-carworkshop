package uo.ri.amp.ui.admin.action.asistencia;

import static uo.ri.amp.ui.util.Lector.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.ui.util.CollectionsPrinter;

public class AñadirAsistenciaAction implements Action{

	@Override
	public void execute() throws Exception {
	
		
		String apellidos=Console.readString("Introduzca los apellidos"
				+ " del mecánico al que quiera añadir la asistencia "
				+ "(puede ser solo un apellido)");
		
		List<Mecanico> mecanicos=ServicesFactory.getAdminService()
				.listarMecanicosPorApellido(apellidos);
		
		System.out.println("A continuación se muestran los mecánicos "
				+ "que se corresponden con esa búsqueda:");
		
		CollectionsPrinter.listarMecanicos(mecanicos);
		
		long idMecanico=NOT_VALID_INPUT;
		do {
			idMecanico=checkLong(Console.readString("Introduzca el identificador (ID)"
					+ " del que quiera añadir asistencia"));
		} while (idMecanico==NOT_VALID_INPUT);
		
		String codigo=Console.readString("Introduzca el código del curso al que quiera que asista");
		
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaComienzo=null;
		do {
			fechaComienzo= checkDate(Console.readString("Introduzca la fecha de comienzo (dd/MM/yyyy)")
					, formatter);
		} while (fechaComienzo==null);
		
		Date fechaFin=null;
		do {
			fechaFin= checkDate(Console.readString("Introduzca la fecha de finalizacion (dd/MM/yyyy)")
					, formatter);
		} while (fechaFin==null);
		
		
		double porcentaje=NOT_VALID_INPUT;
		
		do {
			porcentaje=checkPorc(Console.readString("Introduzca el porcentaje de asistencia"));
		} while (porcentaje==NOT_VALID_INPUT);
		
		boolean apto=checkBool(Console.readString("¿Ha sido apto en el curso? (S/N)"));
		
		ServicesFactory.getAdminService().añadirAsistencia(idMecanico,codigo,
				fechaComienzo, fechaFin, porcentaje, apto);
		
		System.out.println("Asistencia añadida correctamente");
	}
	
	

}
