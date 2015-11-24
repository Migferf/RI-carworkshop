package uo.ri.amp.business.impl;

import java.util.Date;
import java.util.List;

import uo.ri.amp.business.ForemanService;
import uo.ri.amp.business.impl.foreman.AsignarAveria;
import uo.ri.amp.business.impl.foreman.AñadirAveria;
import uo.ri.amp.business.impl.foreman.BorrarAveria;
import uo.ri.amp.business.impl.foreman.FindVehiculoByMatricula;
import uo.ri.amp.business.impl.foreman.ListarMecanicosExpertos;
import uo.ri.amp.business.impl.foreman.ModificarAveria;
import uo.ri.amp.business.impl.foreman.MostrarAveriasVehiculo;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;

public class ForemanServiceImpl implements ForemanService {

	private CommandExecutor ce = new CommandExecutor();

	@Override
	public void añadirAveria(Averia averia) throws BusinessException {
		ce.execute(new AñadirAveria(averia));

	}

	@Override
	public void borrarAveria(long averiaId) throws BusinessException {
		ce.execute(new BorrarAveria(averiaId));

	}

	@Override
	public Vehiculo findVehiculoByMatricula(String matricula)
			throws BusinessException {

		return (Vehiculo) ce.execute(new FindVehiculoByMatricula(matricula));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Averia> mostrarAveriasVehiculo(Vehiculo vehiculo)
			throws BusinessException {
		return (List<Averia>) ce.execute(new MostrarAveriasVehiculo(vehiculo));

	}

	@Override
	public void modificarAveria(long averiaId, String descripcion, Date fecha)
			throws BusinessException {
		ce.execute(new ModificarAveria(averiaId, descripcion, fecha));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mecanico> listarMecanicosExpertos(long averiaId)
			throws BusinessException {

		return (List<Mecanico>) ce
				.execute(new ListarMecanicosExpertos(averiaId));
	}

	@Override
	public void asignarAveria(long averiaId, long idMecanico) throws BusinessException {
		
		ce.execute(new AsignarAveria(averiaId, idMecanico));
		
	}

}
