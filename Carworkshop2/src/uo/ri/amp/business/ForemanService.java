package uo.ri.amp.business;

import java.util.Date;
import java.util.List;

import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;

public interface ForemanService {

	/**
	 * Encuentra un vehículo por su matrícula.s
	 * @param matricula
	 * @return
	 * @throws BusinessException
	 */
	public Vehiculo findVehiculoByMatricula(String matricula)
			throws BusinessException;

	/**
	 * Añade una avería.
	 * @param averia
	 * @throws BusinessException
	 */
	public void añadirAveria(Averia averia) throws BusinessException;

	/**
	 * Borra una avería.
	 * @param averiaId
	 * @throws BusinessException
	 */
	public void borrarAveria(long averiaId) throws BusinessException;

	/**
	 * Muestra las averías que existan para el vehículo proporcionado.
	 * @param vehiculo
	 * @return
	 * @throws BusinessException
	 */
	public List<Averia> mostrarAveriasVehiculo(Vehiculo vehiculo)
			throws BusinessException;

	/**
	 * Modifica los datos de una avería.
	 * @param idAveria
	 * @param descripcion
	 * @param fecha
	 * @throws BusinessException
	 */
	public void modificarAveria(long idAveria, String descripcion, Date fecha)
			throws BusinessException;

	/**
	 * Lista los mecánicos expertos para el tipo de vehículo correspondiente a la avería.
	 * @param averiaId
	 * @return
	 * @throws BusinessException
	 */
	public List<Mecanico> listarMecanicosExpertos(long averiaId)
			throws BusinessException;

	/**
	 * Asigna una avería a un mecánico experto en ese tipo.
	 * @param averiaId
	 * @param idMecanico
	 * @throws BusinessException
	 */
	public void asignarAveria(long averiaId, long idMecanico) throws BusinessException;

}
