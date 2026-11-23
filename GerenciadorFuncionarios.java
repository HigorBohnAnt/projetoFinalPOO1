import java.util.ArrayList;

public class GerenciadorFuncionarios {

    private ArrayList<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {

        funcionarios = Arquivo.carregarFuncionarios();
    }

    public void cadastrar(Funcionario funcionario) {

        funcionarios.add(funcionario);

        Arquivo.salvarFuncionarios(funcionarios);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void listar() {

        if (funcionarios.isEmpty()) {

            System.out.println("Nenhum funcionário cadastrado.");

            return;
        }

        for (Funcionario f : funcionarios) {

            f.exibirDados();
        }
    }

    public Funcionario buscar(int id) {

        for (Funcionario f : funcionarios) {

            if (f.getId() == id) {

                return f;
            }
        }

        return null;
    }

    public void atualizar(int id, String nome, String cpf,
                          String telefone, String cargo, double salario) {

        Funcionario f = buscar(id);

        if (f != null) {

            f.setNome(nome);
            f.setCpf(cpf);
            f.setTelefone(telefone);
            f.setCargo(cargo);
            f.setSalario(salario);

            Arquivo.salvarFuncionarios(funcionarios);

            System.out.println("Funcionário atualizado com sucesso!");

        } else {

            System.out.println("Funcionário não encontrado.");
        }
    }

    public void excluir(int id) {

        Funcionario f = buscar(id);

        if (f != null) {

            funcionarios.remove(f);

            Arquivo.salvarFuncionarios(funcionarios);

            System.out.println("Funcionário removido com sucesso!");

        } else {

            System.out.println("Funcionário não encontrado.");
        }
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public int gerarId() {

        int maiorId = 0;

        for (Funcionario f : funcionarios) {

            if (f.getId() > maiorId) {

                maiorId = f.getId();
            }
        }

        return maiorId + 1;
    }
}
