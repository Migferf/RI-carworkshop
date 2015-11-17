package uo.ri.amp.business.impl;

import java.util.List;

import uo.ri.amp.business.ForemanService;
import uo.ri.amp.business.impl.foreman.AñadirAveria;
import uo.ri.amp.business.impl.foreman.BorrarAveria;
import uo.ri.amp.business.impl.foreman.FindVehiculoByMatricula;
import uo.ri.amp.business.impl.foreman.MostrarAveriasVehiculo;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;

public class ForemanServiceImpl implements ForemanService{
	
	private CommandExecutor ce=new CommandExecutor();
	
	@Override
	public void añadirAveria(Averia averia) throws BusinessException {
		ce.execute(new AñadirAveria(averia));

	}
	
	@Override
	public void borrarAveria(long averiaId) throws BusinessException {
		ce.execute(new BorrarAveria(averiaId));
		
	}
	
	
	@Override
	public Vehiculo findVehiculoByMatricula(String matricula) throws BusinessException {
		
		return (Vehiculo) ce.execute(new FindVehiculoByMatricula(matricula));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Averia> mostrarAveriasVehiculo(Vehiculo vehiculo) throws BusinessException {
		return (List<Averia>) ce.execute(new MostrarAveriasVehiculo(vehiculo));
		
	}

	

	

}
