package nota;

public interface NotaInterface {
    //Inserir nota no banco de dados
    void inserir(Nota n) throws Exception;
    //Atualizar nota no banco de dados
    void atualizar(Nota n) throws Exception;
    //Remover nota do banco de dados
    void remover(Nota n) throws Exception;
    //Verificar existência da nota no banco de dados
    boolean verificarNota(Nota n) throws Exception;
}
