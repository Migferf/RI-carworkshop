package uo.ri.amp.ui.util;

import java.util.List;

import uo.ri.amp.model.Mecanico;

public class CollectionsPrinter {
	
	public static void listarMecanicos(List<Mecanico> mecanicos)
	{
		for(Mecanico m: mecanicos)
		{
			System.out.println("ID: "+m.getId()+"\tDNI: "+m.getDni()
				+"\tNombre: "+m.getNombre()+"\tApellidos: "+m.getApellidos());
		}
	}

}
