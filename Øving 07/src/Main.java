/**
 * Created by Knut on 04.10.2016.
 */
public class Main {

    //http://www.aitel.hist.no/fag/_alg/uv-graf/opg-uv-graf.pdf
    public static void main(String[] args) {
        System.out.println("Oppgave 1");
        BreddeForSok breddeForSok = new BreddeForSok();
        breddeForSok.lagGrafFraFil("C:\\Users\\Knut\\Documents\\algdat\\L7g1.txt");
        breddeForSok.bfs(5);
        breddeForSok.skrivUtGraf();

        System.out.println("---------------------------");
        System.out.println("Oppgave 2");
        TopologiskSortering topologiskListe = new TopologiskSortering();
        topologiskListe.topsort("C:\\Users\\Knut\\Documents\\algdat\\L7g5.txt");
    }
}
