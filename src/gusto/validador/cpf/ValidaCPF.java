package gusto.validador.cpf;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ValidaCPF {

	public boolean isCpfValido(String cpf) {
		List<String> numerosCpf = new ArrayList<>();

		int calculoValidacao = 0;

		int digitoValidador1 = 0;
		int digitoValidador2 = 0;

		for (char num : cpf.toCharArray()) {
			if (num != '.' && num != '-') {
				numerosCpf.add(Character.toString(num));
			}
		}

		for (int i = 0; i < numerosCpf.size() - 2; i++) {
			calculoValidacao += parseInt(numerosCpf.get(i)) * (i + 1);
		}

		digitoValidador1 = calculoValidacao % 11;
		
		calculoValidacao = 0;

		for (int i = 0; i < numerosCpf.size() - 1; i++) {
			calculoValidacao += parseInt(numerosCpf.get(i)) * i;
		}

		digitoValidador2 = calculoValidacao % 11;

		return numerosCpf.get(numerosCpf.size() - 2).equals(Integer.toString(digitoValidador1))
				&& numerosCpf.get(numerosCpf.size() - 1).equals(Integer.toString(digitoValidador2));
	}

}
