package bicicleta;

import bancodados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BicicletaDados extends ConexaoBD implements BicicletaInterface {

    @Override
    public void inserir(Bicicleta b) throws Exception {
        conectar();
        String sql = "INSERT INTO Bicicleta (Cd_Bicicleta, CNPJ, Cd_Categoria, Ds_Bicicleta, Ano, Cor, Pneu)";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, b.getCodigo());
            cmd.setString(2, b.getFabricante().getCnpj());
            cmd.setInt(3, b.getCategoria().getCodigo());
            cmd.setString(4, b.getDescricao());
            cmd.setString(5, b.getAno());
            cmd.setString(6, b.getCor());
            cmd.setString(7, b.getPneu());
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
        String sql = "UPDATE Bicicleta SET Ds_Bicicleta = ?, Ano = ?, Cor = ?, Pneu = ? WHERE Cd_Bicicleta = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, b.getDescricao());
            cmd.setString(2, b.getAno());
            cmd.setString(3, b.getCor());
            cmd.setString(4, b.getPneu());
            cmd.setInt(5, b.getCodigo());
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
    public ArrayList<Bicicleta> listar(Bicicleta filtro) throws Exception {
        int position = 1;
        ArrayList<Bicicleta> bicicletas = new ArrayList<>();
        conectar();
        String sql = "SELECT Cd_Bicicleta, CNPJ, Cd_Categoria, Ds_Bicicleta, Ano, Cor, Pneu FROM Bicicleta WHERE Cd_Bicicleta > 0";
        if (filtro.getCodigo() > 0) {
            sql += " AND Cd_Bicicleta = ?";
        }
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            if (filtro.getCodigo() > 0) {
                cmd.setInt(position++, filtro.getCodigo());
            }
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Bicicleta b = new Bicicleta();
                b.setCodigo(leitor.getInt("Cd_Bicicleta"));
                b.getFabricante().setCnpj(leitor.getString("CNPJ"));
                b.getCategoria().setCodigo(leitor.getInt("Cd_Categoria"));
                b.setDescricao(leitor.getString("Ds_Bicicleta"));
                b.setAno(leitor.getString("Ano"));
                b.setCor(leitor.getString("Cor"));
                b.setPneu(leitor.getString("Pneu"));
                bicicletas.add(b);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao verificar. " + e.getMessage());
        }
        desconectar();
        return bicicletas;
    }

    @Override
    public boolean verificarBicicleta(Bicicleta b) throws Exception {
        boolean existencia = false;
        conectar();
        String sql = "SELECT NULL FROM Bicicleta WHERE Cd_Bicicleta = ?;";
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
