package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.GenerarCertificados;
import uo.ri.amp.ui.admin.action.course.ListCursos;

public class CursoMenu extends BaseMenu {

	public CursoMenu(){
		menuOptions = new Object[][] { 
			{"Administrador", null },
			{"Añadir curso",		CursoMenu.class},
			{"Modificar curso",		GenerarCertificados.class},
			{"Borrar curso: ",		ListasMenu.class},
			{"Listar cursos",		ListCursos.class}
		};
	}

}
