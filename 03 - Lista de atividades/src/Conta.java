public class Conta {
    private static int proximoNumero = 1001;

    private final int numero;
    private final String titular;
    private final String banco;
    private final String agencia;
    private final TipoConta tipo;
    private double saldo;
    private boolean ativa;

    public Conta(String titular, String banco, String agencia, TipoConta tipo) throws ContaException {
        if (titular == null || titular.trim().isEmpty()) {
            throw new ContaException("O nome do titular não pode ser vazio.");
        }
        if (banco == null || banco.trim().isEmpty()) {
            throw new ContaException("O nome do banco não pode ser vazio.");
        }
        if (agencia == null || !agencia.matches("\\d{4}")) {
            throw new ContaException("A agência deve ter exatamente 4 dígitos numéricos.");
        }
        if (tipo == null) {
            throw new ContaException("O tipo da conta é obrigatório.");
        }
        this.numero = proximoNumero++;
        this.titular = titular.trim();
        this.banco = banco.trim();
        this.agencia = agencia;
        this.tipo = tipo;
        this.saldo = 0.0;
        this.ativa = true;
    }

    private void verificarAtiva() throws ContaException {
        if (!ativa) {
            throw new ContaException("Esta conta está encerrada.");
        }
    }

    public void creditar(double valor) throws ContaException {
        verificarAtiva();
        if (valor <= 0) {
            throw new ContaException("O valor do crédito deve ser maior que zero.");
        }
        saldo += valor;
    }

    public void debitar(double valor) throws ContaException {
        verificarAtiva();
        if (valor <= 0) {
            throw new ContaException("O valor do débito deve ser maior que zero.");
        }
        if (valor > saldo) {
            throw new ContaException(String.format(
                    "Saldo insuficiente. Saldo atual: R$ %.2f", saldo));
        }
        saldo -= valor;
    }

    public double consultarSaldo() throws ContaException {
        verificarAtiva();
        return saldo;
    }

    public void encerrar() throws ContaException {
        verificarAtiva();
        if (saldo > 0) {
            throw new ContaException(String.format(
                    "Não é possível encerrar com saldo positivo (R$ %.2f). Retire o valor antes.", saldo));
        }
        ativa = false;
    }

    public boolean isAtiva() { return ativa; }

    @Override
    public String toString() {
        return "Banco: " + banco + " | Agência: " + agencia + " | Conta: " + numero
                + " | Tipo: " + tipo.getDescricao() + " | Titular: " + titular;
    }
}