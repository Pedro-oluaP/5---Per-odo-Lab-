import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // ---------- Leitura protegida ----------

    private static String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("Entrada inválida: não pode ficar em branco.");
        }
    }

    private static int lerOpcao(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor < min || valor > max) {
                    System.out.println("Opção inválida. Digite um número entre " + min + " e " + max + ".");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
            }
        }
    }

    private static double lerValor(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                // aceita vírgula ou ponto como separador decimal
                double valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
                if (Double.isNaN(valor) || Double.isInfinite(valor)) {
                    System.out.println("Valor inválido.");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um valor numérico (ex.: 150,50).");
            }
        }
    }

    // ---------- Criação da conta ----------

    private static Conta criarConta() {
        System.out.println("=== ABERTURA DE CONTA ===");
        while (true) {
            String titular = lerTexto("Nome do titular: ");
            String banco = lerTexto("Banco: ");
            String agencia = lerTexto("Agência (4 dígitos): ");

            System.out.println("Tipo da conta:");
            int i = 1;
            for (TipoConta t : TipoConta.values()) {
                System.out.println(i++ + " - " + t.getDescricao());
            }
            int opcaoTipo = lerOpcao("Escolha o tipo: ", 1, TipoConta.values().length);
            TipoConta tipo = TipoConta.values()[opcaoTipo - 1];

            try {
                Conta conta = new Conta(titular, banco, agencia, tipo);
                System.out.println("\nConta criada com sucesso!");
                System.out.println(conta);
                return conta;
            } catch (ContaException e) {
                System.out.println("Erro ao criar conta: " + e.getMessage());
                System.out.println("Vamos tentar novamente.\n");
            }
        }
    }

    // ---------- Menu ----------

    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Creditar");
        System.out.println("2 - Debitar");
        System.out.println("3 - Consultar saldo");
        System.out.println("4 - Encerrar conta");
    }

    public static void main(String[] args) {
        Conta conta = criarConta();

        while (conta.isAtiva()) {
            exibirMenu();
            int opcao = lerOpcao("Escolha uma opção: ", 1, 4);

            try {
                switch (opcao) {
                    case 1:
                        double credito = lerValor("Valor a creditar: R$ ");
                        conta.creditar(credito);
                        System.out.printf("Crédito de R$ %.2f realizado.%n", credito);
                        break;
                    case 2:
                        double debito = lerValor("Valor a debitar: R$ ");
                        conta.debitar(debito);
                        System.out.printf("Débito de R$ %.2f realizado.%n", debito);
                        break;
                    case 3:
                        System.out.printf("Saldo atual: R$ %.2f%n", conta.consultarSaldo());
                        break;
                    case 4:
                        String resposta = lerTexto("Tem certeza que deseja encerrar a conta? (S/N): ");
                        if (resposta.equalsIgnoreCase("S")) {
                            conta.encerrar();
                            System.out.println("Conta encerrada com sucesso.");
                        } else {
                            System.out.println("Encerramento cancelado.");
                        }
                        break;
                }
            } catch (ContaException e) {
                System.out.println("Operação não realizada: " + e.getMessage());
            }
        }

        System.out.println("Obrigado por utilizar nosso banco. Programa encerrado.");
        scanner.close();
    }
}