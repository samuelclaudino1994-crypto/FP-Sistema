import java.math.BigDecimal;

public class TesteCategoria {
    public static void main(String[] args) {
        System.out.println("=== TESTE DE INTEGRAÇÃO DE CATEGORIA REAL ===");

        // 1. Criando um objeto de teste com os novos campos da sua tabela
        Categoria novaCategoria = new Categoria("Investimentos", new BigDecimal("10.00"));

        // 2. Instanciando o DAO ajustado
        CategoriaDAO categoriaDao = new CategoriaDAO();

        System.out.println("Enviando '" + novaCategoria.getNomeCategoria() + "' para o Supabase...");

        // 3. Executando a inserção
        boolean sucesso = categoriaDao.salvar(novaCategoria);

        if (sucesso) {
            System.out.println("\n🚀 SUCESSO! A categoria foi salva de acordo com a estrutura do seu banco!");
            System.out.println("Atualize a tabela no Supabase para ver a linha do ID 4.");
        } else {
            System.out.println("\n❌ FALHA! Houve um erro no mapeamento das colunas.");
        }
    }
}