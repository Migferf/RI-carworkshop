package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.amp.business.impl.admin.curso.ListarCursos;
import uo.ri.amp.ui.admin.action.GenerarCertificados;
import uo.ri.amp.ui.admin.action.asistencia.AñadirAsistenciaAction;
import uo.ri.amp.ui.admin.action.asistencia.BorrarAsistenciaAction;


public class AsistenciasMenu extends BaseMenu{
	
	public AsistenciasMenu(){
		menuOptions = new Object[][] { 
			{"Administrador > Gestión de cursos > Gestión de asistencias", null },
			{"Añadir asistencia",						AñadirAsistenciaAction.class},
			{"Modificar asistencia",					GenerarCertificados.class},
			{"Borrar asistencia ",						BorrarAsistenciaAction.class},
			{"Listar asistencias de un curso",			ListarCursos.class},
		};
	}

}
