package gusto.validador.teste;

import gusto.validador.rg.ValidaRg;

import java.util.logging.Logger;

import static java.lang.String.valueOf;

public class TesteRg {

	private static final Logger LOGGER = Logger.getLogger(TesteRg.class.getName());

	public static void main(String[] args) {
		var validador = new ValidaRg();
		
		//Gerador de RGs: -> https://www.4devs.com.br/gerador_de_rg
		LOGGER.info(valueOf(validador.isRgValido("")));
	}
	
}
