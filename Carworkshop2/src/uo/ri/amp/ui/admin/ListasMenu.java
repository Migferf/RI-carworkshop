package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.listados.ListarHorasMecanicoAction;
import uo.ri.amp.ui.admin.action.listados.ListarHorasTipoVehiculoAction;
import uo.ri.amp.ui.util.FixedMenu;

/**
 * Menú de algunos listados accesibles para el administrador.
 * @author UO223936
 * @see BaseMenu
 */
public class ListasMenu extends FixedMenu{
	
	public ListasMenu() {
		menuOptions = new Object[][] { 
			{"Administrador > Listados de interés", null },
			{"Listar horas de mecánico",				ListarHorasMecanicoAction.class},
			{"Listar horas de tipo de vehículo",		ListarHorasTipoVehiculoAction.class},
		};
	}

}
