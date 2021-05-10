package br.com.proway.senior.escola;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Materia;
import br.com.proway.senior.escola.model.Prova;

public class ProvaTest {

	static Integer data = 202105;
	static Prova prova;

	@BeforeClass
	public static void testProva() throws Exception {
		Aluno aluno = new Aluno();
		Materia materia = new Materia();
		prova = new Prova(data, aluno, materia);
	}

	@Test
	public void testProvaExiste() {
		assertNotNull(prova);
	}

	@Test
	public void testGetPeriudo() {
		assertEquals(data, prova.getPeriudo());
	}

	@Test
	public void testGetAluno() {
		assertNotNull(prova.getAluno());
	}

	@Test
	public void testGetMateria() {
		assertNotNull(prova.getMateria());
	}

	@Test
	public void testSetNotaCerto() {
		try {
			prova.setNota(10.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(expected = Exception.class)
	public void testSetNotaErrado() throws Exception {
		prova.setNota(29.7);
	}

}
