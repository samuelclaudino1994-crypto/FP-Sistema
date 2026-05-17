import java.math.BigDecimal;
import java.util.List;

public class FinanceiroService {

    private MovimentacaoDAO movimentacaoDAO;

    // Construtor que inicializa o nosso DAO
    public FinanceiroService() {
        this.movimentacaoDAO = new MovimentacaoDAO();
    }

    /**
     * REGRA DE NEGÓCIO: Calcula o saldo dinâmico de um usuário específico.
     * Varre todas as movimentações dele no banco, somando ganhos e subtraindo despesas.
     */
    public BigDecimal calcularSaldoPorUsuario(int idUsuario) {
        // 1. Buscamos todas as movimentações que estão no Supabase
        List<Movimentacao> todasMovimentacoes = movimentacaoDAO.listar();
        
        // 2. Começamos o saldo com ZERO
        BigDecimal saldo = BigDecimal.ZERO;

        // 3. Varremos a lista fazendo a matemática baseada no ID do usuário
        for (Movimentacao mov : todasMovimentacoes) {
            
            // Regra de segurança: Só calcula se a movimentação pertencer ao usuário que pedimos
            if (mov.getUsuario().getIdUsuario() == idUsuario) {
                
                if (mov.getTipo() == 'G') {
                    // Se for Ganho, soma no saldo
                    saldo = saldo.add(mov.getValor());
                } else if (mov.getTipo() == 'D') {
                    // Se for Despesa, subtrai do saldo
                    saldo = saldo.subtract(mov.getValor());
                }
            }
        }

        return saldo; // Devolve o resultado final
    }
}