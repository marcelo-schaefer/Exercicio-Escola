package br.com.proway.senior.escola;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Boletim;

public class BoletimTest {

	static Boletim boletim;
	private static Integer periudoPadrao = 202105;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periudo = periudoPadrao;
		boletim = new Boletim(aluno, periudo);

	}

	@Test
	public void testBoletim() {
		assertNotNull(boletim);
	}

	@Test
	public void testGetAluno() {
		assertNotNull(boletim.getAluno());
	}

	@Test
	public void testGetPeriudo() {
		assertEquals((int) periudoPadrao, (int) boletim.getPeriudo());
	}

	@Test
	public void testGetMedia() {
		assertEquals(0.0, boletim.getMedia(), 0.01);
	}
}
