import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class FinanceiroServiceTest {

    @Test
    public void deveCalcularAsPorcentagensDoSalarioCorretamente() {
        // 1. Cenário: Instanciamos um usuário com salário de R$ 2.000,00
        Usuario usuario = new Usuario("Samuel Teste", new BigDecimal("2000.00"));

        // 2. Ação & Validação: O JUnit checa se o seu modelo calculou a regra 55/25/20 certinho
        // assertEquals(Valor_Esperado, Valor_Calculado_Pelo_Seu_Codigo)
        
        assertEquals(new BigDecimal("1100.0000"), usuario.getLimiteEssencial(), "O limite essencial deve ser 55%");
        assertEquals(new BigDecimal("500.0000"), usuario.getLimiteDiversao(), "O limite de diversão deve ser 25%");
        assertEquals(new BigDecimal("400.0000"), usuario.getMetaReserva(), "A meta de reserva deve ser 20%");
    }
}