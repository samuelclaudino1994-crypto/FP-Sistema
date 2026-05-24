import java.math.BigDecimal;
import java.util.List;

public class TesteSaldo {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA INTELIGÊNCIA DE ORÇAMENTO (MÉTODO 55/25/20) ===");

        FinanceiroService financeiroService = new FinanceiroService();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        // 1. Carrega os dados reais do Samuel do banco (ID 2)
        List<Usuario> usuarios = usuarioDAO.listar();
        Usuario samuel = null;
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == 2) {
                samuel = u;
                break;
            }
        }

        if (samuel != null) {
            System.out.println("Usuário carregado: " + samuel.getNome());
            System.out.println("Salário cadastrado: R$ " + samuel.getSalario());
            System.out.println("--------------------------------------------------");
            System.out.println("Limites Calculados no Java:");
            System.out.println("-> Teto Essenciais (55%): R$ " + samuel.getLimiteEssencial());
            System.out.println("-> Teto Diversão (25%): R$ " + samuel.getLimiteDiversao());
            System.out.println("--------------------------------------------------");

            // 2. Executa a nossa camada de serviço inteligente para auditar os gastos do banco
            BigDecimal saldoCalculado = financeiroService.calcularSaldoPorUsuario(samuel.getIdUsuario());
            System.out.println("Saldo Geral Consolidado: R$ " + saldoCalculado);
            
            // 3. Roda o Gatilho dos 80% baseado no que está salvo na tabela de movimentações
            // Obs: Certifique-se de que no banco as categorias se chamem exatamente "Essenciais" ou "Diversão" 
            // ou altere as Strings de teste abaixo para casar com as categorias que você criou!
            String statusEssenciais = financeiroService.verificarAlertaOrcamento(samuel, "Essenciais");
            String statusDiversao = financeiroService.verificarAlertaOrcamento(samuel, "Diversão");

            System.out.println("\n--- STATUS DAS METAS PREVENTIVAS ---");
            System.out.println(statusEssenciais);
            System.out.println(statusDiversao);
            System.out.println("------------------------------------\n");

        } else {
            System.out.println("❌ Usuário com ID 2 não foi encontrado no banco.");
        }
    }
}