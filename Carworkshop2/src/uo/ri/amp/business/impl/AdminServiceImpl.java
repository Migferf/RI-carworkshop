package uo.ri.amp.business.impl;

import java.util.Date;
import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.admin.ListarTiposVehiculo;
import uo.ri.amp.business.impl.admin.asistencia.AñadirAsistencia;
import uo.ri.amp.business.impl.admin.asistencia.BorrarAsistencia;
import uo.ri.amp.business.impl.admin.curso.AñadirCurso;
import uo.ri.amp.business.impl.admin.curso.ListarCursos;
import uo.ri.amp.business.impl.admin.mecanico.ListarMecanicosPorApellido;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;

public class AdminServiceImpl implements AdminService {

	private CommandExecutor ce = new CommandExecutor();

	
	@Override
	public void añadirCurso(Curso curso, List<Double> porcentajes)throws BusinessException {
		
		ce.execute(new AñadirCurso(curso,porcentajes));
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarCursos() throws BusinessException {
		return (List<Curso>) ce.execute(new ListarCursos());
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoVehiculo> listarTiposVehiculo() throws BusinessException {
		return (List<TipoVehiculo>) ce.execute(new ListarTiposVehiculo());
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Mecanico> listarMecanicosPorApellido(String apellidos) throws BusinessException {
		
		return (List<Mecanico>) ce.execute(new ListarMecanicosPorApellido(apellidos));
	}
	@Override
	public void añadirAsistencia(long idMecanico, String codigo, Date fechaComienzo, 
			Date fechaFin, double porcentaje,boolean apto) throws BusinessException {
		
		ce.execute(new AñadirAsistencia(idMecanico, codigo, fechaComienzo, fechaFin,
				porcentaje, apto));
		
	}
	@Override
	public void borrarAsistencia(long idMecanico, String codigo) throws BusinessException {

		ce.execute(new BorrarAsistencia(idMecanico,codigo));
		
	}



	

}
