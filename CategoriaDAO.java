import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public boolean salvar(Categoria categoria) {
        // Query cirúrgica baseada no seu print do Supabase
        String sql = "INSERT INTO categoria (nome_categoria, porcentagem_meta) VALUES (?, ?)";

   

        try (Connection con = ConexaoBanco.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setBigDecimal(2, categoria.getPorcentagemMeta()); // Mapeando o numeric perfeitamente

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar a categoria no banco de dados!");
            e.printStackTrace();
            return false;
            }
        }
    
public List<Categoria> listar() {
        String sql = "SELECT id_categoria, nome_categoria, porcentagem_meta FROM categoria ORDER BY id_categoria";
        List<Categoria> lista = new ArrayList<>();

        // Usamos executeQuery() aqui porque é um SELECT para buscar dados
        try (Connection con = ConexaoBanco.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Monta o objeto Categoria com o construtor completo que você criou
                Categoria cat = new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("nome_categoria"),
                    rs.getBigDecimal("porcentagem_meta")
                );
                // Adiciona na lista do Java
                lista.add(cat);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar as categorias do banco de dados!");
            e.printStackTrace();
        }

        return lista; // Retorna a lista preenchida
    } // <-- ESSA CHAVE FECHA O MÉTODO LISTAR!

} // <-- ESSA CHAVE FECHA A C