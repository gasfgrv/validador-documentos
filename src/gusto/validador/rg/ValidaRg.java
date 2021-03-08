package gusto.validador.rg;

import java.util.ArrayList;
import java.util.List;

public class ValidaRg {
	public boolean isRgValido(String rg) {
		// Serve apenas para RGs de São Paulo
		List<String> numerosRg = new ArrayList<>();

		int digitoValidador = 0;

		for (char num : rg.toCharArray()) {
			if (num != '.' && num != '-') {
				numerosRg.add(Character.toString(num));
			}
		}

		for (int i = 0; i < numerosRg.size() - 1; i++) {
			digitoValidador += Integer.parseInt(numerosRg.get(i)) * (i + 2);
		}

		digitoValidador = 11 - (digitoValidador % 11);

		boolean isValidoComDigitoNumerico = numerosRg.get(numerosRg.size() - 1).equals(Integer.toString(digitoValidador))
				|| numerosRg.get(numerosRg.size() - 1).equals("11") && digitoValidador == 11;

		boolean isValidoComDigitoX = numerosRg.get(numerosRg.size() - 1).equals("X") && digitoValidador == 10;

		return isValidoComDigitoNumerico || isValidoComDigitoX;
	}
}
