package uo.ri.amp.business;

import java.util.Date;
import java.util.List;

import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;

public interface AdminService {
	
	
	public void añadirCurso(Curso curso,List<Double> porcentajes) throws BusinessException;
	public List<Curso> listarCursos() throws BusinessException;
	public List<TipoVehiculo> listarTiposVehiculo() throws BusinessException;
	public List<Mecanico> listarMecanicosPorApellido(String apellidos) throws BusinessException;
	public void añadirAsistencia(long idMecanico, String codigo,
			Date fechaComienzo, Date fechaFin, double porcentaje,
			boolean apto) throws BusinessException;
	public void borrarAsistencia(long idMecanico, String codigo) throws BusinessException;
}
