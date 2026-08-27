import java.util.Random;

public class Jogo {
    private Time time1;
    private Time time2;
    private int golsTime1;
    private int golsTime2;

    public Jogo(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
        simular();
    }

    public void simular() {
        Random random = new Random();
        this.golsTime1 = random.nextInt(5); // 0 a 4 gols
        this.golsTime2 = random.nextInt(5);

        time1.atualizarEstatisticas(golsTime1, golsTime2);
        time2.atualizarEstatisticas(golsTime2, golsTime1);
    }

    public String getResultado() {
        return time1.getNome() + " " + golsTime1 + " x " + golsTime2 + " " + time2.getNome();
    }

    public boolean equals(Jogo outro) {
        return (this.time1 == outro.time1 && this.time2 == outro.time2) ||
                (this.time1 == outro.time2 && this.time2 == outro.time1);
    }
}