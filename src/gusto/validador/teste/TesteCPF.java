package gusto.validador.teste;

import gusto.validador.cpf.ValidaCPF;

import java.util.logging.Logger;

import static java.lang.String.valueOf;

public class TesteCPF {
	private static final Logger LOGGER = Logger.getLogger(TesteCPF.class.getName());

	public static void main(String[] args) {
		var validador = new ValidaCPF();
		
		// Gerador de CPFs -> https://www.4devs.com.br/gerador_de_cpf
		LOGGER.info(valueOf(validador.isCpfValido("")));
	}
}
