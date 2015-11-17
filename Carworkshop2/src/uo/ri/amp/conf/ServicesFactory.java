package uo.ri.amp.conf;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.ForemanService;
import uo.ri.amp.business.impl.ForemanServiceImpl;
import uo.ri.amp.business.impl.AdminServiceImpl;

/**
 * Clase factoría para crear los servicios de la capa de negocio sin que la capa de lógica tenga que conocerlos.
 * @author Miguel Fernández Fuentes
 *
 */
public class ServicesFactory {
	
	private static ForemanService fs;
	private static AdminService as;
	
	/**
	 * Devuelve un servicio de foreman para que la capa de presentación trabaje. Siempre es el mismo.
	 * @return
	 */
	public static ForemanService getForemanService()
	{
		if(fs==null)
		{
			fs=new ForemanServiceImpl();
		}
		return fs;
	}
	
	/**
	 * Devuelve un servicio de admin para que la capa de presentación trabaje. Siempre es el mismo.
	 * @return
	 */
	public static AdminService getAdminService()
	{
		if(as==null)
		{
			as=new AdminServiceImpl();
		}
		return as;
	}

}
