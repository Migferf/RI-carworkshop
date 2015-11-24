package uo.ri.amp.business.impl.admin.listados;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ListadosFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.TipoVehiculoFinder;

public class ListarHorasTipoMecanico implements Command {

	private long idMecanico;
	
	
	
	public ListarHorasTipoMecanico(long idMecanico) {
		super();
		this.idMecanico = idMecanico;
	}



	public Object execute() throws BusinessException {
		
		Map<TipoVehiculo, Double> horasTipos=new HashMap<TipoVehiculo, Double>();
		List<TipoVehiculo> tipos=TipoVehiculoFinder.findAll();
		Mecanico m=MecanicoFinder.findById(idMecanico);
		Asserts.assertNotNull(m);
		
		for(TipoVehiculo tipo:tipos)
		{
			Double horas=ListadosFinder.listarHorasTipoMecanico(m, tipo);
			horasTipos.put(tipo, horas);
		}
		return horasTipos;
	}

}
