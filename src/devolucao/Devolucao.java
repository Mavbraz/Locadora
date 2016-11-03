package devolucao;

import java.sql.Date;
import java.sql.Time;
import nota.Nota;

public class Devolucao {
    private int codigo;
    private Nota nota;
    private Date data;
    private Time horario;
    private double valor;

    //Getters and setters
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }




}
