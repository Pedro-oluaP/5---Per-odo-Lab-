import java.text.DecimalFormat;

public abstract class ContaBancaria {
    protected String numeroConta;
    protected String titular;
    protected double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Métodos de depósito (sobrecarga)
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito em dinheiro de R$" + df.format(valor) + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void depositar(Cheque cheque) {
        if (cheque.getValor() > 0) {
            saldo += cheque.getValor();
            System.out.println("Depósito por cheque de R$" + df.format(cheque.getValor()) + " realizado com sucesso.");
        } else {
            System.out.println("Valor de cheque inválido.");
        }
    }

    // Método de saque (será sobrescrito nas classes filhas)
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + df.format(valor) + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    // Método de transferência
    public void transferir(double valor, ContaBancaria destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$" + df.format(valor) + " para conta " + destino.getNumeroConta() + " realizada.");
        }
    }

    // Método abstrato para aplicar regras específicas no final do mês
    public abstract void aplicarTaxasOuRendimentos();

    // Getters
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta: " + numeroConta +
                "\nTitular: " + titular +
                "\nSaldo: R$" + df.format(saldo);
    }
}
