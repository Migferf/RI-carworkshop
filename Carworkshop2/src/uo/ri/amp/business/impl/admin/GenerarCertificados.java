package uo.ri.amp.business.impl.admin;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Experto;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.ExpertosFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.TipoVehiculoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class GenerarCertificados implements Command {

	@Override
	public Object execute() throws BusinessException {
		
		List<Mecanico> mecanicos=MecanicoFinder.findAll();
		
		List<TipoVehiculo> tipos=TipoVehiculoFinder.findAll();
		
		for(TipoVehiculo t: tipos)
		{
			for(Mecanico m: mecanicos)
			{
				Double horas=ExpertosFinder.saberExperto(m, t);
				if(horas==null)horas=new Double(0);
				if(horas>=t.getHorasExperto())
				{
					if(ExpertosFinder.findExpertoByIds(m, t)==null)
					{
						Experto e= new Experto(m, t);
					
						Jpa.getManager().persist(e);
					}
				}
			}
		}
		
		return null;
	}

}
