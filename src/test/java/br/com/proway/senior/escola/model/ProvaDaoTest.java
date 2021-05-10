package br.com.proway.senior.escola.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.persistence.ArrayListPersistenceProva;

public class ProvaDaoTest {

	static ProvaDao provaDao = new ProvaDao(null);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayListPersistenceProva provaPerci = new ArrayListPersistenceProva();
		provaDao = new ProvaDao(provaPerci);
	}

	@Test
	public void testProvaDao() {
		assertNotNull(provaDao);
	}

	@Test
	public void testRemoveAll() {
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Prova prova = new Prova(202105, aluno, materia);
		provaDao.add(prova);
		provaDao.add(prova);
		provaDao.removeAll();
		assertEquals(0, provaDao.db.dados.size());
	}

	@Test
	public void testRemove() {
		provaDao.removeAll();
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Prova prova = new Prova(202105, aluno, materia);
		provaDao.add(prova);
		provaDao.add(prova);
		provaDao.remove(0);
		assertEquals(1, provaDao.db.dados.size());
	}

	@Test
	public void testAdd() {
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Prova prova = new Prova(202105, aluno, materia);
		provaDao.add(prova);
		provaDao.add(prova);
		assertEquals(2, provaDao.db.dados.size());
	}

	@Test
	public void testGet() {
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Prova prova = new Prova(202105, aluno, materia);
		provaDao.add(prova);
		provaDao.add(prova);
		assertNotNull(provaDao.get(0));
	}

}
