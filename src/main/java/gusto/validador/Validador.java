package gusto.validador;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Validador {

    protected List<Integer> converterParaInteger(String numeroDocumento, Function<String, Integer> lambda) {
        return Stream.of(numeroDocumento.split(""))
                .map(lambda)
                .collect(Collectors.toList());
    }

    protected int calcularDigitoVerificador(List<Integer> numeros, int index, boolean apenasModulo, int peso) {
        AtomicInteger digitoValidador = new AtomicInteger();

        IntStream.range(0, index).forEach(i -> digitoValidador.addAndGet(numeros.get(i) * (i + peso)));

        return apenasModulo
                ? digitoValidador.get() % 11
                : 11 - digitoValidador.get() % 11;
    }

    protected abstract boolean realizaValidacao(List<Integer> numeros, int... digitoValidador);

}
