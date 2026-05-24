import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteMovimentacao {
    public static void main(String[] args) {
        System.out.println("=== TESTE DE MOVIMENTAÇÃO REAL ===");

        // 1. Usando o construtor de Usuario que você já tem (Nome e Salário)
        // Passamos dados fake de salário só para o construtor aceitar, mas setamos o ID 2 que manda no banco
        Usuario usuarioExistente = new Usuario("Samuel Claudino", new BigDecimal("4500.50"));
        usuarioExistente.setIdUsuario(2); // Samuel Claudino está no ID 2 do seu banco

        // 2. Usando o construtor completo de Categoria que você já tem!
        // Passamos o ID 4, o nome e a porcentagem que já estão gravados lá
        Categoria categoriaExistente = new Categoria(4, "Investimentos", new BigDecimal("10.00"));

        // 3. Criando a Movimentacao passando os dois objetos que acabamos de instanciar
        Movimentacao novaMov = new Movimentacao(
            "Aporte Mensal Bolsa", 
            new BigDecimal("2000.00"), 
            'G', // 'D' para despesa
            LocalDate.now(), 
            usuarioExistente, 
            categoriaExistente
        );

        // 4. Chamamos o DAO para salvar no Supabase
        MovimentacaoDAO movDao = new MovimentacaoDAO();
        System.out.println("Enviando movimentação para o Supabase...");
        
        boolean sucesso = movDao.salvar(novaMov);

        if (sucesso) {
            System.out.println("\n🚀 SUCESSO ABSOLUTO! Movimentação gravada usando seus construtores originais!");
            System.out.println("Checa o Table Editor do Supabase para ver a linha surgir lá.");
        } else {
            System.out.println("\n❌ FALHA! Verifique o console para entender o erro.");
        }
    }
}