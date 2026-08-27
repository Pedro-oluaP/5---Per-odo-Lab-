//5 - Escreva uma classe NumeroInteiro cuja instância (objeto) represente um número inteiro qualquer. Esta classe deverá dispor dos seguintes métodos:

import javax.swing.*;

public class NumeroInteiro {
    private int numero;

    // Primeiro construtor - sem parâmetros (inicializa com 0)
    public NumeroInteiro() {
        this.numero = 0;
    }

    // Segundo construtor - com parâmetro
    public NumeroInteiro(int numero) {
        this.numero = numero;
    }

    // Método para somar outro número
    public void soma(NumeroInteiro outroNumero) {
        this.numero += outroNumero.numero;
    }

    // Método para subtrair outro número
    public void subtrai(NumeroInteiro outroNumero) {
        this.numero -= outroNumero.numero;
    }

    // Método para verificar se o número é primo
    public boolean isPrimo() {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para obter o próximo número primo
    public int getNextPrimo() {
        if (numero < 2) {
            return 2;
        }

        int candidato = numero + 1;
        while (true) {
            if (ehPrimo(candidato)) {
                return candidato;
            }
            candidato++;
        }
    }

    // Método auxiliar para verificar se um número é primo
    private boolean ehPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Getter para o número
    public int getNumero() {
        return numero;
    }

    // Setter para o número
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return String.valueOf(numero);
    }
}
