import java.util.ArrayList;
import java.util.List;

// Classe base Departamento
class Departamento {
    private String descricao;
    private double valorHora;
    private List<Funcionario> funcionarios;

    public Departamento(String descricao, double valorHora) {
        this.descricao = descricao;
        this.valorHora = valorHora;
        this.funcionarios = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void listarSalarios() {
        System.out.println("\nDepartamento: " + descricao);
        System.out.println("Funcionários e seus salários:");

        for (Funcionario f : funcionarios) {
            System.out.printf("- %s: R$ %.2f%n", f.getNome(), f.calcularSalario());
        }

        System.out.printf("Total de salários: R$ %.2f%n", getTotalSalarios());
    }

    public double getTotalSalarios() {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalario();
        }
        return total;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}

