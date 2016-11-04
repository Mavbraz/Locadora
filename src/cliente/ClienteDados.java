package cliente;

import bancodados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDados extends ConexaoBD implements InterfaceCliente {

    @Override
    public void cadastrar(Cliente c) throws Exception {
        conectar();
        String sql = "INSERT INTO Cliente (CPF, Nome, Sexo, Dt_Nascimento, Telefone, CEP, Logradouro, Numero, Complemento, Bairro, Cidade, UF)";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCpf());
            cmd.setString(2, c.getNome());
            cmd.setString(3, c.getSexo() + "");
            cmd.setString(4, c.getDataNascimento());
            cmd.setString(5, c.getTelefone());
            cmd.setString(6, c.getCep());
            cmd.setString(7, c.getLogradouro());
            cmd.setInt(8, c.getNumero());
            cmd.setString(9, c.getComplemento());
            cmd.setString(10, c.getBairro());
            cmd.setString(11, c.getCidade());
            cmd.setString(12, c.getUf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao cadastrar. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        conectar();
        String sql = "UPDATE Cliente SET Nome = ?, Telefone = ?, CEP = ?, Logradouro = ?, Numero = ?, Complemento = ?, Bairro = ?, Cidade = ?, UF = ? WHERE CPF = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getNome());
            cmd.setString(2, c.getTelefone());
            cmd.setString(3, c.getCep());
            cmd.setString(4, c.getLogradouro());
            cmd.setInt(5, c.getNumero());
            cmd.setString(6, c.getComplemento());
            cmd.setString(7, c.getBairro());
            cmd.setString(8, c.getCidade());
            cmd.setString(9, c.getUf());
            cmd.setString(10, c.getCpf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void remover(Cliente c) throws Exception {
        conectar();
        String sql = "DELETE FROM Cliente WHERE CPF = ?";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCpf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover. " + e.getMessage());
        }
        desconectar();
    }
}
