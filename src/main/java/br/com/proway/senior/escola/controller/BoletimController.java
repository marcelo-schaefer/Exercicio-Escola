package br.com.proway.senior.escola.controller;

import java.util.ArrayList;

import br.com.proway.senior.escola.model.Boletim;
import br.com.proway.senior.escola.model.BoletimDao;
import br.com.proway.senior.escola.model.Prova;
import br.com.proway.senior.persistence.ArrayListPersistenceBoletim;

public class BoletimController {

	private Boletim boletim;
	private BoletimDao boletimDao;
	private ArrayListPersistenceBoletim dbBoletim = new ArrayListPersistenceBoletim();

	public BoletimController(Boletim boletimEntrada) {
		this.boletimDao = new BoletimDao(dbBoletim);
		this.boletim = boletimEntrada;

	}

	public Boletim addBoletim() {
		if (this.boletim.getId() == null) {
			return this.boletimDao.add(this.boletim);
		}
		return this.boletim;
	}

	public Boletim getBoletim() {
		return this.boletim;
	}

	private void calcularMedia() {
		Double total = 0.0;
		int pesos = 0;
		for (Prova prova : boletim.getProvas()) {
			total += prova.getNota() * prova.getPeso();
			pesos += prova.getPeso();
		}
		boletim.setMedia(total / pesos);
	}

	public void removeProva(int index) {
		ProvaController provaController = new ProvaController(index);
		provaController.removeProva();
		boletim.getProvas().remove(index);
		this.calcularMedia();
	}

	public void removeTodasProvas() {
		ArrayList<Prova> provas = this.boletim.getProvas();

		for (Prova prova : provas) {
			ProvaController provaController = new ProvaController(prova);
			provaController.removeProva();
		}
		this.boletim.getProvas().clear();
		this.calcularMedia();
	}

	public void addProva(Prova prova) {
		ProvaController provaController = new ProvaController(prova);
		if (prova.getId() == null) {
			provaController.addProva();
		} else {
			provaController.get(prova.getId());
		}
		boletim.getProvas().add(prova);
		this.calcularMedia();
	}
}
