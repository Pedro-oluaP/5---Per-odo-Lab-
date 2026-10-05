public abstract class Membro {
    private static int proximoId = 1;

    private final int id;
    private String nome;

    public Membro(String nome) {
        this.id = proximoId++;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }

    // Cada tipo de membro define suas próprias regras (polimorfismo)
    public abstract int getLimiteEmprestimos();
    public abstract int getPrazoDias();
    public abstract String getTipo();

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " (" + getTipo() + ")";
    }
}
