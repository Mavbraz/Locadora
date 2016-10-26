package categoria;

public class Categoria {
    private int codigo;
    private String descricao;

    //Construtor
    public Categoria(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //Getters and setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
