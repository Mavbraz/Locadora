package cliente;

public interface InterfaceCliente {
    //Cadastrar cliente no banco de dados
    void cadastrar(Cliente a) throws Exception;
    //Atualizar cliente no banco de dados
    void atualizar(Cliente a) throws Exception;
    //Remover cliente no banco de dados
    void remover(Cliente a) throws Exception;
}
