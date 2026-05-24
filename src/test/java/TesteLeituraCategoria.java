import java.util.List;

public class TesteLeituraCategoria {
    public static void main(String[] args) {
        System.out.println("=== TESTE DE LEITURA DO BANCO DE DADOS ===");

        // 1. Instanciamos o DAO
        CategoriaDAO categoriaDao = new CategoriaDAO();

        System.out.println("Buscando dados do Supabase...\n");
        // 2. Chamamos o método listar() que criamos agora
        List<Categoria> categoriasDoBanco = categoriaDao.listar();

        // 3. Varremos a lista exibindo cada elemento no terminal
        System.out.println("--------------------------------------------------");
        System.out.printf("%-4s | %-20s | %-10s\n", "ID", "NOME DA CATEGORIA", "META %");
        System.out.println("--------------------------------------------------");

        for (Categoria c : categoriasDoBanco) {
            System.out.printf("%-4d | %-20s | %-10s%%\n", 
                c.getIdCategoria(), 
                c.getNomeCategoria(), 
                c.getPorcentagemMeta().toString()
            );
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Total de registros carregados no Java: " + categoriasDoBanco.size());
    }
}