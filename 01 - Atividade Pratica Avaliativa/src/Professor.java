public class Professor extends Membro {
    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int getLimiteEmprestimos() { return 5; }

    @Override
    public int getPrazoDias() { return 14; }

    @Override
    public String getTipo() { return "Professor"; }
}