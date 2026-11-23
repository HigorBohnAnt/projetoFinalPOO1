public class FolhaPagamento {

    private Funcionario funcionario;
    private double salarioBruto;
    private double descontoINSS;
    private double descontoTransporte;
    private double salarioLiquido;

    public FolhaPagamento(Funcionario funcionario) {

        this.funcionario = funcionario;
        this.salarioBruto = funcionario.getSalario();

        calcularPagamento();
    }

    public void calcularPagamento() {

        descontoINSS = salarioBruto * 0.08;

        descontoTransporte = salarioBruto * 0.06;

        salarioLiquido = salarioBruto - descontoINSS - descontoTransporte;
    }

    public void exibirPagamento() {

        System.out.println("\n===== FOLHA DE PAGAMENTO =====");

        System.out.println("Funcionário: " + funcionario.getNome());

        System.out.println("Cargo: " + funcionario.getCargo());

        System.out.printf("Salário bruto: R$ %.2f%n", salarioBruto);

        System.out.printf("Desconto INSS: R$ %.2f%n", descontoINSS);

        System.out.printf("Vale-transporte: R$ %.2f%n", descontoTransporte);

        System.out.printf("Salário líquido: R$ %.2f%n", salarioLiquido);

        System.out.println("==============================");
    }

    public String salvarPagamento() {

        return funcionario.getId() + ";" +
               funcionario.getNome() + ";" +
               salarioBruto + ";" +
               descontoINSS + ";" +
               descontoTransporte + ";" +
               salarioLiquido;
    }
}
