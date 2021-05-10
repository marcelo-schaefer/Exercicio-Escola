package br.com.proway.senior.escola.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Materia;
import br.com.proway.senior.escola.model.Prova;
import br.com.proway.senior.escola.model.ProvaDao;
import br.com.proway.senior.persistence.ArrayListPersistenceProva;

public class ProvaControllerTest {

	static ProvaController controller = new ProvaController(null);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Materia materia = new Materia();
		Prova prova = new Prova(202105, aluno, materia);
		controller = new ProvaController(prova);

	}

	@Test
	public void testProvaControllerProva() {
		assertNotNull(controller);
	}

	@Test
	public void testAddProva() {
		assertEquals(0, (int) controller.addProva().getId());
	}

	@Test
	public void testRemoveProva() {
		controller.addProva();
		ArrayListPersistenceProva db = new ArrayListPersistenceProva();
		ProvaDao dao = new ProvaDao(db);
		Aluno aluno = new Aluno();
		Materia materia = new Materia();
		Prova prova = new Prova(202105, aluno, materia);
		dao.add(prova);
		controller.removeProva();
		assertEquals(1, 0);
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

}
