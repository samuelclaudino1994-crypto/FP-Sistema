import java.util.List;

public class TesteLeituraMovimentacao {
    public static void main(String[] args) {
        System.out.println("=== TESTE DE RELATÓRIO DE MOVIMENTAÇÕES (JOIN) ===");

        MovimentacaoDAO dao = new MovimentacaoDAO();
        List<Movimentacao> historico = dao.listar();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-20s | %-10s | %-4s | %-15s | %-15s\n", 
            "DATA", "DESCRIÇÃO", "VALOR", "TIPO", "USUÁRIO", "CATEGORIA");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (Movimentacao m : historico) {
            String tipoExtenso = (m.getTipo() == 'D') ? "Despesa" : "Ganho";
            
            System.out.printf("%-12s | %-20s | R$ %-7s | %-4s | %-15s | %-15s\n",
                m.getDataMovimentacao().toString(),
                m.getDescricao(),
                m.getValor().toString(),
                tipoExtenso,
                m.getUsuario().getNome(),       // Puxando o nome do objeto associado!
                m.getCategoria().getNomeCategoria() // Puxando a categoria do objeto associado!
            );
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Total de movimentações carregadas: " + historico.size());
    }
}