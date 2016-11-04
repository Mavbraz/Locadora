package cliente;

public interface InterfaceCliente {
    //Cadastrar cliente no banco de dados
    void cadastrar(Cliente c) throws Exception;
    //Atualizar cliente no banco de dados
    void atualizar(Cliente c) throws Exception;
    //Remover cliente no banco de dados
    void remover(Cliente c) throws Exception;
}
