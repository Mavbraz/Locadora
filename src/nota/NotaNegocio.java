package nota;

public class NotaNegocio implements NotaInterface {

    @Override
    public void inserir(Nota n) throws Exception {
        if (n.getCodigo() < 1) {
            throw new Exception("Código inválido.");
        }

        if (n.getCliente().getCpf().replaceAll(" ", "").length() < 14) {
            throw new Exception("CPF inválido.");
        }

        if (n.getData().replaceAll(" ", "").length() < 10) {
            throw new Exception("Data inválida.");
        }

        if (n.getHorario().replaceAll(" ", "").length() < 5) {
            throw new Exception("Horário inválido.");
        }

        NotaDados dados = new NotaDados();
        dados.inserir(n);
    }

    @Override
    public void atualizar(Nota n) throws Exception {
        if (n.getCodigo() < 1) {
            throw new Exception("Código inválido.");
        }

        NotaDados dados = new NotaDados();
        dados.atualizar(n);
    }

    @Override
    public void remover(Nota n) throws Exception {
        if (n.getCodigo() < 1) {
            throw new Exception("Código inválido.");
        }

        NotaDados dados = new NotaDados();
        dados.remover(n);
    }

    @Override
    public boolean verificarNota(Nota n) throws Exception {
        if (n.getCodigo() < 1) {
            throw new Exception("Código inválido.");
        }

        NotaDados dados = new NotaDados();
        return dados.verificarNota(n);
    }
}
