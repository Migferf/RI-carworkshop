package uo.ri.amp.ui.admin.action.listados;

import java.util.List;
import java.util.Map;

import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.ui.util.CollectionsPrinter;

/**
 * Lista las horas de todos los mecánicos de un tipo de vehículo.
 * @author UO223936
 *
 */
public class ListarHorasTipoVehiculoAction implements Action {

	public void execute() throws Exception {

		try
		{
		List<Map<TipoVehiculo, List<Map<Mecanico, Double>>>> coleccion = ServicesFactory
				.getAdminService().listarMecanicosHorasTipo();
		
		CollectionsPrinter.listarTiposHorasMecanico(coleccion);
		}catch(BusinessException e)
		{
			Printer.printBusinessException(e);
		}

	}

}
