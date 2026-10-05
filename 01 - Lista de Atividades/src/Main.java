public class Main {
    public static void main(String[] args) {
        Heroi h1 = new Heroi("Arthur", "Guerreiro", 1, 100, 15);
        Heroi h2 = new Heroi("Merlin", "Mago", 1, 80, 20);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println();

        h1.atacar(h2);
        h2.atacar(h1);
        h1.subirNivel();

        System.out.println();
        System.out.println(h1);
        System.out.println(h2);
    }
}