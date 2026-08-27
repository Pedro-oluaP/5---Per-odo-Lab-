//3 - Escreva uma classe Hora cuja instância (objeto) represente um horário. Esta classe deverá dispor dos seguintes métodos:

import javax.swing.*;

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    // Construtor que verifica se o horário é válido
    public Hora(int horas, int minutos, int segundos) {
        if (horaValida(horas, minutos, segundos)) {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        } else {
            // Horário inválido, configura como 00:00:00
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
        }
    }

    // Método para verificar se um horário é válido
    private boolean horaValida(int horas, int minutos, int segundos) {
        return horas >= 0 && horas < 24 &&
                minutos >= 0 && minutos < 60 &&
                segundos >= 0 && segundos < 60;
    }

    // Método para comparar dois horários
    public int compara(Hora outraHora) {
        int segundosThis = this.horas * 3600 + this.minutos * 60 + this.segundos;
        int segundosOutra = outraHora.horas * 3600 + outraHora.minutos * 60 + outraHora.segundos;

        if (segundosThis == segundosOutra) {
            return 0;
        }

        return segundosThis - segundosOutra;
    }

    // Getters
    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    // Método para exibir a hora formatada
    public String displayHora() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    // Método toString para representação do horário
    @Override
    public String toString() {
        return displayHora();
    }
}