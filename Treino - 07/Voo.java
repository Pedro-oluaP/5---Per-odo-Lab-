//4 - Escreva uma classe em que cada objeto representa um voo que acontece em determinada data e em determinado horário. Cada voo possui no máximo 100 passageiros, e a classe permite controlar a ocupação das vagas. A classe deve ter os seguintes métodos:

import javax.swing.*;

public class Voo {
    private String numeroVoo;
    private Data dataVoo;
    private boolean[] assentos;
    private static final int TOTAL_ASSENTOS = 100;

    // Construtor
    public Voo(String numeroVoo, Data dataVoo) {
        this.numeroVoo = numeroVoo;
        this.dataVoo = dataVoo;
        this.assentos = new boolean[TOTAL_ASSENTOS]; // Inicialmente todos false (livres)
    }

    // Retorna o número do próximo assento livre
    public int proximoLivre() {
        for (int i = 0; i < assentos.length; i++) {
            if (!assentos[i]) {
                return i + 1; // Assentos numerados de 1 a 100
            }
        }
        return -1; // Nenhum assento livre
    }

    // Verifica se um assento específico está ocupado
    public boolean verifica(int numeroAssento) {
        if (numeroAssento < 1 || numeroAssento > TOTAL_ASSENTOS) {
            return false; // Assento inválido
        }
        return assentos[numeroAssento - 1];
    }

    // Ocupa um assento específico
    public boolean ocupa(int numeroAssento) {
        if (numeroAssento < 1 || numeroAssento > TOTAL_ASSENTOS) {
            return false; // Assento inválido
        }

        if (!assentos[numeroAssento - 1]) {
            assentos[numeroAssento - 1] = true;
            return true; // Ocupação bem sucedida
        }
        return false; // Assento já ocupado
    }

    // Retorna o número de assentos vagos
    public int vagas() {
        int contador = 0;
        for (boolean ocupado : assentos) {
            if (!ocupado) {
                contador++;
            }
        }
        return contador;
    }

    // Getters
    public String getVoo() {
        return numeroVoo;
    }

    public Data getData() {
        return dataVoo;
    }

    // Método para exibir informações do voo
    @Override
    public String toString() {
        return "Voo " + numeroVoo + " em " + dataVoo + " (" + vagas() + " vagas disponíveis)";
    }
}