package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.GenerarCertificados;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{"Administrador", null },
			{"Gestión de cursos",			CursoMenu.class},
			{"Gestión de certificados",		GenerarCertificados.class},
			{"Listados de interés: ",		ListasMenu.class},
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}

}
