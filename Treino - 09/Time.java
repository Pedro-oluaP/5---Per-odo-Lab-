public class Time {
    private String nome;
    private int totalJogos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;
    private int golsMarcados;
    private int golsSofridos;
    private int saldoGols;

    public Time(String nome) {
        this.nome = nome;
        this.totalJogos = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.pontos = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
        this.saldoGols = 0;
    }

    public void atualizarEstatisticas(int golsMarcados, int golsSofridos) {
        this.totalJogos++;
        this.golsMarcados += golsMarcados;
        this.golsSofridos += golsSofridos;
        this.saldoGols = this.golsMarcados - this.golsSofridos;

        if (golsMarcados > golsSofridos) {
            this.vitorias++;
            this.pontos += 3;
        } else if (golsMarcados == golsSofridos) {
            this.empates++;
            this.pontos += 1;
        } else {
            this.derrotas++;
        }
    }

    // Getters
    public String getNome() { return nome; }
    public int getTotalJogos() { return totalJogos; }
    public int getVitorias() { return vitorias; }
    public int getEmpates() { return empates; }
    public int getDerrotas() { return derrotas; }
    public int getPontos() { return pontos; }
    public int getGolsMarcados() { return golsMarcados; }
    public int getGolsSofridos() { return golsSofridos; }
    public int getSaldoGols() { return saldoGols; }
}
