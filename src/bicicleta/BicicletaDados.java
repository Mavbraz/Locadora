package bicicleta;

import bancodados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BicicletaDados extends ConexaoBD implements BicicletaInterface {

    @Override
    public void inserir(Bicicleta b) throws Exception {
        conectar();
        String sql = "INSERT INTO Bicicleta (Cd_Bicicleta, CNPJ, Cd_ categoria, Ds_Bicicleta, Ano, Pneu)";
        sql += "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, b.getCodigo());
            cmd.setString(2, b.getFabricante().getCnpj());
            cmd.setInt(3, b.getCategoria().getCodigo());
            cmd.setString(4, b.getDescricao());
            cmd.setString(5, b.getAno());
            cmd.setString(6, b.getPneu());
            cmd.execute();
        } catch (SQLException e) {
            //Tratamento do erro, enviando a throw com essa mensagem para outro lugar, onde vai ser tratada corretamente
            throw new Exception("Erro ao inserir. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void atualizar(Bicicleta b) throws Exception {
        conectar();
        String sql = "UPDATE Nota SET Ds_Bicicleta, Ano, Cor, Pneu = ? WHERE Cd_Bicicleta = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, b.getDescricao());
            cmd.setString(2, b.getAno());
            cmd.setString(3, b.getCor());
            cmd.setString(4, b.getPneu());

            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar. " + e.getMessage());
        }
        desconectar();

    }

    @Override
    public void remover(Bicicleta b) throws Exception {
        conectar();
        String sql = "DELETE FROM Bicicleta WHERE Cd_Bicicleta = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, b.getCodigo());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void listar() throws Exception {

    }

    @Override
    public boolean verificarBicicleta(Bicicleta b) throws Exception {
        boolean existencia = false;
        conectar();
        String sql = "SELECT Codigo FROM Bicicleta WHERE Cd_Bicicleta = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, b.getCodigo());
            ResultSet leitor = cmd.executeQuery();
            if (leitor.next()) {
                existencia = true;
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao verificar. " + e.getMessage());
        }
        desconectar();
        return existencia;
    }
}
