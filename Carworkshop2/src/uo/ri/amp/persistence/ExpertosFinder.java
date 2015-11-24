package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.persistence.util.Jpa;

/**
 * Operaciones find para los mecánicos expertos.
 * 
 * @author UO223936
 *
 */
public class ExpertosFinder {

	/**
	 * Devuelve las horas de un mecánico que haya asistido en sus cursos. A
	 * tomar en cuenta las siguientes consideraciones:
	 * <ul>
	 * <li>Se toman horas <b>asistidas</b>, no totales</li>
	 * <li>Se aplica el porcentaje de horas que el curso imparte al vehículo
	 * </li>
	 * <li>Unicamente se aplica sobre cursos en los que el mecánico es
	 * considerado apto</li>
	 * </ul>
	 * 
	 * @param m
	 * @param t
	 * @return
	 */
	public static Double saberExperto(Mecanico m, TipoVehiculo t) {

		List<Double> horas = Jpa.getManager()
				.createNamedQuery("Expertos.horas", Double.class)
				.setParameter("mecanico", m).setParameter("tipoVehiculo", t)
				.getResultList();
		return !horas.isEmpty() ? horas.get(0) : null;
	}

	/**
	 * Devuelve todos los mecánicos que son considerados expertos en un tipo de
	 * vehículo.</br>
	 * </br>
	 * Es aconsejable realizar certificados de experto antes de invocar esta
	 * función, por motivos de fiabilidad.
	 * 
	 * @param tipo
	 * @return
	 */
	public static List<Mecanico> expertosTipoVehiculo(TipoVehiculo tipo) {
		List<Mecanico> mecanicos = Jpa.getManager()
				.createNamedQuery("Expertos.mecanicos", Mecanico.class)
				.setParameter("tipoVehiculo", tipo).getResultList();
		return !mecanicos.isEmpty() ? mecanicos : null;
	}

	/**
	 * Comprueba si el mecánico es experto en ese tipo de vehículo. Devuelve al propio mecánico.
	 * @param m
	 * @param tipo
	 * @return
	 */
	public static Mecanico findExpertoByIds(Mecanico m, TipoVehiculo tipo) {
		List<Mecanico> mecanicos = Jpa.getManager()
				.createNamedQuery("Expertos.findByIds", Mecanico.class)
				.setParameter("mecanico", m).setParameter("tipoVehiculo", tipo)
				.getResultList();
		return !mecanicos.isEmpty() ? mecanicos.get(0) : null;
	}

}
