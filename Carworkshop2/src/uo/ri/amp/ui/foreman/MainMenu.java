package uo.ri.amp.ui.foreman;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.foreman.action.AsignarAveriaMecanicoAction;
import uo.ri.amp.ui.foreman.action.AñadirAveriaAction;
import uo.ri.amp.ui.foreman.action.BorrarAveriaAction;
import uo.ri.amp.ui.foreman.action.ListarAveriasVehiculoAction;
import uo.ri.amp.ui.foreman.action.ModificarAveriaAction;
import uo.ri.amp.ui.util.FixedMenu;

/**
 * Menú principal para el jefe de taller
 * @author UO223936
 * @see BaseMenu
 */
public class MainMenu extends FixedMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{"Jefe de taller", 								null },
			{"Añadir una avería",							AñadirAveriaAction.class},
			{"Modificar una avería",						ModificarAveriaAction.class},
			{"Borrar una avería",							BorrarAveriaAction.class},
			{"Ver historial de averías de un vehículo",		ListarAveriasVehiculoAction.class},
			{"Asignar una avería a un mecánico",			AsignarAveriaMecanicoAction.class},
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
