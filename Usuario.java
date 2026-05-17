import java.math.BigDecimal;

public class Usuario {
    // Atributos baseados no seu modelo de banco de dados
    private int idUsuario;
    private String nome;
    private BigDecimal salario; // Alterado para BigDecimal para precisão monetária

    // Construtor completo para quando puxarmos os dados do banco
    public Usuario(int idUsuario, String nome, BigDecimal salario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.salario = salario;
    }

    // Construtor sem ID (útil para quando o usuário estiver se cadastrando pela primeira vez)
    public Usuario(String nome, BigDecimal salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // --- MÉTODOS DO AGENTE INTELIGENTE (Regras de Negócio) ---

    // Calcula o teto máximo para despesas essenciais (55%)
    public BigDecimal getLimiteEssencial() {
        if (this.salario == null) return BigDecimal.ZERO;
        return this.salario.multiply(new BigDecimal("0.55"));
    }

    // Calcula o limite para gastos com estilo de vida/diversão (25%)
    public BigDecimal getLimiteDiversao() {
        if (this.salario == null) return BigDecimal.ZERO;
        return this.salario.multiply(new BigDecimal("0.25"));
    }

    // Calcula a meta ideal de reserva de emergência (20%)
    public BigDecimal getMetaReserva() {
        if (this.salario == null) return BigDecimal.ZERO;
        return this.salario.multiply(new BigDecimal("0.20"));
    }

    // --- GETTERS E SETTERS (Encapsulamento seguro) ---

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        // compareTo retorna: -1 se for menor, 0 se for igual, 1 se for maior
        // Se salario for maior ou igual a ZERO (>= 0)
        if (salario != null && salario.compareTo(BigDecimal.ZERO) >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Erro: O salário não pode ser negativo!");
        }
    }
}