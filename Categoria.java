public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private double porcentagemMeta;

    // Construtor completo (para ler do banco)
    public Categoria(int idCategoria, String nomeCategoria, double porcentagemMeta) {
        this.idCategoria = idCategoria;
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

    public double getPorcentagemMeta() {
        return porcentagemMeta;
    }

    public void setPorcentagemMeta(double porcentagemMeta) {
        this.porcentagemMeta = porcentagemMeta;
    }
}