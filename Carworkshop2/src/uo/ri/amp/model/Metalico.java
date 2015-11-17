package uo.ri.amp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TMetalico")
public class Metalico extends MedioPago {

	public Metalico(Cliente cliente) {
		super(cliente);
	}

	Metalico() {
		super();
	}

	@Override
	public String toString() {
		return "Metalico [toString()=" + super.toString() + "]";
	}

}
