// Subclasse Horista
class FuncionarioHorista extends Funcionario {
    public FuncionarioHorista(String nome, String cidade, String estado, int horasTrabalhadas,
                              Departamento departamento) {
        super(nome, cidade, estado, horasTrabalhadas, departamento);
    }

    @Override
    public double calcularSalario() {
        return getHorasTrabalhadas() * getDepartamento().getValorHora();
    }
}
