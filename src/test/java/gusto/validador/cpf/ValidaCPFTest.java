package gusto.validador.cpf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidaCPFTest {

    private final ValidaCPF cpf = new ValidaCPF();

    @Test
    void deveValidarUmCPF() {
        var cpfNumero = "784.254.640-13";
        var cpfNumeroSemFormatacao = "78425464013";

        assertTrue(cpf.isCpfValido(cpfNumero));
        assertTrue(cpf.isCpfValido(cpfNumeroSemFormatacao));
    }

    @Test
    void naoDeveValidarUmCPFInvalido() {
        var cpfNumero = "123.456.789-10";
        var cpfNumeroSemFormatacao = "12345678910";

        assertFalse(cpf.isCpfValido(cpfNumero));
        assertFalse(cpf.isCpfValido(cpfNumeroSemFormatacao));
    }
}