package br.com.proway.senior.escola;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.escola.model.Aluno;

public class AlunoTest {

	@Test(expected = Exception.class)
	public void nomeComNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("marcelo238");
	}

	@Test(expected = Exception.class)
	public void nomeComCaracteriesEspeciais() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("marcelo238(@)$");
	}

	@Test
	public void nomeNormal() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("marcelo");
	}

	@Test(expected = Exception.class)
	public void ultimoNomeComNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setUltimoNome("schaefer3810");
	}

	@Test(expected = Exception.class)
	public void ultimoNomeComCaracteresEspeciais() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setUltimoNome("schaefer()(*");
	}

	@Test
	public void ultimoNomeNormal() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setUltimoNome("schaefer");
	}

	@Test(expected = Exception.class)
	public void idadeAbaixoDoLimite() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(-12);
	}

	@Test(expected = Exception.class)
	public void idadeAcimaDoLimite() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(173);
	}

	@Test
	public void idadeNormal() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(22);
	}
}