package br.com.proway.senior.escola.util;

public class Verificacoes {

	/**
	 * verifica se o nome possui caracteres especiais ou numeros
	 * 
	 * @param String nome, que sera verificado
	 * @return boolean
	 */
	public static boolean verificarCaracteres(String nome) {
		return !nome.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*");
	}
}
