public class Departamento {

    private int id;
    private String nome;

    public Departamento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void exibirDepartamento() {
        System.out.println("Departamento: " + nome);
    }
}
