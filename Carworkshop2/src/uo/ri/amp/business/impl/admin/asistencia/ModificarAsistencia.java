package uo.ri.amp.business.impl.admin.asistencia;

import java.util.Date;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.Asistencia;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.AsistenciaFinder;
import uo.ri.amp.persistence.CursoFinder;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class ModificarAsistencia implements Command {

	private long idMecanico;
	private String codigo;
	private Date fechaInicio;
	private Date fechaFin;
	private double porcentajeAsistencia;
	private boolean apto;
	
	
	
	public ModificarAsistencia(long idMecanico, String codigo, Date fechaInicio,
			Date fechaFin, double porcentajeAsistencia, boolean apto) {
		super();
		this.idMecanico = idMecanico;
		this.codigo = codigo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.porcentajeAsistencia = porcentajeAsistencia;
		this.apto = apto;
	}



	@Override
	public Object execute() throws BusinessException {
	
		Mecanico m=MecanicoFinder.findById(idMecanico);
		Asserts.assertNotNull(m);
		
		Curso c=CursoFinder.findByCodigo(codigo);
		Asserts.assertNotNull(c);
		
		Asistencia a=AsistenciaFinder.findByIds(m, c);
		Asserts.assertNotNull(a);
		
		a.setFechaInicio(fechaInicio);
		a.setFechaFin(fechaFin);
		a.setPorcentajeAsistencia(porcentajeAsistencia);
		if(porcentajeAsistencia<85)
		{
			apto=false;
		}
		a.setApto(apto);
		
		Jpa.getManager().merge(a);
		
		return null;
	}

}
