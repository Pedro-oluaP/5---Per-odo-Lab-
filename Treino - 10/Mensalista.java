// Subclasse Mensalista
class FuncionarioMensalista extends Funcionario {
    private double salario;

    public FuncionarioMensalista(String nome, String cidade, String estado, int horasTrabalhadas,
                                 Departamento departamento, double salario) {
        super(nome, cidade, estado, horasTrabalhadas, departamento);
        this.salario = salario;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }
}
