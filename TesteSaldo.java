import java.math.BigDecimal;

public class TesteSaldo {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA REGRA DE NEGÓCIO (CÁLCULO DE SALDO) ===");

        // 1. Instanciamos a nossa camada de serviço
        FinanceiroService financeiroService = new FinanceiroService();

        // 2. Vamos pedir o saldo do Samuel Claudino (que sabemos que é o ID 2 no seu banco)
        int idUsuarioAlvo = 2;
        System.out.println("Solicitando histórico e calculando saldo para o ID: " + idUsuarioAlvo + "...");
        
        BigDecimal saldoCalculado = financeiroService.calcularSaldoPorUsuario(idUsuarioAlvo);

        // 3. Exibe o resultado na tela
        System.out.println("--------------------------------------------------");
        System.out.println("Usuário ID: " + idUsuarioAlvo);
        System.out.println("Saldo Atual no Sistema: R$ " + saldoCalculado);
        System.out.println("--------------------------------------------------");
        
        if (saldoCalculado.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("⚠️ ATENÇÃO: O saldo deste usuário está NEGATIVO!");
        } else {
            System.out.println("✅ Saldo positivo ou zerado. Tudo sob controle!");
        }
    }
}