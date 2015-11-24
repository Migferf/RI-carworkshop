package uo.ri.amp.business;

import java.util.Date;
import java.util.List;
import java.util.Map;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;

public interface AdminService {

	/**
	 * Añade un curso.
	 * @param curso
	 * @param porcentajes
	 * @throws BusinessException
	 */
	public void añadirCurso(Curso curso, List<Double> porcentajes)
			throws BusinessException;

	/**
	 * Modifica los datos de un curso.
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 * @param horasTotales
	 * @param porcentajes
	 * @throws BusinessException
	 */
	public void modificarCurso(String codigo, String nombre, String descripcion,
			int horasTotales, List<Double> porcentajes)
					throws BusinessException;
	/**
	 * Lista <b>todos</b> los cursos.
	 * @return
	 * @throws BusinessException
	 */
	public List<Curso> listarCursos() throws BusinessException;

	/**
	 * Borra un curso.
	 * @param codigo
	 * @throws BusinessException
	 */
	public void borrarCurso(String codigo) throws BusinessException;

	/**
	 * Lista los tipos de vehículo.
	 * @return
	 * @throws BusinessException
	 */
	public List<TipoVehiculo> listarTiposVehiculo() throws BusinessException;

	/**
	 * Lista los mecánicos que se correspondan con los apellidos o los incluyan.
	 * @param apellidos
	 * @return
	 * @throws BusinessException
	 */
	public List<Mecanico> listarMecanicosPorApellido(String apellidos)
			throws BusinessException;

	/**
	 * Añade una asistencia.
	 * @param idMecanico
	 * @param codigo
	 * @param fechaComienzo
	 * @param fechaFin
	 * @param porcentaje
	 * @param apto
	 * @throws BusinessException
	 */
	public void añadirAsistencia(long idMecanico, String codigo,
			Date fechaComienzo, Date fechaFin, double porcentaje, boolean apto)
					throws BusinessException;

	/**
	 * Borra una asistencia.
	 * @param idMecanico
	 * @param codigo
	 * @throws BusinessException
	 */
	public void borrarAsistencia(long idMecanico, String codigo)
			throws BusinessException;

	/**
	 * Lista las asistencias de los mecánicos a un curso.
	 * @param codigo
	 * @return
	 * @throws BusinessException
	 */
	public List<Asistencia> listarAsistenciasPorCurso(String codigo)
			throws BusinessException;

	/**
	 * Devuelve las horas totales recibidas por un mecánico en todos sus cursos, y las asistidas de dichos.
	 * @param idMecanico
	 * @return
	 * @throws BusinessException
	 */
	public List<Double> listarHorasMecanico(long idMecanico)
			throws BusinessException;

	/**
	 * Devuelve las horas totales de cada tipo de vehículo para un mecánico.
	 * @param idMecanico
	 * @return
	 * @throws BusinessException
	 */
	public Map<TipoVehiculo, Double> listarHorasTipoMecanico(long idMecanico)
			throws BusinessException;

	/**
	 * Devuelve una lista con los tipos de vehículo, y cada mecánico con sus horas asistidas a cada uno.
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<TipoVehiculo, List<Map<Mecanico, Double>>>> listarMecanicosHorasTipo()
			throws BusinessException;

	/**
	 * Modifica los datos de una asistencia.
	 * @param idMecanico
	 * @param codigo
	 * @param fechaComienzo
	 * @param fechaFin
	 * @param porcentaje
	 * @param apto
	 * @throws BusinessException
	 */
	public void modificarAsisencia(long idMecanico, String codigo,
			Date fechaComienzo, Date fechaFin, double porcentaje, boolean apto)
					throws BusinessException;

	/**
	 * Genera los certificados de experto para los mecánicos que lo merezcan.
	 * @throws BusinessException
	 */
	public void generarCertificados() throws BusinessException;

	
}
