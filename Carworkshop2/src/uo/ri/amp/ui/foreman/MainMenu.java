package uo.ri.amp.ui.foreman;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.ListasMenu;
import uo.ri.amp.ui.admin.action.GenerarCertificados;
import uo.ri.amp.ui.foreman.action.AñadirAveriaAction;
import uo.ri.amp.ui.foreman.action.BorrarAveriaAction;
import uo.ri.amp.ui.foreman.action.ListarAveriasVehiculoAction;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{"Jefe de taller", 								null },
			{"Añadir una avería",							AñadirAveriaAction.class},
			{"Modificar una avería",						GenerarCertificados.class},
			{"Borrar una avería",							BorrarAveriaAction.class},
			{"Ver historial de averías de un vehículo",		ListarAveriasVehiculoAction.class},
			{"Asignar una avería a un mecánico",			ListasMenu.class},
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
