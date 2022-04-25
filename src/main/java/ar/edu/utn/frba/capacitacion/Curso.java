package ar.edu.utn.frba.capacitacion;

import java.util.HashSet;
import java.util.Set;

public class Curso {

	int numeroMinParaAbrir;
	Materia materia;
	boolean abierto;
	ModalidadCursada modalidad;
	int anio;
	Set<Alumno> inscriptos;

	public void abrir() throws Exception {
		if (inscriptos.size() >= numeroMinParaAbrir) {
			abierto = true;
		} else {
			throw new MinimaCantidadInscriptosException(
					"No cumple el minimo de inscriptos, faltan: " + (numeroMinParaAbrir - inscriptos.size()));
		}
	}

	public void inscribir(Alumno alumno) throws Exception {
		if (this.getMateria().cumpleCorrelativas(alumno.getMateriasAprobadas())) {
			inscriptos.add(alumno);
		} else {
			throw new NoCumpleCorrelativasException("No tiene las sigueintes correlativas: (todo)");
		}
	}

	public int getNumeroMinParaAbrir() {
		return numeroMinParaAbrir;
	}

	public void setNumeroMinParaAbrir(int numeroMinParaAbrir) {
		this.numeroMinParaAbrir = numeroMinParaAbrir;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	public ModalidadCursada getModalidad() {
		return modalidad;
	}

	public void setModalidad(ModalidadCursada modalidad) {
		this.modalidad = modalidad;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Set<Alumno> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(Set<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}

	public Object estaInscripto(Alumno alumno) {
		return inscriptos.contains(alumno);
	}

	public Curso(int numeroMinParaAbrir, Materia materia, ModalidadCursada modalidad, int anio) {
		super();
		this.numeroMinParaAbrir = numeroMinParaAbrir;
		this.materia = materia;
		this.abierto = false;
		this.modalidad = modalidad;
		this.anio = anio;
		this.inscriptos = new HashSet<>();
	}

}
