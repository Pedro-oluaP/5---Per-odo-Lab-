public class Aluno extends Professor {
    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public int getLimiteEmprestimos() { return 3; }

    @Override
    public int getPrazoDias() { return 7; }

    @Override
    public String getTipo() { return "Aluno"; }
}
