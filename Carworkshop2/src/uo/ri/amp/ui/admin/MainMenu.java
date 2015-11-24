package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.GenerarCertificadosAction;
import uo.ri.amp.ui.util.FixedMenu;

/**
 * Menú principal del administrador del sistema.
 * @author UO223936
 * @see BaseMenu
 */
public class MainMenu extends FixedMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{"Administrador", null },
			{"Gestión de cursos",			CursoMenu.class},
			{"Gestión de certificados",		GenerarCertificadosAction.class},
			{"Listados de interés",			ListasMenu.class},
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
