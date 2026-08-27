//1 - Escreva uma classe cujos objetos representam alunos matriculados em uma disciplina. Cada objeto dessa classe deve guardar os seguintes dados do aluno:
//
//matrícula
//nome
//2 notas de prova e uma nota de trabalho.
//Cada prova vale 3 pontos e o trabalho vale 4. (10 pontos total)
//
//Escreva os seguintes métodos para esta classe:
//
//notaTotal: calcula a nota total do aluno
//isAprovado: retorna se o aluno foi aprovado ou não (>=60% aprovado e <60% reprovado)

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Criando um aluno
        Aluno aluno1 = new Aluno("2023001", "João Silva", 8.0, 7.5, 9.0);

        // Calculando e exibindo a nota total
        System.out.println("Nota total: " + aluno1.notaTotal());

        // Verificando se o aluno foi aprovado
        if (aluno1.isAprovado()) {
            System.out.println("Aluno aprovado!");
        } else {
            System.out.println("Aluno reprovado.");
        }
    }
}

//2 - Escreva uma classe Data cuja instância (objeto) represente uma data. Esta classe deverá dispor dos seguintes métodos:

//construtor: define a data que determinado objeto representa (através de parâmetro), este
//método verifica se a data está correta, caso não esteja a data é configurada como 01/01/0001
//compara: recebe como parâmetro um outro objeto da Classe data, compare com a data
//corrente e retorne:

//0 se as datas forem iguais;
//1 se a data corrente for maior que a do parâmetro;
//-1 se a data do parâmetro for maior que a corrente.

//getDia: retorna o dia da data
//getMes: retorna o mês da data
//getMesExtenso: retorna o mês da data corrente por extenso
//getAno: retorna o ano da data

public class Main {
    public static void main(String[] args) {
        // Criando algumas datas
        Data data1 = new Data(15, 5, 2023);
        Data data2 = new Data(20, 12, 2022);
        Data dataInvalida = new Data(31, 2, 2023); // Data inválida

        System.out.println("Data 1: " + data1);
        System.out.println("Data 2: " + data2);
        System.out.println("Data inválida (deverá ser 01/01/0001): " + dataInvalida);

        // Testando os métodos
        System.out.println("\nComparação entre data1 e data2: " + data1.compara(data2));
        System.out.println("Dia da data1: " + data1.getDia());
        System.out.println("Mês da data1: " + data1.getMes());
        System.out.println("Mês por extenso da data1: " + data1.getMesExtenso());
        System.out.println("Ano da data1: " + data1.getAno());
    }
}

//3 - Escreva uma classe Hora cuja instância (objeto) represente um horário. Esta classe deverá dispor dos seguintes métodos:

//construtor: define a hora que determinado objeto representa (através de parâmetro), este método verifica se a hora está correta, caso não esteja, a hora é configurada como 00:00:00
//compara: recebe como parâmetro um outro objeto da Classe hora, compare com a hora corrente e retorne:

//0 se os horários forem iguais; ou
//o número de segundos entre uma hora e a outra.

//getHoras: retorna as horas
//getMinutos: retorna os minutos
//getSegundos: retorna os segundos
//displayHora: retorna a hora completa no formato HH:MM:SS

public class Main {
    public static void main(String[] args) {
        // Criando alguns horários
        Hora hora1 = new Hora(14, 30, 15);
        Hora hora2 = new Hora(8, 45, 0);
        Hora horaInvalida = new Hora(25, 70, 80); // Horário inválido

        System.out.println("Hora 1: " + hora1);
        System.out.println("Hora 2: " + hora2);
        System.out.println("Hora inválida (deverá ser 00:00:00): " + horaInvalida);

        // Testando os métodos
        System.out.println("\nComparação entre hora1 e hora2: " + hora1.compara(hora2) + " segundos");
        System.out.println("Horas da hora1: " + hora1.getHoras());
        System.out.println("Minutos da hora1: " + hora1.getMinutos());
        System.out.println("Segundos da hora1: " + hora1.getSegundos());
        System.out.println("Hora formatada: " + hora1.displayHora());
    }
}

