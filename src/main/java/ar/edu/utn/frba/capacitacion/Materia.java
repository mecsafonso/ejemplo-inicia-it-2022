package ar.edu.utn.frba.capacitacion;

import java.util.Collection;
import java.util.List;

public class Materia {

	String nombre;
	List<Materia> correlativas;

	public boolean cumpleCorrelativas(Collection<Materia> materias) {

		return materias.containsAll(correlativas);

	}

	public Materia(String nombre, List<Materia> correlativas) {
		super();
		this.nombre = nombre;
		this.correlativas = correlativas;
	}
}
