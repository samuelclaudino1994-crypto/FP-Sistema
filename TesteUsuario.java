import java.math.BigDecimal;

public class TesteUsuario {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO TESTE DE INTEGRAÇÃO ===");
        
        // 1. Instanciando o modelo usando o construtor customizado que você criou
        // (Nome e Salário)
        Usuario novoUsuario = new Usuario("Samuel Claudino", new BigDecimal("4500.50"));
        
        // 2. Apenas para ver as suas regras de negócio funcionando no terminal antes de salvar
        System.out.println("\n--- Dados do Usuário no Java ---");
        System.out.println("Nome: " + novoUsuario.getNome());
        System.out.println("Salário Base: R$ " + novoUsuario.getSalario());
        System.out.println("Limite Essencial (55%): R$ " + novoUsuario.getLimiteEssencial());
        System.out.println("Limite Diversão (25%): R$ " + novoUsuario.getLimiteDiversao());
        System.out.println("Meta Reserva (20%): R$ " + novoUsuario.getMetaReserva());
        System.out.println("--------------------------------\n");
        
        // 3. Instanciando o DAO (o nosso "garçom" do banco)
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        System.out.println("Enviando dados para o Supabase via Transaction Pooler...");
        
        // 4. Chama o método salvar passando o objeto que criamos ali em cima
        boolean sucesso = usuarioDao.salvar(novoUsuario);
        
        // 5. Verifica se deu certo
        if (sucesso) {
            System.out.println("\n🚀 SUCESSO ABSOLUTO! O Java se conectou, usou o DAO e gravou o registro no Supabase!");
            System.out.println("Abra o Table Editor no navegador para ver a linha do ID 2.");
        } else {
            System.out.println("\n❌ FALHA! Ocorreu um erro. Verifique as mensagens de erro acima.");
        }
    }
}