//4 - Escreva uma classe em que cada objeto representa um voo que acontece em determinada data e em determinado horário. Cada voo possui no máximo 100 passageiros, e a classe permite controlar a ocupação das vagas. A classe deve ter os seguintes métodos:

//• construtor: configura os dados do voo (recebidos como parâmetro): número do voo e data (para armazenar a data utilize um objeto da classe Data, criada na questão anterior);
//• proximoLivre: retorna o número da próxima cadeira livre
//• verifica: verifica se o número da cadeira recebido como parâmetro está ocupada
//• ocupa: ocupa determinada cadeira do voo, cujo número é recebido como parâmetro, e retorna verdadeiro se a cadeira ainda não estiver ocupada (operação foi bem sucedida) e falso caso contrário
//• vagas: retorna o número de cadeiras vagas disponíveis (não ocupadas) no voo
//• getVoo: retorna o número do voo
//• getData: retorna a data do voo (na forma de objeto)

public class Main {
    public static void main(String[] args) {
        // Criando uma data para o voo
        Data dataPartida = new Data(15, 6, 2023);

        // Criando um voo
        Voo voo1 = new Voo("AZ123", dataPartida);

        System.out.println(voo1);
        System.out.println("Próximo assento livre: " + voo1.proximoLivre());

        // Ocupando alguns assentos
        System.out.println("\nOcupando assento 25: " + voo1.ocupa(25));
        System.out.println("Ocupando assento 30: " + voo1.ocupa(30));
        System.out.println("Tentando ocupar assento 25 novamente: " + voo1.ocupa(25));

        // Verificando assentos
        System.out.println("\nVerificando assento 25: " + voo1.verifica(25));
        System.out.println("Verificando assento 26: " + voo1.verifica(26));

        // Exibindo informações atualizadas
        System.out.println("\n" + voo1);
        System.out.println("Próximo assento livre: " + voo1.proximoLivre());
        System.out.println("Vagas disponíveis: " + voo1.vagas());

        // Acessando dados do voo
        System.out.println("\nNúmero do voo: " + voo1.getVoo());
        System.out.println("Data do voo: " + voo1.getData());
    }
}

//5 - Escreva uma classe NumeroInteiro cuja instância (objeto) represente um número inteiro qualquer. Esta classe deverá dispor dos seguintes métodos:

//construtor: deverão haver dois construtores diferentes:
//Primeiro construtor: sem parâmetros que vai instanciar um objeto com o número 0.
//Segundo construtor: recebe o número que ele vai representar como parâmetro.
//        soma: recebe um outro número como parâmetro e soma com o número sendo representado.
//        subtrai: recebe um outro número como parâmetro e subtrai do número sendo representado.
//        isPrimo: retorna true caso o número seja primo ou false caso não seja.
//        getNextPrimo: retorna o próximo número primo após este que está sendo representado

public class Main {
    public static void main(String[] args) {
        // Testando os construtores
        NumeroInteiro num1 = new NumeroInteiro(); // Usa construtor sem parâmetros
        NumeroInteiro num2 = new NumeroInteiro(7); // Usa construtor com parâmetro

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        // Testando soma e subtração
        num1.soma(num2);
        System.out.println("\nnum1 após somar num2: " + num1);

        num1.subtrai(new NumeroInteiro(3));
        System.out.println("num1 após subtrair 3: " + num1);

        // Testando métodos de números primos
        System.out.println("\nnum2 (7) é primo? " + num2.isPrimo());
        System.out.println("Próximo primo após 7: " + num2.getNextPrimo());

        NumeroInteiro num3 = new NumeroInteiro(20);
        System.out.println("\nnum3 (20) é primo? " + num3.isPrimo());
        System.out.println("Próximo primo após 20: " + num3.getNextPrimo());
    }
}