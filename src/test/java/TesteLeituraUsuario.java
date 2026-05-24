import java.util.List;

public class TesteLeituraUsuario {
    public static void main(String[] args) {
        System.out.println("=== TESTE DE LEITURA DE USUÁRIOS ===");

        UsuarioDAO usuarioDao = new UsuarioDAO();
        System.out.println("Buscando usuários do Supabase...\n");
        
        List<Usuario> usuarios = usuarioDao.listar();

        System.out.println("--------------------------------------------------");
        System.out.printf("%-4s | %-25s | %-12s\n", "ID", "NOME", "SALÁRIO");
        System.out.println("--------------------------------------------------");

        for (Usuario u : usuarios) {
            System.out.printf("%-4d | %-25s | R$ %-10s\n", 
                u.getIdUsuario(), 
                u.getNome(), 
                u.getSalario().toString()
            );
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Total de usuários carregados: " + usuarios.size());
    }
}