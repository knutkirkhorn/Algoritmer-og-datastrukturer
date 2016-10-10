/**
 * Created by Knut on 18.09.2016.
 */
public class Hashtabell {

    private final int TABELL_STORRELSE;
    private final int PRIMTALL = 1931;
    private String[] hashTabell;
    private int antallBrukt = 0;
    private int antallKollisjoner = 0;

    public Hashtabell(int storrelse) {
        TABELL_STORRELSE = storrelse;
        hashTabell = new String[storrelse];
    }

    public int gjorOmTilAsciiVerdi(String teksten) {
        int sum = 0;
        for (int i = 0; i < teksten.length(); i++) {
            int no = teksten.charAt(i) * (127 * (i+1));
            sum += no;
        }
        return sum;
    }

    //hash-verdi
    private int hashFunksjon1(int key) {
        return key % TABELL_STORRELSE;
    }

    //steg-størrelse
    private int hashFunksjon2(int key) {
        return key % (TABELL_STORRELSE - 1)+1;
    }

    private int probe(int h1, int h2, int i) {
        return (h1 + i*h2) % TABELL_STORRELSE;
    }

    public int leggInn(String navn) {
        int key = gjorOmTilAsciiVerdi(navn);
        int h1 = hashFunksjon1(key);
        int h2 = hashFunksjon2(key);
        for (int i = 0; i < TABELL_STORRELSE; i++) {
            int j = probe(h1, h2, i);
            if (hashTabell[j] == null) {
                hashTabell[j] = navn;
                antallBrukt++;
                return j;
            } else {
                //For å skrive ut navn som kolliderer med hverandre
                System.out.println(navn + " kolliderer med " + hashTabell[j]);
                antallKollisjoner++;
            }
        }
        return -1; //Dersom tabellen er full returnerer metoden -1
    }

    //Returnerer navn eller null dersom det ikke er noen navn på denne plassen i tabellen
    public String finnNavn(int pos) {
        return hashTabell[pos];
    }

    public int finnPos(String navn) {
        int key = gjorOmTilAsciiVerdi(navn);
        int h1 = hashFunksjon1(key);
        int h2 = hashFunksjon2(key);

        for (int i = 0; i < TABELL_STORRELSE; i++) {
            int j = probe(h1, h2, i);
            if (hashTabell[j] == null) {
                return -1;
            }
            if (hashTabell[j].equals(navn)) {
                return j;
            } else {
                System.out.println(navn + " kolliderer med " + hashTabell[j]);
                antallKollisjoner++;
            }
        }
        return -1;
    }

    public double lastfaktor() {
        return (double)antallBrukt / TABELL_STORRELSE;
    }

    public int getAntallKollisjoner() {
        return antallKollisjoner;
    }
}