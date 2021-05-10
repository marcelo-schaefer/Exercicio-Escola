package br.com.proway.senior.escola.model;

import br.com.proway.senior.persistence.ArrayListPersistenceProva;

public class ProvaDao {

	ArrayListPersistenceProva db;

	public ProvaDao(ArrayListPersistenceProva db) {
		this.db = db;
	}

	public void removeAll() {
		db.removeAll();
	}

	public void remove(Integer index) {
		db.remove(index);
	}

	public Prova add(Prova prova) {
		return db.add(prova);
	}

	public Prova get(int index) {
		return db.get(index);
	}

}
