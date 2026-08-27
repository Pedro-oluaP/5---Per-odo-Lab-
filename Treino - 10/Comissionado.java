// Subclasse Comissionado
class FuncionarioComissionado extends Funcionario {
    private double valorVendas;
    private double percentualComissao;

    public FuncionarioComissionado(String nome, String cidade, String estado, int horasTrabalhadas,
                                   Departamento departamento, double valorVendas, double percentualComissao) {
        super(nome, cidade, estado, horasTrabalhadas, departamento);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularSalario() {
        return valorVendas * (percentualComissao / 100);
    }
}