package nota;

/* Anotações, criar a classe Cliente cliente.
 */
import cliente.Cliente;
import java.sql.Date;
import java.sql.Time;

public class Nota {

    private int codigo;
    private Cliente cliente;
    private Date data;
    private Time horario;
    private char situacao;

    public Nota(int codigo, Date data, Time horario, char situacao) {
        this.codigo = codigo;
        this.cliente = new Cliente();
        this.data = data;
        this.horario = horario;
        this.situacao = situacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
}
