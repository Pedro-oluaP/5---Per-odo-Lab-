public class ContaCorrente extends ContaBancaria {
    private double taxaOperacao;
    private int operacoesIsentas;

    public ContaCorrente(String numeroConta, String titular, double saldoInicial,
                         double taxaOperacao, int operacoesIsentas) {
        super(numeroConta, titular, saldoInicial);
        this.taxaOperacao = taxaOperacao;
        this.operacoesIsentas = operacoesIsentas;
    }

    // Sobrescrita do método sacar
    @Override
    public boolean sacar(double valor) {
        double valorTotal = valor;

        if (operacoesIsentas <= 0) {
            valorTotal += taxaOperacao;
            System.out.println("Taxa de operação de R$" + taxaOperacao + " aplicada.");
        } else {
            operacoesIsentas--;
        }

        return super.sacar(valorTotal);
    }

    @Override
    public void aplicarTaxasOuRendimentos() {
        // Conta corrente não tem rendimentos, apenas zera operações isentas
        operacoesIsentas = 2; // Reset para 2 operações isentas no próximo mês
        System.out.println("Operações isentas resetadas para o próximo mês.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: Conta Corrente" +
                "\nTaxa de Operação: R$" + taxaOperacao +
                "\nOperações isentas restantes: " + operacoesIsentas;
    }
}