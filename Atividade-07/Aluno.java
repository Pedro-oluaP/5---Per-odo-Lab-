//1 - Escreva uma classe cujos objetos representam alunos matriculados em uma disciplina. Cada objeto dessa classe deve guardar os seguintes dados do aluno:

import javax.swing.*;

public class Aluno {
    // Atributos
    private String matricula;
    private String nome;
    private double notaProva1;
    private double notaProva2;
    private double notaTrabalho;

    // Constantes para pesos das notas
    private static final double PESO_PROVA = 3.0;
    private static final double PESO_TRABALHO = 4.0;
    private static final double NOTA_MAXIMA = 10.0;
    private static final double PERCENTUAL_APROVACAO = 0.6; // 60%

    // Construtor
    public Aluno(String matricula, String nome, double notaProva1, double notaProva2, double notaTrabalho) {
        this.matricula = matricula;
        this.nome = nome;
        this.notaProva1 = notaProva1;
        this.notaProva2 = notaProva2;
        this.notaTrabalho = notaTrabalho;
    }

    // Método para calcular a nota total
    public double notaTotal() {
        // Calcula a nota ponderada (cada prova vale 3 e o trabalho vale 4)
        double total = (notaProva1 * PESO_PROVA) +
                (notaProva2 * PESO_PROVA) +
                (notaTrabalho * PESO_TRABALHO);

        // Retorna a nota em relação ao máximo (10 pontos)
        return (total / (2 * PESO_PROVA + PESO_TRABALHO)) * NOTA_MAXIMA;
    }

    // Método para verificar se o aluno foi aprovado
    public boolean isAprovado() {
        return notaTotal() >= (NOTA_MAXIMA * PERCENTUAL_APROVACAO);
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaProva1() {
        return notaProva1;
    }

    public void setNotaProva1(double notaProva1) {
        this.notaProva1 = notaProva1;
    }

    public double getNotaProva2() {
        return notaProva2;
    }

    public void setNotaProva2(double notaProva2) {
        this.notaProva2 = notaProva2;
    }

    public double getNotaTrabalho() {
        return notaTrabalho;
    }

    public void setNotaTrabalho(double notaTrabalho) {
        this.notaTrabalho = notaTrabalho;
    }
}