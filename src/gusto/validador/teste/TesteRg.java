package gusto.validador.teste;

import gusto.validador.rg.ValidaRg;

public class TesteRg {
	
	public static void main(String[] args) {
		var validador = new ValidaRg();
		
		//Gerador de RGs: -> https://www.4devs.com.br/gerador_de_rg
		System.out.println(validador.isRgValido(""));
	}
	
}
