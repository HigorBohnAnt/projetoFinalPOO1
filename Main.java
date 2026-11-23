import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

        int opcao;

        do {

            System.out.println("       SISTEMA DE RH");
            System.out.println("     FOLHA DE PAGAMENTO");

            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Buscar funcionário");
            System.out.println("4 - Atualizar funcionário");
            System.out.println("5 - Excluir funcionário");
            System.out.println("6 - Calcular folha de pagamento");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\nCADASTRAR FUNCIONÁRIO");

                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("CPF: ");
                    String cpf = entrada.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = entrada.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = entrada.nextLine();

                    System.out.print("Salário: ");
                    double salario = entrada.nextDouble();
                    entrada.nextLine();

                    Funcionario novo = new Funcionario(
                        gerenciador.gerarId(),
                        nome,
                        cpf,
                        telefone,
                        cargo,
                        salario
                    );

                    gerenciador.cadastrar(novo);

                    break;

                case 2:

                    System.out.println("\nLISTA DE FUNCIONÁRIOS");

                    gerenciador.listar();

                    break;

                case 3:

                    System.out.print("Digite o ID do funcionário: ");

                    int idBusca = entrada.nextInt();
                    entrada.nextLine();

                    Funcionario encontrado = gerenciador.buscar(idBusca);

                    if (encontrado != null) {

                        encontrado.exibirDados();

                    } else {

                        System.out.println("Funcionário não encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Digite o ID do funcionário: ");

                    int idAtualizar = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = entrada.nextLine();

                    System.out.print("Novo CPF: ");
                    String novoCpf = entrada.nextLine();

                    System.out.print("Novo telefone: ");
                    String novoTelefone = entrada.nextLine();

                    System.out.print("Novo cargo: ");
                    String novoCargo = entrada.nextLine();

                    System.out.print("Novo salário: ");
                    double novoSalario = entrada.nextDouble();
                    entrada.nextLine();

                    gerenciador.atualizar(
                        idAtualizar,
                        novoNome,
                        novoCpf,
                        novoTelefone,
                        novoCargo,
                        novoSalario
                    );

                    break;

                case 5:

                    System.out.print("Digite o ID do funcionário: ");

                    int idExcluir = entrada.nextInt();
                    entrada.nextLine();

                    gerenciador.excluir(idExcluir);

                    break;

                case 6:

                    System.out.print("Digite o ID do funcionário: ");

                    int idPagamento = entrada.nextInt();
                    entrada.nextLine();

                    Funcionario funcionario = gerenciador.buscar(idPagamento);

                    if (funcionario != null) {

                        FolhaPagamento folha = new FolhaPagamento(funcionario);

                        folha.exibirPagamento();

                        Arquivo.salvarPagamento(folha.salvarPagamento());

                    } else {

                        System.out.println("Funcionário não encontrado.");
                    }

                    break;

                case 0:

                    System.out.println("Sistema encerrado!");

                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}
