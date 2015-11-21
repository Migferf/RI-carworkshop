package uo.ri.amp.ui.foreman.action;

import java.util.List;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import uo.ri.amp.model.exception.BusinessException;

public class ListarAveriasVehiculoAction implements Action {

	@Override
	public void execute() throws Exception {

		String matricula = Console.readString("Introduzca la matrícula del vehículo");

		Vehiculo vehiculo = ServicesFactory.getForemanService().findVehiculoByMatricula(matricula);

		if (vehiculo == null) {
			throw new BusinessException("No hay ningún vehículo con esa matrícula registrado");
		}
		System.out.println(vehiculo);

		List<Averia> averias = ServicesFactory.getForemanService().mostrarAveriasVehiculo(vehiculo);
		System.out.println("Se muestran las averías existentes en el vehículo");
		mostrarAverias(averias);

	}

	private void mostrarAverias(List<Averia> averias) {
		for (Averia a : averias) {
			System.out.println("Id: " + a.getId() + "\tFecha: " + a.getFecha() 
				+ "\tImporte: " + a.getImporte()+"\tEstado: "+a.getStatus()
				+ "\tDescripcion: " + a.getDescripcion());
		}
	}

}