public class Heroi {
    private String nome;
    private String classe;
    private int nivel;
    private int vida;
    private int ataque;

    public Heroi(String nome, String classe, int nivel, int vida, int ataque) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void atacar(Heroi alvo) {
        System.out.println(nome + " ataca " + alvo.nome + " causando " + ataque + " de dano!");
        alvo.receberDano(ataque);
    }

    public void receberDano(int dano) {
        vida = Math.max(0, vida - dano);
        if (vida == 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }

    public void subirNivel() {
        nivel++;
        vida += 10;
        ataque += 2;
        System.out.println(nome + " subiu para o nível " + nivel + "!");
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }

    @Override
    public String toString() {
        return "Herói: " + nome + " | Classe: " + classe + " | Nível: " + nivel
                + " | Vida: " + vida + " | Ataque: " + ataque;
    }
}