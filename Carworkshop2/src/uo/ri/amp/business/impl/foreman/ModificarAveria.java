package uo.ri.amp.business.impl.foreman;

import java.util.Date;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AveriaFinder;
import uo.ri.amp.persistence.util.Jpa;

public class ModificarAveria implements Command {

	private long averiaId;
	private String descripcion;
	private Date fecha;

	public ModificarAveria(long averiaId, String descripcion, Date fecha) {
		
		this.averiaId=averiaId;
		this.descripcion=descripcion;
		this.fecha=fecha;
	}



	@Override
	public Object execute() throws BusinessException {
		
		
		Averia averia=AveriaFinder.findById(averiaId);
		
		averia.setDescripcion(descripcion);
		averia.setFecha(fecha);
		
		Jpa.getManager().merge(averia);
		
		return null;
	}

}
