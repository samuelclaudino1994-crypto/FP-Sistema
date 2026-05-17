import java.math.BigDecimal;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private BigDecimal porcentagemMeta;

    // Construtor padrão
    public Categoria() {}

    // Construtor completo para quando puxarmos dados do banco
    public Categoria(int idCategoria, String nomeCategoria, BigDecimal porcentagemMeta) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.porcentagemMeta = porcentagemMeta;
    }

    // Construtor sem ID (ideal para novos cadastros)
    public Categoria(String nomeCategoria, BigDecimal porcentagemMeta) {
        this.nomeCategoria = nomeCategoria;
        this.porcentagemMeta = porcentagemMeta;
    }

    // Getters e Setters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public BigDecimal getPorcentagemMeta() {
        return porcentagemMeta;
    }

    public void setPorcentagemMeta(BigDecimal porcentagemMeta) {
        // Validação básica opcional: garante que a porcentagem não seja negativa
        if (porcentagemMeta != null && porcentagemMeta.compareTo(BigDecimal.ZERO) >= 0) {
            this.porcentagemMeta = porcentagemMeta;
        } else {
            System.out.println("Erro: A porcentagem da meta não pode ser negativa!");
        }
    }
}