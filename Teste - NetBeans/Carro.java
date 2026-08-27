import javax.swing.*;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private String origem;

    Carro(String marca) {
        this.marca = "Lotus";
//        this.modelo = modelo;
//        this.cor = cor;
//        this.origem = origem;, String modelo, String cor, String origem
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    void ligar() {
        JOptionPane.showConfirmDialog(null, "Ligando...");
    }
    void desligar() {
        JOptionPane.showConfirmDialog(null, "Desligando...");
    }
}
