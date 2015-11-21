package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.GenerarCertificados;
import uo.ri.amp.ui.admin.action.curso.AñadirCursoAction;
import uo.ri.amp.ui.admin.action.curso.ListarCursos;

public class CursoMenu extends BaseMenu {

	public CursoMenu(){
		menuOptions = new Object[][] { 
			{"Administrador > Gestión de cursos", null },
			{"Añadir curso",			AñadirCursoAction.class},
			{"Modificar curso",			GenerarCertificados.class},
			{"Borrar curso",			ListasMenu.class},
			{"Listar cursos",			ListarCursos.class},
			{"Gestión de asistencias",	AsistenciasMenu.class}
		};
	}

}
