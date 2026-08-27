import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class Campeonato {
    private ArrayList<Time> times;
    private ArrayList<Jogo> jogos;

    public Campeonato() {
        times = new ArrayList<>();
        jogos = new ArrayList<>();
    }

    public void cadastrarTime(String nome) {
        if (times.size() >= 10) {
            EntradaSaida.exibirMensagem("Limite de 10 times atingido!");
            return;
        }
        times.add(new Time(nome));
    }

    public void simularJogo() {
        if (times.size() < 2) {
            EntradaSaida.exibirMensagem("É necessário ter pelo menos 2 times cadastrados!");
            return;
        }

        if (jogos.size() == (times.size() * (times.size() - 1)) / 2) {
            mostrarCampeoes();
            return;
        }

        StringBuilder sb = new StringBuilder("Times disponíveis:\n");
        for (int i = 0; i < times.size(); i++) {
            sb.append((i+1) + " - " + times.get(i).getNome() + "\n");
        }

        int index1 = EntradaSaida.lerInteiro(sb.toString() + "\nEscolha o número do primeiro time:") - 1;
        int index2 = EntradaSaida.lerInteiro("Escolha o número do segundo time:") - 1;

        if (index1 < 0 || index1 >= times.size() || index2 < 0 || index2 >= times.size() || index1 == index2) {
            EntradaSaida.exibirMensagem("Seleção inválida de times!");
            return;
        }

        Time time1 = times.get(index1);
        Time time2 = times.get(index2);

        Jogo novoJogo = new Jogo(time1, time2);
        for (Jogo jogo : jogos) {
            if (jogo.equals(novoJogo)) {
                EntradaSaida.exibirMensagem("Este jogo já foi realizado! Escolha outra dupla de times.");
                return;
            }
        }

        jogos.add(novoJogo);
        EntradaSaida.exibirMensagem("Resultado: " + novoJogo.getResultado());
        mostrarTabela();
    }

    public void mostrarTabela() {
        times.sort(Comparator.comparing(Time::getPontos).reversed()
                .thenComparing(Comparator.comparing(Time::getSaldoGols).reversed()));

        System.out.println("\nTabela do Campeonato:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("| %-20s | %4s | %4s | %4s | %4s | %4s | %4s | %4s | %4s |\n",
                "Nome do Time", "Jogos", "Vit", "Emp", "Der", "Pontos", "GM", "GS", "SG");
        System.out.println("-----------------------------------------------------------------------------");

        for (Time time : times) {
            System.out.printf("| %-20s | %4d | %4d | %4d | %4d | %4d | %4d | %4d | %4d |\n",
                    time.getNome(), time.getTotalJogos(), time.getVitorias(),
                    time.getEmpates(), time.getDerrotas(), time.getPontos(),
                    time.getGolsMarcados(), time.getGolsSofridos(), time.getSaldoGols());
        }
        System.out.println("-----------------------------------------------------------------------------\n");
    }

    public void mostrarCampeoes() {
        if (times.isEmpty()) return;

        times.sort(Comparator.comparing(Time::getPontos).reversed()
                .thenComparing(Comparator.comparing(Time::getSaldoGols).reversed()));

        ArrayList<Time> campeoes = new ArrayList<>();
        int maxPontos = times.get(0).getPontos();
        int maxSaldo = times.get(0).getSaldoGols();

        for (Time time : times) {
            if (time.getPontos() == maxPontos && time.getSaldoGols() == maxSaldo) {
                campeoes.add(time);
            } else {
                break;
            }
        }

        if (campeoes.size() == 1) {
            EntradaSaida.exibirMensagem("O campeão é: " + campeoes.get(0).getNome() + "!");
        } else {
            StringBuilder sb = new StringBuilder("Os campeões são:\n");
            for (Time time : campeoes) {
                sb.append("- ").append(time.getNome()).append("\n");
            }
            EntradaSaida.exibirMensagem(sb.toString());
        }
    }
}
