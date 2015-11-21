package uo.ri.amp.business.impl.admin.curso;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.TipoVehiculoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class AñadirCurso implements Command {

	private Curso curso;
	private List<Double> porcentajes;
	
	
	public AñadirCurso(Curso curso,List<Double> porcentajes) {
		super();
		this.curso = curso;
		this.porcentajes=porcentajes;
	}



	@Override
	public Object execute() throws BusinessException {
		try
		{
		Asserts.existeCodigoCurso(curso);
		
		List<TipoVehiculo> tipos= TipoVehiculoFinder.findAll();
		
		Jpa.getManager().persist(curso);
		
		for(int i=0;i< porcentajes.size();i++)
		{
			ContenidoCurso cc=new ContenidoCurso(curso, tipos.get(i),porcentajes.get(i));
			Jpa.getManager().persist(cc);
		}
		}
		catch(BusinessException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw new BusinessException("Error al intentar crear el nuevo curso");
		}
		return null;
	}
	
	

}
