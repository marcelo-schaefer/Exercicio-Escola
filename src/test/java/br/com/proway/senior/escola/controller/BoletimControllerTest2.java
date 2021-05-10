package br.com.proway.senior.escola.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Boletim;
import br.com.proway.senior.escola.model.BoletimDao;
import br.com.proway.senior.escola.model.Materia;
import br.com.proway.senior.escola.model.Prova;
import br.com.proway.senior.escola.model.ProvaDao;
import br.com.proway.senior.persistence.ArrayListPersistenceBoletim;
import br.com.proway.senior.persistence.ArrayListPersistenceProva;

public class BoletimControllerTest2 {

	static BoletimController controller = new BoletimController(null);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim(aluno, 202105);
		boletim.setId(1);
		controller = new BoletimController(boletim);
	}

	@Test
	public void testBoletimController() {
		assertNotNull(controller);
	}

	@Test
	public void testAddBoletim() {
		assertEquals(1, (int) controller.addBoletim().getId());
	}

	@Test
	public void testGetBoletim() {
		ArrayListPersistenceBoletim db = new ArrayListPersistenceBoletim();
		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim(aluno, 202105);
		db.add(boletim);
		assertEquals(1, (int) controller.getBoletim().getId());
	}

	@Test
	public void testRemoveProva() {
		Aluno aluno = new Aluno();
		Materia materia = new Materia();
		Prova prova1 = new Prova(202105, aluno, materia);
		prova1.setId(1);
		Prova prova2 = new Prova(202105, aluno, materia);
		prova1.setId(2);
		controller.addProva(prova1);
		controller.addProva(prova2);
		controller.removeProva(1);
		assertNotNull(controller.getBoletim().getProvas().size());

	}

	@Test
	public void testRemoveTodasProvas() {
		Aluno aluno = new Aluno();
		Materia materia = new Materia();
		Prova prova = new Prova(202105, aluno, materia);
		controller.addProva(prova);
		controller.removeTodasProvas();
		assertEquals(0, controller.getBoletim().getProvas().size());
	}

	@Test
	public void testAddProva() {
		controller.removeTodasProvas();
		Aluno aluno = new Aluno();
		Materia materia = new Materia();
		Prova prova = new Prova(202105, aluno, materia);
		controller.addProva(prova);
		assertEquals(1, controller.getBoletim().getProvas().size());
	}

}
