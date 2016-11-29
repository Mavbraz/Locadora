package cliente;

import outros.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Herda ConexãoBD e implementa ClienteInterface (contrato)
/*
* Todos tem que ter:
conectar();
String sql = ""; //Comando SQL
try {
PreparedStatement cmd = conn.prepareStatement(sql); //Colocar o sql
//Depois executar...
} catch (SQLException e) {
    //Tratamento do erro com throw new Excetion(messagem);
}
desconectar();
 */
public class ClienteDados extends ConexaoBD implements ClienteInterface {

    @Override
    public void inserir(Cliente c) throws Exception {
        conectar();
        String sql = "INSERT INTO Cliente (CPF, Nome, Sexo, Dt_Nascimento, Telefone, CEP, Logradouro, Numero, Complemento, Bairro, Cidade, UF)";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCpf()); //Serve para trocar a primeiro "?" e colocar o CPF do cliente
            cmd.setString(2, c.getNome()); //setString vai colocar '', então não precisa colocar '?' no sql e pode colocar char no mesmo comando
            cmd.setString(3, c.getSexo() + ""); // + "" para concatenar o char com String e tornar o tipo String
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
            //Tratamento do erro, enviando a throw com essa mensagem para outro lugar, onde vai ser tratada corretamente
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
        String sql = "DELETE FROM Cliente WHERE CPF = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCpf());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao remover. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public boolean verificarCliente(Cliente c) throws Exception {
        boolean existencia = false;
        conectar();
        String sql = "SELECT Nome FROM Cliente WHERE CPF = ?;";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCpf());
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
