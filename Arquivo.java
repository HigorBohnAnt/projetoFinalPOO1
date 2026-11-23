import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    public static void salvarFuncionarios(ArrayList<Funcionario> funcionarios) {

        try {

            File pasta = new File("dados");
            pasta.mkdirs();

            FileWriter arquivo = new FileWriter("dados/funcionarios.txt");

            for (Funcionario f : funcionarios) {

                arquivo.write(
                    f.getId() + ";" +
                    f.getNome() + ";" +
                    f.getCpf() + ";" +
                    f.getTelefone() + ";" +
                    f.getCargo() + ";" +
                    f.getSalario() + "\n"
                );
            }

            arquivo.close();

        } catch (IOException e) {

            System.out.println("Erro ao salvar funcionários.");
        }
    }

    public static ArrayList<Funcionario> carregarFuncionarios() {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        File arquivo = new File("dados/funcionarios.txt");

        if (!arquivo.exists()) {
            return funcionarios;
        }

        try {

            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] dados = linha.split(";");

                Funcionario f = new Funcionario(
                    Integer.parseInt(dados[0]),
                    dados[1],
                    dados[2],
                    dados[3],
                    dados[4],
                    Double.parseDouble(dados[5])
                );

                funcionarios.add(f);
            }

            leitor.close();

        } catch (IOException e) {

            System.out.println("Erro ao carregar funcionários.");

        }

        return funcionarios;
    }

    public static void salvarPagamento(String pagamento) {

        try {

            File pasta = new File("dados");
            pasta.mkdirs();

            FileWriter arquivo = new FileWriter("dados/pagamentos.txt", true);

            arquivo.write(pagamento + "\n");

            arquivo.close();

        } catch (IOException e) {

            System.out.println("Erro ao salvar pagamento.");
        }
    }
}
