package ar.edu.utn.frba.capacitacion;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Alumno {

	private String nombre;
	private List<Curso> cursos;
	private List<Materia> materiasAprobadas;

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
		this.materiasAprobadas = Collections.emptyList();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Collection<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public void inscribir(Curso curso) throws Exception {
		curso.inscribir(this);
	}

}
