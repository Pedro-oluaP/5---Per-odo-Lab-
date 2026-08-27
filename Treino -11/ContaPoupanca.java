public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento;
    private int saquesGratuitos;
    private static final int SAQUES_GRATUITOS_POR_MES = 3;

    public ContaPoupanca(String numeroConta, String titular, double saldoInicial, double taxaRendimento) {
        super(numeroConta, titular, saldoInicial);
        this.taxaRendimento = taxaRendimento;
        this.saquesGratuitos = SAQUES_GRATUITOS_POR_MES;
    }

    // Sobrescrita do método sacar
    @Override
    public boolean sacar(double valor) {
        if (saquesGratuitos <= 0) {
            double taxa = valor * 0.01; // 1% de taxa após saques gratuitos
            System.out.println("Taxa de 1% aplicada: R$" + taxa);
            valor += taxa;
        } else {
            saquesGratuitos--;
        }

        return super.sacar(valor);
    }

    @Override
    public void aplicarTaxasOuRendimentos() {
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
        saquesGratuitos = SAQUES_GRATUITOS_POR_MES; // Reset saques gratuitos
        System.out.println("Rendimento de R$" + rendimento + " aplicado à conta.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: Conta Poupança" +
                "\nTaxa de Rendimento: " + (taxaRendimento * 100) + "%" +
                "\nSaques gratuitos restantes: " + saquesGratuitos;
    }
}