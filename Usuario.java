public class Usuario {
    // Atributos baseados no seu modelo de banco de dados
    private int idUsuario;
    private String nome;
    private double salario;

    // Construtor completo para quando puxarmos os dados do banco
    public Usuario(int idUsuario, String nome, double salario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.salario = salario;
    }

    // Construtor sem ID (útil para quando o usuário estiver se cadastrando pela primeira vez)
    public Usuario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // --- MÉTODOS DO AGENTE INTELIGENTE (Regras de Negócio) ---

    // Calcula o teto máximo para despesas essenciais (55%)
    public double getLimiteEssencial() {
        return this.salario * 0.55;
    }

    // Calcula o limite para gastos com estilo de vida/diversão (25%)
    public double getLimiteDiversao() {
        return this.salario * 0.25;
    }

    // Calcula a meta ideal de reserva de emergência (20%)
    public double getMetaReserva() {
        return this.salario * 0.20;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Erro: O salário não pode ser negativo!");
        }
    }
}