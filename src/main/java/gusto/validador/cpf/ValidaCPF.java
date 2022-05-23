package gusto.validador.cpf;

import gusto.validador.Validador;
import java.util.List;

public class ValidaCPF extends Validador {

    public boolean isCpfValido(String cpf) {
        var digitoValidador1 = 0;
        var digitoValidador2 = 0;

        cpf = cpf.replaceAll("[.\\-]", "").trim();

        List<Integer> numerosCpf = converterParaInteger(cpf, Integer::parseInt);

        digitoValidador1 = calcularDigitoVerificador(numerosCpf, 9, true, 1);
        digitoValidador2 = calcularDigitoVerificador(numerosCpf, 10, true, 0);

        return realizaValidacao(numerosCpf, digitoValidador1, digitoValidador2);
    }

    @Override
    protected boolean realizaValidacao(List<Integer> numeros, int... digitoValidador) {
        int digitoValidador1 = digitoValidador[0];
        int digitoValidador2 = digitoValidador[1];

        return numeros.get(9) == digitoValidador1 && numeros.get(10) == digitoValidador2;
    }

}
