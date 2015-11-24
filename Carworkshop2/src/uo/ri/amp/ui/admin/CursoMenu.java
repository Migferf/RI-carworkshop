package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.curso.AñadirCursoAction;
import uo.ri.amp.ui.admin.action.curso.BorrarCursoAction;
import uo.ri.amp.ui.admin.action.curso.ListarCursosAction;
import uo.ri.amp.ui.admin.action.curso.ModificarCursoAction;
import uo.ri.amp.ui.util.FixedMenu;

/**
 * Menú para las opciones de gestión de cursos
 * @author UO223936
 * @see BaseMenu
 */
public class CursoMenu extends FixedMenu {

	public CursoMenu(){
		menuOptions = new Object[][] { 
			{"Administrador > Gestión de cursos", null },
			{"Añadir curso",			AñadirCursoAction.class},
			{"Modificar curso",			ModificarCursoAction.class},
			{"Borrar curso",			BorrarCursoAction.class},
			{"Listar cursos",			ListarCursosAction.class},
			{"Gestión de asistencias",	AsistenciasMenu.class}
		};
	}

}
