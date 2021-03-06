package bicicleta;

import outros.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BicicletaDados extends ConexaoBD implements BicicletaInterface {

    @Override
    public void inserir(Bicicleta b) throws Exception {
        b = putNull(b);
        
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
        b = putNull(b);
        
        conectar();
        String sql = "UPDATE Bicicleta SET Ds_Bicicleta = ?, Ano = ?, Cor = ?, Pneu = ?, CNPJ = ?, Cd_Categoria = ? WHERE Cd_Bicicleta = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, b.getDescricao());
            cmd.setString(2, b.getAno());
            cmd.setString(3, b.getCor());
            cmd.setString(4, b.getPneu());
            cmd.setString(5, b.getFabricante().getCnpj());
            cmd.setInt   (6, b.getCategoria().getCodigo());
            cmd.setInt   (7, b.getCodigo());
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
        String sql = "SELECT B.Cd_Bicicleta, F.CNPJ, F.Nome_Fantasia, F.Razao_Social, C.Cd_Categoria, C.Ds_Categoria, B.Ds_Bicicleta, B.Ano, B.Cor, B.Pneu ";
        sql += "FROM Bicicleta AS B ";
        sql += "INNER JOIN Fabricante AS F ON F.CNPJ = B.CNPJ ";
        sql += "INNER JOIN Categoria AS C ON C.Cd_Categoria = B.Cd_Categoria ";
        sql += "WHERE B.Cd_Bicicleta > 0 ";
        if (filtro.getCodigo() > 0) {
            sql += " AND B.Cd_Bicicleta = ?";
        }
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            if (filtro.getCodigo() > 0) {
                cmd.setInt(position, filtro.getCodigo());
                position += 1;
            }
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Bicicleta b = new Bicicleta();
                b.setCodigo(leitor.getInt("Cd_Bicicleta"));
                b.getFabricante().setCnpj(leitor.getString("CNPJ"));
                b.getFabricante().setNomeFantasia(leitor.getString("Nome_Fantasia"));
                b.getFabricante().setRazaoSocial(leitor.getString("Razao_Social"));
                b.getCategoria().setCodigo(leitor.getInt("Cd_Categoria"));
                b.getCategoria().setDescricao(leitor.getString("Ds_Categoria"));
                b.setDescricao(leitor.getString("Ds_Bicicleta"));
                b.setAno(leitor.getString("Ano"));
                b.setCor(leitor.getString("Cor"));
                b.setPneu(leitor.getString("Pneu"));
                
                b = removeNull(b);
                bicicletas.add(b);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar. " + e.getMessage());
        }
        desconectar();
        return bicicletas;
    }
    
    private Bicicleta putNull(Bicicleta b) {
        if (b.getFabricante().getNomeFantasia().equals("")) {
            b.getFabricante().setNomeFantasia(null);
        }
        return b;
    }
    
    private Bicicleta removeNull(Bicicleta b) {
        if (b.getFabricante().getNomeFantasia().equals("")) {
            b.getFabricante().setNomeFantasia(null);
        }
        return b;
    }
}
