package gusto.validador.teste;

import gusto.validador.cpf.ValidaCPF;

public class TesteCPF {
	public static void main(String[] args) {
		var validador = new ValidaCPF();
		
		// Gerador de CPFs -> https://www.4devs.com.br/gerador_de_cpf
		System.out.println(validador.isCpfValido(""));
	}
}
