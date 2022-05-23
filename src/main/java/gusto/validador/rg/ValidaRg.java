package gusto.validador.rg;

import gusto.validador.Validador;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidaRg extends Validador {
    public boolean isRgValido(String rg) {
        // Serve apenas para RGs de São Paulo
        rg = rg.replaceAll("[.\\-]", "").trim();

        List<Integer> numerosRg = converterParaInteger(rg, s -> "X".equalsIgnoreCase(s) ? 88 : Integer.parseInt(s));

        int digitoValidador = calcularDigitoVerificador(numerosRg, 8, false, 2);

        return realizaValidacao(numerosRg, digitoValidador);
    }

    @Override
    protected boolean realizaValidacao(List<Integer> numeros, int... digitoValidador) {
        Integer digito = numeros.get(8);

        Map<Integer, Integer> digitoValidado = new HashMap<>();
        digitoValidado.put(88, 10);
        digitoValidado.put(0, 11);

        if (digito == digitoValidador[0]) {
            return true;
        }

        int i = calcularDigitoVerificador(numeros, 8, false, 2);
        return i == digito;
    }

}
