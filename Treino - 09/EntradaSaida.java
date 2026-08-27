import javax.swing.JOptionPane;

public class EntradaSaida {
    public static int lerInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
            } catch (NumberFormatException e) {
                exibirMensagem("Valor inválido! Digite um número inteiro.");
            }
        }
    }

    public static String lerString(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
            } catch (NumberFormatException e) {
                exibirMensagem("Valor inválido! Digite um número.");
            }
        }
    }

    public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
