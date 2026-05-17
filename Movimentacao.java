import java.math.BigDecimal;
import java.time.LocalDate;

public class Movimentacao {
    private int idMovimentacoes;
    private String descricao;
    private BigDecimal valor; // Alterado para BigDecimal para precisão total
    private char tipo; // 'D' para despesa, 'G' para ganho
    private LocalDate dataMovimentacao;
    
    // Associações diretas com as outras classes (Chaves Estrangeiras)
    private Usuario usuario;
    private Categoria categoria;

    // Construtor completo (para ler do banco)
    public Movimentacao(int idMovimentacoes, String descricao, BigDecimal valor, char tipo, 
                        LocalDate dataMovimentacao, Usuario usuario, Categoria categoria) {
        this.idMovimentacoes = idMovimentacoes;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.dataMovimentacao = dataMovimentacao;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    // Construtor sem ID (útil para novos cadastros de despesas)
    public Movimentacao(String descricao, BigDecimal valor, char tipo, 
                        LocalDate dataMovimentacao, Usuario usuario, Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.dataMovimentacao = dataMovimentacao;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getIdMovimentacoes() {
        return idMovimentacoes;
    }

    public void setIdMovimentacoes(int idMovimentacoes) {
        this.idMovimentacoes = idMovimentacoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        // Validação: Garante que o valor da movimentação seja positivo
        if (valor != null && valor.compareTo(BigDecimal.ZERO) >= 0) {
            this.valor = valor;
        } else {
            System.out.println("Erro: O valor da movimentação deve ser maior que zero!");
        }
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        // Validação: Aceita apenas 'D' (Despesa) ou 'G' (Ganho)
        if (tipo == 'D' || tipo == 'G') {
            this.tipo = tipo;
        } else {
            System.out.println("Erro: Tipo inválido! Use 'D' para Despesa ou 'G' para Ganho.");
        }
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}