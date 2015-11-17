package uo.ri.amp.model;

public class Association {

	public static class Poseer {

		public static void link(Cliente cliente, Vehiculo vehiculo) {
			vehiculo._setCliente(cliente);
			cliente._getVehiculos().add(vehiculo);
		}

		public static void unlink(Cliente cliente, Vehiculo vehiculo) {
			
			cliente._getVehiculos().remove(vehiculo);
			vehiculo._setCliente(null);
		}
	}

	public static class Clasificar {

		public static void link(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			vehiculo._setTipoVehiculo(tipoVehiculo);
			tipoVehiculo._getVehiculos().add(vehiculo);
		}

		public static void unlink(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			
			tipoVehiculo._getVehiculos().remove(vehiculo);
			vehiculo._setTipoVehiculo(null);
		}
	}

	public static class Pagar {

		public static void link(Cliente cliente, MedioPago medioPago) {
			medioPago._setCliente(cliente);
			cliente._getMediosPago().add(medioPago);
		}

		public static void unlink(Cliente cliente, MedioPago medioPago) {
	
			cliente._getMediosPago().remove(medioPago);
			medioPago._setCliente(null);
		}
	}

	/* package */static class Averiar {

		public static void link(Averia averia, Vehiculo vehiculo) {
			averia._setVehiculo(vehiculo);
			vehiculo.setNumAverias(vehiculo.getNumAverias() + 1);
			vehiculo._getAverias().add(averia);
		}

		public static void unlink(Averia averia, Vehiculo vehiculo) {

			
			vehiculo._getAverias().remove(averia);
			averia._setVehiculo(null);
			vehiculo.setNumAverias(vehiculo.getNumAverias() - 1);
			
		}
	}

	/* package */static class Facturar {

		public static void link(Factura factura, Averia averia) {
			averia._setFactura(factura);
			factura._getAsignadas().add(averia);
		}

		public static void unlink(Factura factura, Averia averia) {

			factura._getAsignadas().remove(averia);
			averia._setFactura(null);
			
		}
	}

	public static class Cargar {

		public static void link(MedioPago medioPago, Factura factura,
				Cargo cargo) {
			medioPago.setAcumulado(medioPago.getAcumulado()
					+ cargo.getImporte());
			cargo._setFactura(factura);
			cargo._setMedioPago(medioPago);
			factura._getCargos().add(cargo);
			medioPago._getCargos().add(cargo);
		}

		public static void unlink(Cargo cargo) {
			
			
			cargo.getFactura()._getCargos().remove(cargo);
			cargo.getMedioPago()._getCargos().remove(cargo);
			cargo.getMedioPago().setAcumulado(
					cargo.getMedioPago().getAcumulado() - cargo.getImporte());
			cargo._setFactura(null);
			cargo._setMedioPago(null);
			
		}
	}

	public static class Asignar {

		public static void link(Mecanico mecanico, Averia averia) {
			averia._setMecanico(mecanico);
			mecanico._getAsignadas().add(averia);
			
		}

		public static void unlink(Mecanico mecanico, Averia averia) {
			
			mecanico._getAsignadas().remove(averia);
			averia._setMecanico(null);
			
		}
	}

	public static class Intervenir {

		public static void link(Intervencion intervencion, Mecanico mecanico,
				Averia averia) {
			intervencion._setAveria(averia);
			intervencion._setMecanico(mecanico);
			averia._getIntervenciones().add(intervencion);
			mecanico._getIntervenciones().add(intervencion);
		}

		public static void unlink(Intervencion intervencion) {
			
			intervencion.getAveria()._getIntervenciones().remove(intervencion);
			intervencion.getMecanico()._getIntervenciones()
					.remove(intervencion);
			intervencion._setAveria(null);
			intervencion._setMecanico(null);
		}
	}

	public static class Sustituir {

		public static void link(Intervencion intervencion,
				Sustitucion sustitucion, Repuesto repuesto) {
			sustitucion._setIntervencion(intervencion);
			sustitucion._setRepuesto(repuesto);
			intervencion._getSustituciones().add(sustitucion);
			repuesto._getSustituciones().add(sustitucion);
		}

		public static void unlink(Sustitucion sustitucion) {
			
			sustitucion.getIntervencion()._getSustituciones()
					.remove(sustitucion);
			sustitucion.getRepuesto()._getSustituciones().remove(sustitucion);
			sustitucion._setIntervencion(null);
			sustitucion._setRepuesto(null);
		}
	}
	
	
	public static class Asistir{
		
		public static void link(Asistencia asistencia,Mecanico mecanico, Curso curso)
		{
			asistencia._setMecanico(mecanico);
			asistencia._setCurso(curso);
			
			curso._getAsistencias().add(asistencia);
			mecanico._getAsistencias().add(asistencia);
		}
	
		public static void unlink(Asistencia asistencia)
		{
			asistencia.getCurso()._getAsistencias().remove(asistencia);
			asistencia.getMecanico()._getAsistencias().remove(asistencia);
			
			asistencia._setCurso(null);
			asistencia._setMecanico(null);
		}
	}
	
	public static class Contener{
		
		public static void link(ContenidoCurso cc, Curso curso, TipoVehiculo tipo)
		{
			cc._setCurso(curso);
			cc._setTipoVehiculo(tipo);
			
			curso._getContenidos().add(cc);
			tipo._getContenidos().add(cc);
		}
		
		public static void unlink(ContenidoCurso cc)
		{
			cc.getCurso()._getContenidos().remove(cc);
			cc.getTipoVehiculo()._getContenidos().remove(cc);
			
			cc._setCurso(null);
			cc._setTipoVehiculo(null);
		}
	}
	
	public static class ExpertoEn{
		
		public static void link(Experto experto, Mecanico mecanico, TipoVehiculo tipo)
		{
			experto._setMecanico(mecanico);
			experto._setTipoVehiculo(tipo);
			
			mecanico._getExpertos().add(experto);
			tipo._getExpertos().add(experto);
		}
		
		public static void unlink(Experto experto)
		{
			experto.getMecanico()._getExpertos().remove(experto);
			experto.getTipoVehiculo()._getExpertos().remove(experto);
			
			experto._setMecanico(null);
			experto._setTipoVehiculo(null);
		}
	}

}
