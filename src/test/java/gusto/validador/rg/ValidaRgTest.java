package gusto.validador.rg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidaRgTest {

    private final ValidaRg rg = new ValidaRg();

    @Test
    void deveValidarUmRG() {
        var rgNumero = "21.187.240-4";
        var rgNumeroSemFormatacao = "211872404";

        assertTrue(rg.isRgValido(rgNumero));
        assertTrue(rg.isRgValido(rgNumeroSemFormatacao));
    }

    @Test
    void naoDeveValidarUmRgInvalido() {
        var rgNumero = "12.345.678-9";
        var rgNumeroSemFormatacao = "123456789";

        assertFalse(rg.isRgValido(rgNumero));
        assertFalse(rg.isRgValido(rgNumeroSemFormatacao));

        rgNumero = "12.345.678-0";
        rgNumeroSemFormatacao = "123456780";

        assertFalse(rg.isRgValido(rgNumero));
        assertFalse(rg.isRgValido(rgNumeroSemFormatacao));

        rgNumero = "12.345.678-X";
        rgNumeroSemFormatacao = "12345678X";

        assertFalse(rg.isRgValido(rgNumero));
        assertFalse(rg.isRgValido(rgNumeroSemFormatacao));
    }
}