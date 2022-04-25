package ar.edu.utn.frba.capacitacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CursoTest {

	@Test
	public void testCursoAbiertoOK() throws Exception {

		// Pre
		Alumno alumno = new Alumno("Ezequiel");

		List<Materia> correlativasAlgoritmos = new ArrayList<Materia>();
		Materia algoritmos = new Materia("algoritmos", correlativasAlgoritmos);
		List<Materia> correlativasPdp = new ArrayList<Materia>();
		correlativasPdp.add(algoritmos);
		alumno.setMateriasAprobadas(correlativasPdp);
		Materia pdp = new Materia("pdp", correlativasPdp);
		Curso curso = new Curso(1, pdp, ModalidadCursada.ANUAL, 2020);

		// Operatoria
		alumno.inscribir(curso);
		curso.abrir();

		// Post
		assertTrue(curso.isAbierto());
	}

	public void testCursoAbiertoFALLA() throws Exception {

		// Pre
		Alumno alumno = new Alumno("Ezequiel");

		List<Materia> correlativasAlgoritmos = new ArrayList<Materia>();
		Materia algoritmos = new Materia("algoritmos", correlativasAlgoritmos);
		List<Materia> correlativasPdp = new ArrayList<Materia>();
		correlativasPdp.add(algoritmos);
		alumno.setMateriasAprobadas(correlativasPdp);
		Materia pdp = new Materia("pdp", correlativasPdp);
		Curso curso = new Curso(5, pdp, ModalidadCursada.ANUAL, 2020);

		// Operatoria
		alumno.inscribir(curso);

		// Post
		assertThrows(MinimaCantidadInscriptosException.class, () -> {
			curso.abrir();
		});

	}
}
