public class Main {
    public static void main(String[] args) {
        // Criando o gerenciador de contas
        GerenciamentoContas gerenciador = new GerenciamentoContas();

        // Criando contas
        ContaCorrente cc1 = new ContaCorrente("12345-6", "João Silva", 1000.0, 2.50, 2);
        ContaPoupanca cp1 = new ContaPoupanca("65432-1", "Maria Souza", 2000.0, 0.005);

        // Adicionando contas ao gerenciador
        gerenciador.adicionarConta(cc1);
        gerenciador.adicionarConta(cp1);

        // Operações de depósito (demonstrando sobrecarga)
        gerenciador.realizarDeposito("12345-6", 500.0);
        Cheque cheque = new Cheque(300.0, "Banco XYZ", "10/05/2023");
        cc1.depositar(cheque); // Chamando diretamente o método sobrecarregado

        // Operações de saque (demonstrando polimorfismo e sobrescrita)
        gerenciador.realizarSaque("12345-6", 200.0); // Conta corrente - taxa aplicada após isenções
        gerenciador.realizarSaque("65432-1", 100.0); // Conta poupança - saque gratuito

        // Transferência entre contas
        gerenciador.realizarTransferencia("12345-6", "65432-1", 150.0);

        // Listando contas
        gerenciador.listarContas();

        // Aplicando taxas/rendimentos mensais
        gerenciador.aplicarTaxasOuRendimentosMensais();

        // Listando contas após aplicação de taxas/rendimentos
        gerenciador.listarContas();

        // Realizando mais saques para demonstrar as taxas
        System.out.println("\nRealizando mais saques para demonstrar taxas:");
        gerenciador.realizarSaque("12345-6", 50.0); // Taxa será aplicada (isenções esgotadas)
        gerenciador.realizarSaque("65432-1", 50.0); // Ainda gratuito
        gerenciador.realizarSaque("65432-1", 50.0); // Ainda gratuito
        gerenciador.realizarSaque("65432-1", 50.0); // Agora com taxa

        // Listando contas novamente
        gerenciador.listarContas();
    }
}