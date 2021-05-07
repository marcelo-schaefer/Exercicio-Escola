package br.com.proway.senior.escola;

import java.util.ArrayList;
import java.util.Iterator;

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

	public Aluno getAluno() {
		return aluno;
	}

	public Integer getPeriudo() {
		return periudo;
	}

	public Double getMedia() {
		this.calcularMedia();
		return media;
	}

	private void calcularMedia() {

		Double notas = 0.0;
		for (Prova prova : provas) {
			notas += prova.getNota();
		}
		this.media = notas / provas.size();
	}

	public void removeProva(int index) {
		this.provas.remove(index);
	}

	public void removeTodasProva() {
		this.provas = new ArrayList<Prova>();

	}

	public ArrayList<Prova> getProvas() {
		return this.provas;
	}

	public void addProva(Prova prova) {
		this.provas.add(prova);
	}
}
