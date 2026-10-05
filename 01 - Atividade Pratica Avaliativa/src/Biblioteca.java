import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Professor> membros = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarMembro(Professor membro) {
        membros.add(membro);
    }

    public Livro buscarLivro(int id) throws BibliotecaException {
        for (Livro l : livros) {
            if (l.getId() == id) return l;
        }
        throw new BibliotecaException("Livro " + id + " não encontrado.");
    }

    public Professor buscarMembro(int id) throws BibliotecaException {
        for (Professor m : membros) {
            if (m.getId() == id) return m;
        }
        throw new BibliotecaException("Membro " + id + " não encontrado.");
    }

    private int contarEmprestimosAtivos(Professor membro) {
        int total = 0;
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getMembro() == membro) total++;
        }
        return total;
    }

    public void emprestar(int idLivro, int idMembro) throws BibliotecaException {
        Livro livro = buscarLivro(idLivro);
        Professor membro = buscarMembro(idMembro);

        if (!livro.isDisponivel()) {
            throw new BibliotecaException("O livro \"" + livro.getTitulo() + "\" já está emprestado.");
        }
        if (contarEmprestimosAtivos(membro) >= membro.getLimiteEmprestimos()) {
            throw new BibliotecaException(membro.getNome() + " atingiu o limite de "
                    + membro.getLimiteEmprestimos() + " empréstimos.");
        }

        Emprestimo emprestimo = new Emprestimo(livro, membro);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo realizado: " + emprestimo);
    }

    public void devolver(int idLivro) throws BibliotecaException {
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getLivro().getId() == idLivro) {
                e.devolver();
                System.out.println("Devolução realizada: " + e);
                return;
            }
        }
        throw new BibliotecaException("Não há empréstimo em aberto para o livro " + idLivro + ".");
    }

    public void listarLivros() {
        System.out.println("=== LIVROS ===");
        for (Livro l : livros) System.out.println(l);
    }

    public void listarMembros() {
        System.out.println("=== MEMBROS ===");
        for (Professor m : membros) System.out.println(m);
    }

    public void listarEmprestimos() {
        System.out.println("=== EMPRÉSTIMOS ===");
        for (Emprestimo e : emprestimos) System.out.println(e);
    }
}