import java.util.ArrayList;
import java.util.List;

public class GerenciamentoContas {
    private List<ContaBancaria> contas;

    public GerenciamentoContas() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
        System.out.println("Conta " + conta.getNumeroConta() + " adicionada com sucesso.");
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void realizarDeposito(String numeroConta, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void realizarSaque(String numeroConta, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void realizarTransferencia(String contaOrigem, String contaDestino, double valor) {
        ContaBancaria origem = buscarConta(contaOrigem);
        ContaBancaria destino = buscarConta(contaDestino);

        if (origem != null && destino != null) {
            origem.transferir(valor, destino);
        } else {
            System.out.println("Conta(s) não encontrada(s).");
        }
    }

    public void listarContas() {
        System.out.println("\n===== LISTA DE CONTAS =====");
        for (ContaBancaria conta : contas) {
            System.out.println(conta);
            System.out.println("-------------------------");
        }
    }

    public void aplicarTaxasOuRendimentosMensais() {
        System.out.println("\nAplicando taxas/rendimentos mensais...");
        for (ContaBancaria conta : contas) {
            conta.aplicarTaxasOuRendimentos();
        }
    }
}
