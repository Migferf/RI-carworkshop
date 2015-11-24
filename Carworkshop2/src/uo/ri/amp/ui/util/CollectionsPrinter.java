package uo.ri.amp.ui.util;

import java.util.List;
import java.util.Map;

import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.TipoVehiculo;

/**
 * Clase útil para mostrar por pantalla todas las colecciones de objetos usadas.
 * 
 * @author UO223936
 * 
 *
 */
public class CollectionsPrinter {

	public static void listarMecanicos(List<Mecanico> mecanicos) {
		if (mecanicos == null) {
			System.out
					.println("No se encontraron mecánicos con esos apellidos");
			return;
		}
		for (Mecanico m : mecanicos) {
			System.out.println("ID: " + m.getId() + "\tDNI: " + m.getDni()
					+ "\tNombre: " + m.getNombre() + "\tApellidos: "
					+ m.getApellidos());
		}
	}

	public static void listarAverias(List<Averia> averias) {
		for (Averia a : averias) {
			System.out.println("Id: " + a.getId() + "\tFecha: " + a.getFecha()
					+ "\tImporte: " + a.getImporte() + "\tEstado: "
					+ a.getStatus() + "\tDescripcion: " + a.getDescripcion());
		}
	}

	public static void listarCursos(List<Curso> cursos) {
		if (cursos == null) {
			System.out.println("No se encontraron cursos");
		} else {
			for (Curso c : cursos) {
				System.out.println("\nCurso:" + c.getCodigo()
						+ "\tHoras totales: " + c.getHorasTotales()
						+ "\tNombre: " + c.getNombre() + "\tDescripción: "
						+ c.getDescripcion());
				for (ContenidoCurso cc : c.getContenidos()) {
					System.out.println("\t" + cc.getPorcentajeHoras() + "\t"
							+ cc.getTipoVehiculo().getNombre());
				}
			}
		}
	}

	public static void listarAsistenciasCurso(List<Asistencia> asistencias) {
		if (asistencias == null) {
			System.out.println("No se encontraron asistencias para ese curso");
		} else {
			for (Asistencia a : asistencias) {
				System.out.println("Nombre: " + a.getMecanico().getNombre()
						+ "\tFecha de finalización: " + a.getFechaFin()
						+ "\t% de asistencia: " + a.getPorcentajeAsistencia()
						+ "\tApto: " + (a.isApto() ? "Sí" : "No"));
			}
		}
	}

	public static void listarHorasMecanico(List<Double> horas) {
		if (horas.get(0) != null) {
			if (!horas.isEmpty()) {
				System.out.println("Total de horas cursadas: " + horas.get(0));
				System.out.println("Total de horas asistidas: " + horas.get(1));
			}
		} else {
			System.out.println("No tiene ninguna hora cursada");
		}
	}

	public static void listarHorasTiposMecanico(
			Map<TipoVehiculo, Double> horasTipo) {

		for (TipoVehiculo tipo : horasTipo.keySet()) {
			if (horasTipo.get(tipo) != null)
				System.out.println(
						"\t" + tipo.getNombre() + ": " + horasTipo.get(tipo));
		}

	}

	public static void listarTiposHorasMecanico(
			List<Map<TipoVehiculo, List<Map<Mecanico, Double>>>> coleccion) {

		for (Map<TipoVehiculo, List<Map<Mecanico, Double>>> horasTipo : coleccion) {

			for (TipoVehiculo tipo : horasTipo.keySet()) {

				System.out.println(tipo.getNombre() + ": ");

				for (Map<Mecanico, Double> horasMecanico : horasTipo
						.get(tipo)) {
					for (Mecanico m : horasMecanico.keySet()) {
						Object horas = horasMecanico.get(m) != null
								? horasMecanico.get(m) : "0.0";
						System.out.println("\t" + m.getNombre() + "\t" + horas);

					}

				}
			}

		}

	}

}
