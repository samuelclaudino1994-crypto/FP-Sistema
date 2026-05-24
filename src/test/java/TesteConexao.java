import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Tentando conectar ao Supabase...");
        
        // Chama o método que criamos na classe ConexaoBanco
        Connection con = ConexaoBanco.getConnection();
        
        if (con != null) {
            System.out.println("🚀 SUCESSO! O Java conseguiu se conectar ao seu banco de dados!");
            try {
                // Fecha a conexão para não deixar aberta à toa
                con.close(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ FALHA! A conexão retornou nula. Verifique sua senha ou internet.");
        }
    }
}