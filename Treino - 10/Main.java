import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal do sistema
public class Main {
    private static List<Departamento> departamentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nSistema de Gestão de Departamentos e Funcionários");
            System.out.println("1. Cadastrar Departamento");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Listar Salários por Departamento");
            System.out.println("4. Listar Salários de Todos Departamentos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarDepartamento();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    listarSalariosDepartamento();
                    break;
                case 4:
                    listarTodosSalarios();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void cadastrarDepartamento() {
        System.out.println("\nCadastro de Departamento");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor da hora trabalhada: ");
        double valorHora = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        Departamento departamento = new Departamento(descricao, valorHora);
        departamentos.add(departamento);

        System.out.println("Departamento cadastrado com sucesso!");
    }

    private static void cadastrarFuncionario() {
        if (departamentos.isEmpty()) {
            System.out.println("Não há departamentos cadastrados. Cadastre um departamento primeiro.");
            return;
        }

        System.out.println("\nCadastro de Funcionário");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("Quantidade de horas trabalhadas: ");
        int horasTrabalhadas = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        System.out.println("Departamentos disponíveis:");
        for (int i = 0; i < departamentos.size(); i++) {
            System.out.println((i + 1) + ". " + departamentos.get(i).getDescricao());
        }
        System.out.print("Escolha o departamento: ");
        int deptIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer

        if (deptIndex < 0 || deptIndex >= departamentos.size()) {
            System.out.println("Departamento inválido!");
            return;
        }

        Departamento departamento = departamentos.get(deptIndex);

        System.out.println("Tipo de funcionário:");
        System.out.println("1. Mensalista");
        System.out.println("2. Horista");
        System.out.println("3. Comissionado");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        Funcionario funcionario = null;

        switch (tipo) {
            case 1:
                System.out.print("Salário: ");
                double salario = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                funcionario = new FuncionarioMensalista(nome, cidade, estado, horasTrabalhadas, departamento, salario);
                break;
            case 2:
                funcionario = new FuncionarioHorista(nome, cidade, estado, horasTrabalhadas, departamento);
                break;
            case 3:
                System.out.print("Valor das vendas: ");
                double valorVendas = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                System.out.print("Percentual de comissão (%): ");
                double percentual = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                funcionario = new FuncionarioComissionado(nome, cidade, estado, horasTrabalhadas, departamento, valorVendas, percentual);
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void listarSalariosDepartamento() {
        if (departamentos.isEmpty()) {
            System.out.println("Não há departamentos cadastrados.");
            return;
        }

        System.out.println("\nDepartamentos disponíveis:");
        for (int i = 0; i < departamentos.size(); i++) {
            System.out.println((i + 1) + ". " + departamentos.get(i).getDescricao());
        }
        System.out.print("Escolha o departamento: ");
        int deptIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer

        if (deptIndex < 0 || deptIndex >= departamentos.size()) {
            System.out.println("Departamento inválido!");
            return;
        }

        departamentos.get(deptIndex).listarSalarios();
    }

    private static void listarTodosSalarios() {
        if (departamentos.isEmpty()) {
            System.out.println("Não há departamentos cadastrados.");
            return;
        }

        System.out.println("\nSalários de Todos os Departamentos");
        double totalGeral = 0;

        for (Departamento dept : departamentos) {
            dept.listarSalarios();
            totalGeral += dept.getTotalSalarios();
        }

        System.out.printf("\nTotal geral de salários: R$ %.2f%n", totalGeral);
    }
}