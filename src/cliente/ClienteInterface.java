package cliente;

//Contrato para ser utilizado em Cliente
public interface ClienteInterface {
    //Cadastrar cliente no banco de dados
    void inserir(Cliente c) throws Exception;
    //Atualizar cliente no banco de dados
    void atualizar(Cliente c) throws Exception;
    //Remover cliente do banco de dados
    void remover(Cliente c) throws Exception;
    //Verificar existência do cliente no banco de dados
    boolean verificarCliente(Cliente c) throws Exception;
}
