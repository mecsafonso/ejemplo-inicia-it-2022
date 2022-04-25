package ar.edu.utn.frba.capacitacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AlumnoTest {

	@Test
	public void testInscripcionOK() throws Exception {
		// Pre
		Alumno alumno = new Alumno("Ezequiel");

		List<Materia> correlativasAlgoritmos = new ArrayList<Materia>();
		Materia algoritmos = new Materia("algoritmos", correlativasAlgoritmos);
		List<Materia> correlativasPdp = new ArrayList<Materia>();
		correlativasPdp.add(algoritmos);
		alumno.setMateriasAprobadas(correlativasPdp);
		Materia pdp = new Materia("pdp", correlativasPdp);
		Curso curso = new Curso(20, pdp, ModalidadCursada.ANUAL, 2020);

		// Operatoria
		alumno.inscribir(curso);

		// Post
		assertEquals(curso.estaInscripto(alumno), true);
	}

	@Test
	public void testInscripcionFaltaCorrelativa() throws Exception {
		// Pre
		Alumno alumno = new Alumno("Ezequiel");

		List<Materia> correlativasAlgoritmos = new ArrayList<Materia>();
		Materia algoritmos = new Materia("algoritmos", correlativasAlgoritmos);
		List<Materia> correlativasPdp = new ArrayList<Materia>();
		correlativasPdp.add(algoritmos);
		Materia pdp = new Materia("pdp", correlativasPdp);
		Curso curso = new Curso(20, pdp, ModalidadCursada.ANUAL, 2020);

		// Operatoria

		// Post

		assertThrows(NoCumpleCorrelativasException.class, () -> {
			alumno.inscribir(curso);
		});

	}

}
