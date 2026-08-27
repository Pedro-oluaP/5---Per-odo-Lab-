import javax.swing.JOptionPane;

public class TesteDrive {
    public static void main(String[] args) {
 //       System.out.println("hallo world");

//        JOptionPane.showMessageDialog(null, "Hello World");
//        String nome = JOptionPane.showInputDialog(null, "Digite um nome");
//        JOptionPane.showMessageDialog(null, "ola, " + nome + "!");

//        int opcao = JOptionPane.showConfirmDialog(null, "Você venderia sua alma?");
//        if (opcao == JOptionPane.YES_OPTION) {
//            JOptionPane.showConfirmDialog(null, "Agora sua alma é minha, MUHA HAHAHA!");
//        }else {
//            JOptionPane.showConfirmDialog(null, "Poxa... q sem graça...");
//        }

        Carro carro = new Carro("Lotus");
        carro.setCor("Preto com dourado");
        carro.setModelo("Exige S");
//        carro.setMarca("lotus");
        carro.setOrigem(JOptionPane.showInputDialog("Em qual filme Carros ele apareceu: "));

        carro.ligar();
        carro.desligar();

        JOptionPane.showMessageDialog(null, "Cor: " + carro.getCor() + "\nModelo: " + carro.getModelo() + "\nMarca: " + carro.getMarca() + "\nOrigem" + carro.getOrigem());

    }
}