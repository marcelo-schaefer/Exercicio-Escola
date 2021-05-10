package br.com.proway.senior.escola.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.persistence.ArrayListPersistenceBoletim;

public class BoletimDaoTest {

	static BoletimDao boletimDao = new BoletimDao(null);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayListPersistenceBoletim db = new ArrayListPersistenceBoletim();
		boletimDao = new BoletimDao(db);
	}

	@Test
	public void testBoletimDao() {
		assertNotNull(boletimDao);
	}

	@Test
	public void testRemoveAll() {
		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim(aluno, 202105);
		boletimDao.add(boletim);
		boletimDao.add(boletim);
		boletimDao.removeAll();
		assertEquals(0, boletimDao.db.dados.size());
	}

	@Test
	public void testRemove() {
		boletimDao.removeAll();
		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim(aluno, 202105);
		boletimDao.add(boletim);
		boletimDao.add(boletim);
		boletimDao.remove(0);
		assertEquals(1, boletimDao.db.dados.size());
	}

	@Test
	public void testAdd() {
		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim(aluno, 202105);
		boletimDao.add(boletim);
		boletimDao.add(boletim);
		assertEquals(2, boletimDao.db.dados.size());
	}

	@Test
	public void testGet() {
		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim(aluno, 202105);
		boletimDao.add(boletim);
		boletimDao.add(boletim);
		assertNotNull(boletimDao.get(1));
	}

}
