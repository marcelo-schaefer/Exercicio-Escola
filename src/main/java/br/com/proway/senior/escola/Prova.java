package br.com.proway.senior.escola;

/**
 * eh a avalicao de um aluno em uma materia.
 * 
 * a prova registra uma avaliação realizada pelo {@link Aluno}, sobre alguma
 * materia, o {@link Aluno} pode fazer mais de uma prova, e as notas podem gerar
 * uma media para verificar se o o aluno foi aprovado, na qual registra no
 * {@link Boletim}.
 * 
 * @see Aluno
 * @see Boletim
 * @author marcelo schaefer
 *
 */
public class Prova {

	private Integer periudo;
	private Aluno aluno;
	private Materia materia;
	private Double nota;

	/**
	 * avalicação de desempenha do aluno
	 * 
	 * nao passa a nota no parametro do construtor pois precisa primeiro construir a
	 * prova para ter nota
	 * 
	 * @param Integer periudo, data da prova (yyyymmdd)
	 * @param Aluno   aluno, alunp que realizou a prova
	 * @param Materia materia, materia da prova
	 * @throws Exception
	 */
	public Prova(Integer periudo, Aluno aluno, Materia materia) {
		super();
		this.periudo = periudo;
		this.aluno = aluno;
		this.materia = materia;
	}

	public Integer getPeriudo() {
		return periudo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Materia getMateria() {
		return materia;
	}

	public Double getNota() {
		return nota;
	}

	// nota tem o minimo de 0 e maximo de 10
	public void setNota(Double notaEntra) throws Exception {
		if (notaEntra < 0 || notaEntra > 10) {
			throw new Exception("a nota esta abaixo de 0 ou acima de 10");
		}
		this.nota = notaEntra;
	}

}
