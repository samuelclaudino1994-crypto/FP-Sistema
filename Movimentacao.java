import java.time.LocalDate;

public class Movimentacao {
    private int idMovimentacoes;
    private String descricao;
    private double valor;
    private char tipo; // 'D' para despesa, 'G' para ganho
    private LocalDate dataMovimentacao;
    
    // Associações diretas com as outras classes (igual às Chaves Estrangeiras do seu banco)
    private Usuario usuario;
    private Categoria categoria;

    // Construtor completo
    public Movimentacao(int idMovimentacoes, String descricao, double valor, char tipo, 
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
    public Movimentacao(String descricao, double valor, char tipo, 
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
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