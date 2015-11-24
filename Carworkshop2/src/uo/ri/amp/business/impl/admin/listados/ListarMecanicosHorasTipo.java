package uo.ri.amp.business.impl.admin.listados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ListadosFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.TipoVehiculoFinder;

public class ListarMecanicosHorasTipo implements Command {

	@Override
	public Object execute() throws BusinessException {

		List<Map<TipoVehiculo, List<Map<Mecanico, Double>>>> horas = new ArrayList<Map<TipoVehiculo, List<Map<Mecanico, Double>>>>();
		List<TipoVehiculo> tipos = TipoVehiculoFinder.findAll();

		List<Mecanico> mecanicos = MecanicoFinder.findAll();

		for (TipoVehiculo tipo : tipos) {

			Map<TipoVehiculo, List<Map<Mecanico, Double>>> horasTipo = new HashMap<>();
			List<Map<Mecanico, Double>> listaHorasMecanico = new ArrayList<>();

			for (Mecanico m : mecanicos) {

				Map<Mecanico, Double> horasMecanico = new HashMap<Mecanico, Double>();
				horasMecanico.put(m,
						ListadosFinder.listarHorasTipoMecanico(m, tipo));
				listaHorasMecanico.add(horasMecanico);
			}

			horasTipo.put(tipo, listaHorasMecanico);
			horas.add(horasTipo);
		}
		return horas;
	}

}
