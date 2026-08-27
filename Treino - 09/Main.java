public class Main {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();

        while (true) {
            int opcao = EntradaSaida.lerInteiro(
                    "Menu:\n" +
                            "1 - Cadastrar Times\n" +
                            "2 - Simular Jogos\n" +
                            "3 - Sair\n" +
                            "Escolha uma opção:");

            switch (opcao) {
                case 1:
                    String nomeTime = EntradaSaida.lerString("Digite o nome do time:");
                    campeonato.cadastrarTime(nomeTime);
                    break;
                case 2:
                    campeonato.simularJogo();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    EntradaSaida.exibirMensagem("Opção inválida!");
            }
        }
    }
}