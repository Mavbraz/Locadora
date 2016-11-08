package cliente;

public class ClienteNegocio implements ClienteInterface {

    @Override
    public void inserir(Cliente c) throws Exception {
        //Validações cadastrar
        //Não utilizei .trim() porque queria remover todos os espaços e não apenas o do início e fim
        if (c.getCpf().replaceAll(" ", "").length() < 14) {
            throw new Exception("CPF inválido.");
        }

        if (c.getNome().equals("")) {
            throw new Exception("Nome inválido.");
        }

        if (c.getDataNascimento().replaceAll(" ", "").length() < 10) {
            throw new Exception("Data de nascimento inválida.");
        }

        if (c.getTelefone().replaceAll(" ", "").length() < 13) {
            throw new Exception("Telefone inválido.");
        }

        if (c.getCep().replaceAll(" ", "").length() < 10) {
            throw new Exception("CEP não encontrado.");
        }

        if (c.getLogradouro().equals("")) {
            throw new Exception("Logradouro não pode ser vazio.");
        }

        if (c.getNumero() < 1) {
            throw new Exception("Número inválido.");
        }

        if (c.getBairro().equals("")) {
            throw new Exception("Bairro inválido.");
        }

        if (c.getCidade().equals("")) {
            throw new Exception("Cidade inválida.");
        }

        ClienteDados dados = new ClienteDados();
        dados.inserir(c);
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        if (c.getCpf().replaceAll(" ", "").length() < 14) {
            throw new Exception("CPF inválido.");
        }

        if (c.getNome().equals("")) {
            throw new Exception("Nome inválido.");
        }

        if (c.getTelefone().replaceAll(" ", "").length() < 13) {
            throw new Exception("Telefone inválido.");
        }

        if (c.getCep().replaceAll(" ", "").length() < 10) {
            throw new Exception("CEP não encontrado.");
        }

        if (c.getLogradouro().equals("")) {
            throw new Exception("Logradouro não pode ser vazio.");
        }

        if (c.getNumero() < 1) {
            throw new Exception("Número inválido.");
        }

        if (c.getBairro().equals("")) {
            throw new Exception("Bairro inválido.");
        }

        if (c.getCidade().equals("")) {
            throw new Exception("Cidade inválida.");
        }

        ClienteDados dados = new ClienteDados();
        dados.atualizar(c);
    }

    @Override
    public void remover(Cliente c) throws Exception {
        if (c.getCpf().replaceAll(" ", "").length() < 14) {
            throw new Exception("CPF inválido.");
        }

        ClienteDados dados = new ClienteDados();
        dados.remover(c);
    }

    @Override
    public boolean verificarCliente(Cliente c) throws Exception {
        if (c.getCpf().replaceAll(" ", "").length() < 14) {
            throw new Exception("CPF inválido.");
        }

        ClienteDados dados = new ClienteDados();
        return dados.verificarCliente(c);
    }

}
