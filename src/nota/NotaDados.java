package nota;

import bancodados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotaDados extends ConexaoBD implements NotaInterface {

    @Override
    public void inserir(Nota n) throws Exception {
        conectar();
        String sql = "INSERT INTO Nota (Cd_Nota, CPF, Dt_Nota, Hr_Nota, Situacao)";
        sql += "VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, n.getCodigo());
            cmd.setString(2, n.getCliente().getCpf());
            cmd.setString(3, n.getData());
            cmd.setString(4, n.getHorario());
            cmd.setString(5, n.getSituacao());
            cmd.execute();
        } catch (SQLException e) {
            //Tratamento do erro, enviando a throw com essa mensagem para outro lugar, onde vai ser tratada corretamente
            throw new Exception("Erro ao inserir. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void atualizar(Nota n) throws Exception {
        conectar();
        String sql = "UPDATE Nota SET Situacao = ? WHERE Cd_Nota = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, n.getSituacao());
            cmd.setInt(2, n.getCodigo());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void remover(Nota n) throws Exception {
        conectar();
        String sql = "DELETE FROM Nota WHERE Cd_nota = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, n.getCodigo());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public boolean verificarNota(Nota n) throws Exception {
        boolean existencia = false;
        conectar();
        String sql = "SELECT CPF FROM Nota WHERE Cd_Nota = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, n.getCodigo());
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
