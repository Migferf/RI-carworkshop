package uo.ri.amp.persistence;

import java.util.ArrayList;
import java.util.List;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Operaciones find que devuelven listados con información de utilidad.
 * @author UO223936
 *
 */
public class ListadosFinder {

	/**
	 * Devuelve las horas totales de un mecánico en todos sus cursos, y el total
	 * de horas asistidas de las anteriores.
	 * @param m
	 * @return
	 */
	public static List<Object> listarHorasMecanico(Mecanico m) {

		List<Object> horas = new ArrayList<Object>();
		horas.add(Jpa.getManager()
				.createNamedQuery("ListarHoras.Mecanico", Long.class)
				.setParameter("mecanico", m).getSingleResult());
		horas.add(Jpa.getManager()
				.createNamedQuery("ListarHoras.AsistidasMecanico", Double.class)
				.setParameter("mecanico", m).getSingleResult());

		return !horas.isEmpty() ? horas : null;

	}

	/**
	 * Devuelve el total de horas que un mecánico ha cursado sobre un tipo de vehículo.
	 * @param m
	 * @param tipo
	 * @return
	 */
	public static Double listarHorasTipoMecanico(Mecanico m,
			TipoVehiculo tipo) {
		List<Double> hora = Jpa.getManager()
				.createNamedQuery("ListarHoras.TipoMecanico", Double.class)
				.setParameter("mecanico", m).setParameter("tipoVehiculo", tipo)
				.getResultList();
		return !hora.isEmpty()?hora.get(0):null;
	}

}
