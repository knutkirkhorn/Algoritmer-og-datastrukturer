/**
 * Created by Knut on 10.10.2016.
 * Oppgave: http://www.aitel.hist.no/fag/_alg/v-graf/opg-v-graf.pdf
 */

public class Main {
    public static void main(String[] args) {
        String filPlassering = "C:\\Users\\Knut\\Documents\\GitHub\\Algoritmer_og_datastrukturer\\Øving 8\\resources\\graf.txt";
        Dijkstragraf dijkstragraf = new Dijkstragraf(filPlassering);
        dijkstragraf.skrivut();

    }
}
