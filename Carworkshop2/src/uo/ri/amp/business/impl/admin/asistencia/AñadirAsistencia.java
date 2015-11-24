package uo.ri.amp.business.impl.admin.asistencia;

import java.util.Date;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AsistenciaFinder;
import uo.ri.amp.persistence.CursoFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class AñadirAsistencia implements Command {

	
	private long idMecanico;
	private String codigo;
	private Date fechaComienzo;
	private Date fechaFin;
	private double porcentaje;
	private boolean apto;
	
	
	
	public AñadirAsistencia(long idMecanico, String codigo, Date fechaComienzo, Date fechaFin, double porcentaje,
			boolean apto) {
		super();
		this.idMecanico = idMecanico;
		this.codigo = codigo;
		this.fechaComienzo = fechaComienzo;
		this.fechaFin = fechaFin;
		this.porcentaje = porcentaje;
		this.apto = apto;
	}



	@Override
	public Object execute() throws BusinessException {
	
		if(fechaFin.getTime()<fechaComienzo.getTime())
		{
			throw new BusinessException("La fecha de finalización no puede ser"
					+ " anterior a la de inicio");
		}
		if(porcentaje<85)
		{
			apto=false;
		}
		
		Mecanico m=MecanicoFinder.findById(idMecanico);
		assertNotNull(m);
		
		Curso c=CursoFinder.findByCodigo(codigo);
		assertNotNull(c);
		Asistencia a= AsistenciaFinder.findByIds(m, c);
		
		if(a!=null)
		{
			throw new BusinessException("El mecánico ya asistía a este curso");
		}
		Asistencia asistencia= new Asistencia(m,c,fechaComienzo,fechaFin,porcentaje,apto);
		Jpa.getManager().persist(asistencia);
		
		
		return null;
	}
	
	private void assertNotNull(Mecanico m) throws BusinessException
	{
		if(m==null)
		{
			throw new BusinessException("El mecánico no existe en la base de datos");
		}
	}
	
	private void assertNotNull(Curso c) throws BusinessException
	{
		if(c==null)
		{
			throw new BusinessException("El curso no existe en la base de datos");
		}
	}
	

}
