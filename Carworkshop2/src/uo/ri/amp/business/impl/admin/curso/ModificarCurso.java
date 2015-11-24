package uo.ri.amp.business.impl.admin.curso;

import java.util.List;

import uo.ri.amp.business.impl.Command;
import uo.ri.amp.business.impl.util.Asserts;
import uo.ri.amp.model.ContenidoCurso;
import uo.ri.amp.model.Curso;
import uo.ri.amp.model.TipoVehiculo;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.CursoFinder;
import uo.ri.amp.persistence.TipoVehiculoFinder;
import uo.ri.amp.persistence.util.Jpa;

public class ModificarCurso implements Command {

	private String codigo;
	private String nombre;
	private String descripcion;
	private int horasTotales;
	private List<Double> porcentajes;

	public ModificarCurso(String codigo, String nombre, String descripcion,
			int horasTotales, List<Double> porcentajes) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horasTotales = horasTotales;
		this.porcentajes = porcentajes;
	}

	@Override
	public Object execute() throws BusinessException {

		Curso c=CursoFinder.findByCodigo(codigo);
		Asserts.assertNotNull(c);
		
		c.setNombre(nombre);
		c.setDescripcion(descripcion);
		c.setHorasTotales(horasTotales);
		
		Jpa.getManager().merge(c);
		
		List<TipoVehiculo> tipos = TipoVehiculoFinder.findAll();

		for (int i = 0; i < tipos.size(); i++) {
			ContenidoCurso cc = new ContenidoCurso(c, tipos.get(i),
					porcentajes.get(i));
			Jpa.getManager().merge(cc);
		}
		return null;
	}

}
