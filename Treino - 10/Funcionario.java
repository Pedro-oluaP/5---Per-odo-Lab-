// Classe abstrata Funcionario
abstract class Funcionario {
    private String nome;
    private String cidade;
    private String estado;
    private int horasTrabalhadas;
    private Departamento departamento;

    public Funcionario(String nome, String cidade, String estado, int horasTrabalhadas, Departamento departamento) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.horasTrabalhadas = horasTrabalhadas;
        this.departamento = departamento;
        departamento.addFuncionario(this);
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public abstract double calcularSalario();
}

