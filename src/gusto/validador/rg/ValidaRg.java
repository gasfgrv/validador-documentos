package gusto.validador.rg;

import java.util.ArrayList;
import java.util.List;

public class ValidaRg {
	public boolean isRgValido(String rg) {
		// Serve apenas para RGs de São Paulo
		List<String> numerosRg = new ArrayList<String>();

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

		if (numerosRg.get(numerosRg.size() - 1).equals(Integer.toString(digitoValidador))) {
			return true;
		} else if (numerosRg.get(numerosRg.size() - 1).equals("11") && digitoValidador == 11) {
			return true;
		} else if (numerosRg.get(numerosRg.size() - 1).toUpperCase().equals("X") && digitoValidador == 10) {
			return true;
		}

		return false;
	}
}
