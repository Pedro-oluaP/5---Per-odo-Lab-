import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private final Livro livro;
    private final Professor membro;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataPrevista;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Professor membro) {
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevista = dataEmprestimo.plusDays(membro.getPrazoDias());
        livro.setDisponivel(false);
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
        livro.setDisponivel(true);
    }

    public boolean isAtivo() { return dataDevolucao == null; }
    public Livro getLivro() { return livro; }
    public Professor getMembro() { return membro; }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return livro.getTitulo() + " -> " + membro.getNome()
                + " | Empréstimo: " + dataEmprestimo.format(f)
                + " | Devolução prevista: " + dataPrevista.format(f)
                + " | " + (isAtivo() ? "EM ABERTO" : "Devolvido em " + dataDevolucao.format(f));
    }
}
