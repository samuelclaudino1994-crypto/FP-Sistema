
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Garanta que este import está no topo do arquivo
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Esse método recebe o objeto Usuario e joga as informações dele no banco
    public boolean salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, salario) VALUES (?, ?)";
        
        try (Connection con = ConexaoBanco.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            // Aqui o DAO pega os dados que estão lá no seu Usuario.java
            stmt.setString(1, usuario.getNome());
            stmt.setBigDecimal(2, usuario.getSalario()); 
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o usuário no banco de dados!");
            e.printStackTrace();
            return false;
        }
    }

    public List<Usuario> listar() {
            String sql = "SELECT id_usuario, nome, salario FROM usuario ORDER BY id_usuario";
            List<Usuario> lista = new ArrayList<>();

            try (Connection con = ConexaoBanco.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    // Instancia o usuário usando o construtor (Nome, Salario) que você já tem
                    Usuario user = new Usuario(
                        rs.getString("nome"),
                        rs.getBigDecimal("salario")
                    );
                    // Seta o ID que veio do banco
                    user.setIdUsuario(rs.getInt("id_usuario"));

                    // Adiciona na lista
                    lista.add(user);
                }

            } catch (SQLException e) {
                System.out.println("Erro ao listar os usuários do banco de dados!");
                e.printStackTrace();
            }

            return lista;
        }
    }
