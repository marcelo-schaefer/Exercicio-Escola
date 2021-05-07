package br.com.proway.senior.escola;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

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
		boletim.removeTodasProva();
		Materia materia = new Materia();
		Prova prova = new Prova(periudoPadrao, boletim.getAluno(), materia);
		Prova prova1 = new Prova(periudoPadrao, boletim.getAluno(), materia);
		Prova prova2= new Prova(periudoPadrao, boletim.getAluno(), materia);
		try {
			prova.setNota(10.0);
			prova1.setNota(9.0);
			prova2.setNota(8.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boletim.addProva(prova);
		boletim.addProva(prova1);
		boletim.addProva(prova2);
		assertEquals(9.0, boletim.getMedia(), 0.01);
	}

	@Test
	public void testAddProva() {
		boletim.removeTodasProva();
		Materia materia = new Materia();
		Prova prova = new Prova(periudoPadrao, boletim.getAluno(), materia);
		boletim.addProva(prova);
		assertEquals(1, (int) boletim.getProvas().size());
	}

	@Test
	public void testeRemoveProva() {
		boletim.removeTodasProva();
		Materia materia = new Materia();
		Prova prova = new Prova(periudoPadrao, boletim.getAluno(), materia);
		boletim.addProva(prova);
		boletim.addProva(prova);
		boletim.removeProva(1);
		assertEquals(1, (int) boletim.getProvas().size());
	}

	@Test
	public void testeRemoveTodasProva() {
		Materia materia = new Materia();
		Prova prova = new Prova(periudoPadrao, boletim.getAluno(), materia);
		boletim.addProva(prova);
		boletim.addProva(prova);
		boletim.removeTodasProva();
		assertFalse((int) boletim.getProvas().size() > 0);
	}
}
