public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(new Livro("Dom Casmurro", "Machado de Assis"));
        biblioteca.cadastrarLivro(new Livro("O Cortiço", "Aluísio Azevedo"));
        biblioteca.cadastrarLivro(new Livro("Vidas Secas", "Graciliano Ramos"));
        biblioteca.cadastrarLivro(new Livro("Capitães da Areia", "Jorge Amado"));

        biblioteca.cadastrarMembro(new Aluno("Ana"));
        biblioteca.cadastrarMembro(new Professor("Carlos"));

        biblioteca.listarLivros();
        biblioteca.listarMembros();
        System.out.println();

        try {
            biblioteca.emprestar(1, 1);
            biblioteca.emprestar(2, 1);
            biblioteca.emprestar(3, 1);
            biblioteca.emprestar(4, 1); // Ana (Aluno) excede o limite de 3
        } catch (BibliotecaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            biblioteca.emprestar(1, 2); // livro 1 já está emprestado
        } catch (BibliotecaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            biblioteca.devolver(1);
            biblioteca.emprestar(1, 2); // agora o professor consegue
        } catch (BibliotecaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();
        biblioteca.listarLivros();
        biblioteca.listarEmprestimos();
    }
}