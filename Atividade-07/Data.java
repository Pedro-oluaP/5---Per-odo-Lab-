//2 - Escreva uma classe Data cuja instância (objeto) represente uma data. Esta classe deverá dispor dos seguintes métodos:

import javax.swing.*;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor que verifica se a data é válida
    public Data(int dia, int mes, int ano) {
        if (dataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            // Data inválida, configura como 01/01/0001
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        }
    }

    // Método para verificar se uma data é válida
    private boolean dataValida(int dia, int mes, int ano) {
        if (ano < 1 || mes < 1 || mes > 12 || dia < 1) {
            return false;
        }

        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Verifica ano bissexto (fevereiro tem 29 dias)
        if (mes == 2 && ehBissexto(ano)) {
            return dia <= 29;
        }

        return dia <= diasPorMes[mes - 1];
    }

    // Método para verificar se um ano é bissexto
    private boolean ehBissexto(int ano) {
        return (ano % 400 == 0) || (ano % 100 != 0 && ano % 4 == 0);
    }

    // Método para comparar duas datas
    public int compara(Data outraData) {
        if (this.ano == outraData.ano && this.mes == outraData.mes && this.dia == outraData.dia) {
            return 0;
        }

        if (this.ano > outraData.ano ||
                (this.ano == outraData.ano && this.mes > outraData.mes) ||
                (this.ano == outraData.ano && this.mes == outraData.mes && this.dia > outraData.dia)) {
            return 1;
        }

        return -1;
    }

    // Getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public String getMesExtenso() {
        String[] meses = {
                "Janeiro", "Fevereiro", "Março", "Abril",
                "Maio", "Junho", "Julho", "Agosto",
                "Setembro", "Outubro", "Novembro", "Dezembro"
        };
        return meses[mes - 1];
    }

    public int getAno() {
        return ano;
    }

    // Método toString para representação da data
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}