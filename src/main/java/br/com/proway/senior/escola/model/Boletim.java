package br.com.proway.senior.escola.model;

import java.util.ArrayList;

/**
 * reune as notas de um {@link Aluno}.
 * 
 * o boletim é o conjunto de {@link Aluno} de um periudo de um {@link Aluno}.
 * para cada periudo é calculada a media das provas , que é a nota do boletim
 * 
 * @author marcelo schaefer
 * @see Aluno
 *
 */
public class Boletim {

	private Integer id;
	private Aluno aluno;
	private Integer periudo;
	private Double media;
	private ArrayList<Prova> provas;

	/**
	 * cria um boletim
	 * 
	 * o boletim é criado a partir de um aluno e periudo,
	 * 
	 * @param aluno
	 * @param periudo
	 * @param media
	 */
	public Boletim(Aluno aluno, Integer periudo) {
		super();
		this.aluno = aluno;
		this.periudo = periudo;
		this.media = 0.0;
		this.provas = new ArrayList<Prova>();
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Integer getPeriudo() {
		return periudo;
	}

	public Double getMedia() {
		return media;
	}

	public ArrayList<Prova> getProvas() {
		return provas;
	}

	public void resetProva() {
		this.provas = new ArrayList<Prova>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
