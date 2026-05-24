
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO {

    public boolean salvar(Movimentacao mov) {
        // SQL correspondente às colunas exatas do seu banco
        String sql = "INSERT INTO movimentacoes (descricao, valor, tipo, data_movimentacao, id_usuario, id_categoria) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConexaoBanco.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, mov.getDescricao());
            stmt.setBigDecimal(2, mov.getValor());
            
            // Convertendo o 'char' do Java para String que o banco aceita no tipo bpchar
            stmt.setString(3, String.valueOf(mov.getTipo()));
            
            // CONVERSÃO DE OURO: Convertendo LocalDate do Java para o Date do JDBC
            stmt.setDate(4, java.sql.Date.valueOf(mov.getDataMovimentacao()));
            
            // Pegando os IDs de dentro dos objetos relacionados!
            stmt.setInt(5, mov.getUsuario().getIdUsuario());     
            stmt.setInt(6, mov.getCategoria().getIdCategoria());   
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar a movimentação no banco de dados!");
            e.printStackTrace();
            return false;
        }
    }
    

    public List<Movimentacao> listar() {
            // Query com JOIN para buscar os dados da movimentação + dados do usuário + dados da categoria
            String sql = "SELECT m.id_movimentacoes, m.descricao, m.valor, m.tipo, m.data_movimentacao, " +
                        "       u.id_usuario, u.nome, u.salario, " +
                        "       c.id_categoria, c.nome_categoria, c.porcentagem_meta " +
                        "FROM movimentacoes m " +
                        "INNER JOIN usuario u ON m.id_usuario = u.id_usuario " +
                        "INNER JOIN categoria c ON m.id_categoria = c.id_categoria " +
                        "ORDER BY m.data_movimentacao DESC";

            List<Movimentacao> lista = new ArrayList<>();

            try (Connection con = ConexaoBanco.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    // 1. Primeiro reconstruímos o Objeto Usuario com os dados que vieram do JOIN
                    Usuario user = new Usuario(
                        rs.getString("nome"),
                        rs.getBigDecimal("salario")
                    );
                    user.setIdUsuario(rs.getInt("id_usuario"));

                    // 2. Depois reconstruímos o Objeto Categoria
                    Categoria cat = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nome_categoria"),
                        rs.getBigDecimal("porcentagem_meta")
                    );

                    // 3. Por fim, montamos a Movimentacao injetando os dois objetos nela!
                    // Lembra que seu construtor aceita o tipo como 'char'
                    char tipoChar = rs.getString("tipo").charAt(0);

                    Movimentacao mov = new Movimentacao(
                        rs.getInt("id_movimentacoes"),
                        rs.getString("descricao"),
                        rs.getBigDecimal("valor"),
                        tipoChar,
                        rs.getDate("data_movimentacao").toLocalDate(), // Converte sql.Date para LocalDate
                        user,
                        cat
                    );

                    lista.add(mov);
                }

            } catch (SQLException e) {
                System.out.println("Erro ao listar as movimentações do banco!");
                e.printStackTrace();
            }

            return lista;
                    
    }
}