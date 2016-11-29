package categoria;

import java.util.ArrayList;

public interface CategoriaInterface {

    void inserir(Categoria c) throws Exception;

    void atualizar(Categoria c) throws Exception;

    void remover(Categoria c) throws Exception;

    ArrayList<Categoria> listar(Categoria filtro) throws Exception;
    
}
