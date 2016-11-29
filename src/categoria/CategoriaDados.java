package categoria;

import outros.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDados extends ConexaoBD implements CategoriaInterface {

    @Override
    public void inserir(Categoria c) throws Exception {
        conectar();
        String sql = "INSERT INTO Categoria (Cd_Categoria, Ds_Categoria)";
        sql += "VALUES (?, ?);";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, c.getCodigo());
            cmd.setString(2, c.getDescricao());
            cmd.execute();
        } catch (SQLException e) {
            //Tratamento do erro, enviando a throw com essa mensagem para outro lugar, onde vai ser tratada corretamente
            throw new Exception("Erro ao inserir. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void atualizar(Categoria c) throws Exception {
        conectar();
        String sql = "UPDATE Categoria SET Ds_Categoria = ? WHERE Cd_Categoria = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getDescricao());
            cmd.setInt   (2, c.getCodigo());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void remover(Categoria c) throws Exception {
        conectar();
        String sql = "DELETE FROM Categoria WHERE Cd_Categoria = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, c.getCodigo());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public ArrayList<Categoria> listar(Categoria filtro) throws Exception {
        int position = 1;
        ArrayList<Categoria> categorias = new ArrayList<>();

        conectar();
        String sql = "SELECT Cd_Categoria, Ds_Categoria FROM Categoria WHERE Cd_Categoria > 0";
        if (filtro.getCodigo() > 0) {
            sql += " AND Cd_Categoria = ?";
        }
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            if (filtro.getCodigo() > 0) {
                cmd.setInt(position, filtro.getCodigo());
                position += 1;
            }
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Categoria c = new Categoria();
                c.setCodigo(leitor.getInt("Cd_Categoria"));
                c.setDescricao(leitor.getString("Ds_Categoria"));

                categorias.add(c);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar. " + e.getMessage());
        }
        desconectar();

        return categorias;
    }

}
