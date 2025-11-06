package regras;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraNotasTest {

    private final CalculadoraNotas calc = new CalculadoraNotas();

    @Test
    public void mediaBasicaDeveCalcularComPesoECasas() {
        double m = calc.calcularMedia(7.0, 5.0); // 7*0.4 + 5*0.6 = 5.8
        assertEquals(5.8, m, 0.0001);
    }

    @Test
    public void mediaComArredondamentoDuasCasas() {
        double m = calc.calcularMedia(7.25, 6.75); // ~6.95
        assertEquals(6.95, m, 0.0001);
    }

    @Test
    public void rejeitaNotaForaDoIntervalo_negativaOuMaiorQue10() {
        assertThrows(IllegalArgumentException.class, () -> calc.calcularMedia(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> calc.calcularMedia(5, 10.5));
    }

    @Test
    public void aprovadoQuandoMediaEPresencaOk() {
        boolean ok = calc.aprovado(6.0, 20, 80);
        assertTrue(ok);
    }

    @Test
    public void reprovadoPorFaltasExcedidas() {
        boolean ok = calc.aprovado(9.0, 21, 80);  // passou 1 da tolerância (20)
        assertFalse(ok);
    }

    @Test
    public void parametrosInvalidosAprovado() {
        assertThrows(IllegalArgumentException.class, () -> calc.aprovado(6.0, -1, 80));
        assertThrows(IllegalArgumentException.class, () -> calc.aprovado(6.0, 0, 0));
    }
}
