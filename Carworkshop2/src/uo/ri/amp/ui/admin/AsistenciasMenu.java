package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.ui.admin.action.asistencia.AñadirAsistenciaAction;
import uo.ri.amp.ui.admin.action.asistencia.BorrarAsistenciaAction;
import uo.ri.amp.ui.admin.action.asistencia.ListarAsistenciasCursoAction;
import uo.ri.amp.ui.admin.action.asistencia.ModificarAsistenciaAction;
import uo.ri.amp.ui.util.FixedMenu;

/**
 * Menú para la gestión de asistencias.
 * @author UO223936
 * @see BaseMenu
 *
 */
public class AsistenciasMenu extends FixedMenu{
	
	public AsistenciasMenu(){
		menuOptions = new Object[][] { 
			{"Administrador > Gestión de cursos > Gestión de asistencias", null },
			{"Añadir asistencia",						AñadirAsistenciaAction.class},
			{"Modificar asistencia",					ModificarAsistenciaAction.class},
			{"Borrar asistencia ",						BorrarAsistenciaAction.class},
			{"Listar asistencias de un curso",			ListarAsistenciasCursoAction.class},
		};
	}

}
