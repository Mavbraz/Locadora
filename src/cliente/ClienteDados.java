package cliente;

import bancodados.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDados extends ConexaoBD implements InterfaceCliente{

    @Override
    public void cadastrar(Cliente a) throws Exception {
        conectar();
        String sql = "INSERT INTO CLIENTE (CPF, Nome, Sexo, Dt_Nascimento, Telefone, CEP, Logradouro, Numero, Complemento, Bairro, Cidade, UF)";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, a.getCpf());
            cmd.setString(2, a.getNome());
            cmd.setString(3, a.getSexo() + "");
            cmd.setDate  (4, a.getDataNascimento());
            cmd.setString(5, a.getTelefone());
            cmd.setString(6, a.getCep());
            cmd.setString(7, a.getLogradouro());
            cmd.setInt   (8, a.getNumero());
            cmd.setString(9, a.getComplemento());
            cmd.setString(10, a.getBairro());
            cmd.setString(11, a.getCidade());
            cmd.setString(12, a.getUf());
        
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar. " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void atualizar(Cliente a) throws Exception {
        conectar();
        
        
        
        
        desconectar();
        
        
    
      
    }

    @Override
    public void remover(Cliente a) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
