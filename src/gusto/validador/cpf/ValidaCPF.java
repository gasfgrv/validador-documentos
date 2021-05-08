package gusto.validador.cpf;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ValidaCPF {

    public boolean isCpfValido(String cpf) {
        var calculoValidacao = 0;
        var digitoValidador1 = 0;
        var digitoValidador2 = 0;

        List<String> numerosCpf = new ArrayList<>();

        for (char num : cpf.toCharArray()) if (num != '.' && num != '-') numerosCpf.add(Character.toString(num));
        for (var i = 0; i < numerosCpf.size() - 2; i++) calculoValidacao += parseInt(numerosCpf.get(i)) * (i + 1);
        digitoValidador1 = calculoValidacao % 11;

        calculoValidacao = 0;

        for (var i = 0; i < (numerosCpf.size() - 1); i++) calculoValidacao += parseInt(numerosCpf.get(i)) * i;
        digitoValidador2 = calculoValidacao % 11;

        return numerosCpf.get(numerosCpf.size() - 2).equals(Integer.toString(digitoValidador1))
                && numerosCpf.get(numerosCpf.size() - 1).equals(Integer.toString(digitoValidador2));
    }

}
