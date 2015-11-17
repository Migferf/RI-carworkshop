package uo.ri.amp.business;

import java.util.List;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;

public interface ForemanService {

	public Vehiculo findVehiculoByMatricula(String matricula) throws BusinessException;
	public void añadirAveria(Averia averia) throws BusinessException;
	public void borrarAveria(long averiaId)throws BusinessException;
	public List<Averia> mostrarAveriasVehiculo(Vehiculo vehiculo)throws BusinessException;
	

}
