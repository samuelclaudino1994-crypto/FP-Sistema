
import java.math.BigDecimal;
import java.util.List;

public class FinanceiroService {

    private MovimentacaoDAO movimentacaoDAO;

    public FinanceiroService() {
        this.movimentacaoDAO = new MovimentacaoDAO();
    }

    /**
     * REGRA DE NEGÓCIO: Calcula o saldo dinâmico (Total Ganhos - Total Despesas)
     */
    public BigDecimal calcularSaldoPorUsuario(int idUsuario) {
        List<Movimentacao> todasMovimentacoes = movimentacaoDAO.listar();
        BigDecimal saldo = BigDecimal.ZERO;

        for (Movimentacao mov : todasMovimentacoes) {
            if (mov.getUsuario().getIdUsuario() == idUsuario) {
                if (mov.getTipo() == 'G') {
                    saldo = saldo.add(mov.getValor());
                } else if (mov.getTipo() == 'D') {
                    saldo = saldo.subtract(mov.getValor());
                }
            }
        }
        return saldo;
    }

    /**
     * REGRA DE NEGÓCIO PREMIUM: Calcula o total gasto em uma categoria/pilar específico
     */
    public BigDecimal calcularGastoPorPilar(int idUsuario, String nomeCategoriaPilar) {
        List<Movimentacao> todasMovimentacoes = movimentacaoDAO.listar();
        BigDecimal totalGasto = BigDecimal.ZERO;

        for (Movimentacao mov : todasMovimentacoes) {
            // Regra: Deve ser do usuário, deve ser Despesa ('D') e pertencer ao pilar correspondente
            if (mov.getUsuario().getIdUsuario() == idUsuario && mov.getTipo() == 'D') {
                if (mov.getCategoria().getNomeCategoria().equalsIgnoreCase(nomeCategoriaPilar)) {
                    totalGasto = totalGasto.add(mov.getValor());
                }
            }
        }
        return totalGasto;
    }

    /**
     * GATILHO DOS 80% (RN-002 do seu Documento): 
     * Verifica a saúde orçamentária de um pilar e retorna um alerta caso atinja o limite crítico.
     */
    public String verificarAlertaOrcamento(Usuario usuario, String nomePilar) {
        BigDecimal limiteMaximo = BigDecimal.ZERO;

        // Identifica qual o teto do pilar com base nas regras 55/25/20 do modelo Usuario
        if (nomePilar.equalsIgnoreCase("Essenciais")) {
            limiteMaximo = usuario.getLimiteEssencial();
        } else if (nomePilar.equalsIgnoreCase("Diversão")) {
            limiteMaximo = usuario.getLimiteDiversao();
        } else if (nomePilar.equalsIgnoreCase("Reserva")) {
            limiteMaximo = usuario.getMetaReserva();
        }

        if (limiteMaximo.compareTo(BigDecimal.ZERO) == 0) return "";

        // Busca quanto o usuário já gastou de fato no banco de dados
        BigDecimal totalGasto = calcularGastoPorPilar(usuario.getIdUsuario(), nomePilar);

        // Define o limite de alerta (80% do limite máximo)
        BigDecimal limiteAlerta = limiteMaximo.multiply(new BigDecimal("0.80"));

        // Se o total gasto ultrapassar o limite de alerta, dispara a notificação
        if (totalGasto.compareTo(limiteMaximo) >= 0) {
            return "🚨 CRÍTICO: Você ESTOUROU o limite do pilar " + nomePilar + "! Gasto: R$" + totalGasto + " / Limite: R$" + limiteMaximo;
        } else if (totalGasto.compareTo(limiteAlerta) >= 0) {
            return "⚠️ ALERTA: Você atingiu 80% do teto para " + nomePilar + ". Evite novos gastos neste pilar!";
        }

        return "✅ Pilar " + nomePilar + " está sob controle.";
    }
}