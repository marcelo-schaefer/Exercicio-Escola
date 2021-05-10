package br.com.proway.senior.escola.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Boletim;
import br.com.proway.senior.escola.model.Materia;
import br.com.proway.senior.escola.model.Prova;

public class BoletimControllerTest {

	static BoletimController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periudo = 202105;
		Boletim boletim = new Boletim(aluno, periudo);
		controller = new BoletimController(boletim);
	}

	@Test
	public void testAddProva() {
		controller.removeTodasProva();
		Boletim boletim = controller.getBoletim();
		Materia materia = new Materia();
		Prova prova = new Prova(202105, boletim.getAluno(), materia);
		controller.addProva(prova);
		assertEquals(1, (int) boletim.getProvas().size());
	}

	@Test
	public void testeRemoveProva() {
		Materia materia = new Materia();
		Boletim boletim = controller.getBoletim();
		Prova prova = new Prova(202105, boletim.getAluno(), materia);
		controller.removeTodasProva();
		controller.addProva(prova);
		controller.addProva(prova);
		controller.removeProva(0);
		assertEquals(1, boletim.getProvas().size());
	}

	@Test
	public void testeRemoveTodasProva() {
		Materia materia = new Materia();
		Boletim boletim = controller.getBoletim();
		Prova prova = new Prova(202105, boletim.getAluno(), materia);
		controller.addProva(prova);
		controller.addProva(prova);
		controller.removeTodasProva();
		assertFalse((int) boletim.getProvas().size() > 0);
	}
}
