package uo.ri.amp.business.impl.foreman;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AveriaFinder;
import uo.ri.amp.persistence.ExpertosFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class AsignarAveria implements Command {

	private long averiaId;
	private long mecanicoId;

	public AsignarAveria(long averiaId, long mecanicoId) {
		super();
		this.averiaId = averiaId;
		this.mecanicoId = mecanicoId;
	}

	@Override
	public Object execute() throws BusinessException {

		Mecanico m = MecanicoFinder.findById(mecanicoId);
		Averia a = AveriaFinder.findById(averiaId);

		if (!ExpertosFinder.expertosTipoVehiculo(a.getVehiculo().getTipo())
				.contains(m))
			throw new BusinessException(
					"No es un mecánico experto para esta avería");

		a.asignarMecanico(m);
		Jpa.getManager().merge(a);
		return null;
	}

}
