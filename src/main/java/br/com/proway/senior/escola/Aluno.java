package br.com.proway.senior.escola;

import util.Verificacoes;

/**
 * pessoa estuda na escola
 * 
 * um aluno é uma pessoa que estuda na escola. o aluno frequenta uma turma
 * {@link} Turma} tem Nota {@link Notas} e Boletim{@link Boletim}.
 * 
 * @author marcelo schaefer
 * @see Notas
 * @see boletim
 * @see Turma
 */
public class Aluno {

	private String nome;
	private String ultimoNome;
	private Integer idade;

	public String getNome() {
		return nome;
	}

	// sobrenome nao pode ter numeros ou caracteres especias
	public void setNome(String nomeEntrada) throws Exception {
		if (!Verificacoes.verificarCaracteres(nomeEntrada)) {
			throw new Exception("nome nao pode ter numeros");
		}
		this.nome = nomeEntrada;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	// sobrenome nao pode ter numeros ou caracteres especias
	public void setUltimoNome(String ultimoNomeEntrada) throws Exception {
		if (!Verificacoes.verificarCaracteres(ultimoNomeEntrada)) {
			throw new Exception("nome nao pode ter numeros");
		}
		this.ultimoNome = ultimoNomeEntrada;
	}

	public Integer getIdade() {
		return idade;
	}

	// a idade nao pode ser menor que 0 ou maior que 130
	public void setIdade(Integer idadeEntrada) throws Exception {

		if (idadeEntrada < 0 || idadeEntrada > 130) {
			throw new Exception("A idade passada é inviavel");
		} else {
			this.idade = idadeEntrada;
		}
	}
}
