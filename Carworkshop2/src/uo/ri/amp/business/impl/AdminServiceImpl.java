package uo.ri.amp.business.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.admin.GenerarCertificados;
import uo.ri.amp.business.impl.admin.ListarTiposVehiculo;
import uo.ri.amp.business.impl.admin.asistencia.AñadirAsistencia;
import uo.ri.amp.business.impl.admin.asistencia.BorrarAsistencia;
import uo.ri.amp.business.impl.admin.asistencia.ListarAsistenciasPorCurso;
import uo.ri.amp.business.impl.admin.asistencia.ModificarAsistencia;
import uo.ri.amp.business.impl.admin.curso.AñadirCurso;
import uo.ri.amp.business.impl.admin.curso.BorrarCurso;
import uo.ri.amp.business.impl.admin.curso.ListarCursos;
import uo.ri.amp.business.impl.admin.curso.ModificarCurso;
import uo.ri.amp.business.impl.admin.listados.ListarHorasMecanico;
import uo.ri.amp.business.impl.admin.listados.ListarHorasTipoMecanico;
import uo.ri.amp.business.impl.admin.listados.ListarMecanicosHorasTipo;
import uo.ri.amp.business.impl.admin.mecanico.ListarMecanicosPorApellido;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;

public class AdminServiceImpl implements AdminService {

	private CommandExecutor ce = new CommandExecutor();

	@Override
	public void añadirCurso(Curso curso, List<Double> porcentajes)
			throws BusinessException {

		ce.execute(new AñadirCurso(curso, porcentajes));

	}

	@Override
	public void borrarCurso(String codigo) throws BusinessException {
		ce.execute(new BorrarCurso(codigo));

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
	public List<Mecanico> listarMecanicosPorApellido(String apellidos)
			throws BusinessException {

		return (List<Mecanico>) ce
				.execute(new ListarMecanicosPorApellido(apellidos));
	}

	@Override
	public void añadirAsistencia(long idMecanico, String codigo,
			Date fechaComienzo, Date fechaFin, double porcentaje, boolean apto)
					throws BusinessException {

		ce.execute(new AñadirAsistencia(idMecanico, codigo, fechaComienzo,
				fechaFin, porcentaje, apto));

	}

	@Override
	public void borrarAsistencia(long idMecanico, String codigo)
			throws BusinessException {

		ce.execute(new BorrarAsistencia(idMecanico, codigo));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asistencia> listarAsistenciasPorCurso(String codigo)
			throws BusinessException {

		return (List<Asistencia>) ce
				.execute(new ListarAsistenciasPorCurso(codigo));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Double> listarHorasMecanico(long idMecanico)
			throws BusinessException {

		return (List<Double>) ce.execute(new ListarHorasMecanico(idMecanico));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<TipoVehiculo, Double> listarHorasTipoMecanico(long idMecanico)
			throws BusinessException {

		return (Map<TipoVehiculo, Double>) ce
				.execute(new ListarHorasTipoMecanico(idMecanico));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<TipoVehiculo, List<Map<Mecanico, Double>>>> listarMecanicosHorasTipo()
			throws BusinessException {

		return (List<Map<TipoVehiculo, List<Map<Mecanico, Double>>>>) ce
				.execute(new ListarMecanicosHorasTipo());

	}

	@Override
	public void modificarAsisencia(long idMecanico, String codigo,
			Date fechaComienzo, Date fechaFin, double porcentaje, boolean apto)
					throws BusinessException {
		ce.execute(new ModificarAsistencia(idMecanico, codigo, fechaComienzo,
				fechaFin, porcentaje, apto));

	}

	@Override
	public void generarCertificados() throws BusinessException {

		ce.execute(new GenerarCertificados());

	}

	@Override
	public void modificarCurso(String codigo, String nombre, String descripcion,
			int horasTotales, List<Double> porcentajes)
					throws BusinessException {

		ce.execute(new ModificarCurso(codigo, nombre, descripcion, horasTotales, porcentajes));

	}

}
