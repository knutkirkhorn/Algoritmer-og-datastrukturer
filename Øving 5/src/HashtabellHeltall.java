/**
 * Created by Knut on 21.09.2016.
 */
public class HashtabellHeltall {
    private final int TABELL_STORRELSE;
    private final int PRIMTALL = 1931;
    private int[] hashTabell;
    private int antallBrukt = 0;
    private int antallKollisjoner = 0;

    public HashtabellHeltall(int storrelse) {
        TABELL_STORRELSE = storrelse;
        hashTabell = new int[storrelse];
    }

    //hash-verdi
    private int hashFunksjon1(int key) {
        return key % TABELL_STORRELSE;
    }

    //steg-størrelse
    private int hashFunksjon2(int key) {
        return key % (TABELL_STORRELSE - 1)+1;
    }

    private int probe(int h1, int i) {
        return Math.abs((h1 + i) % TABELL_STORRELSE);
    }

    public int leggInn(int key) {
        int h2 = hashFunksjon2(key);
        for (int i = 0; i < TABELL_STORRELSE; i++) {
            int j = probe(h2, i);
            if(j > -1) {
                if (hashTabell[j] == 0) {
                    hashTabell[j] = key;
                    antallBrukt++;
                    return j;
                } else {
                    //For å skrive ut navn som kolliderer med hverandre
                    //System.out.println(navn + " kolliderer med " + hashTabell[j]);
                    antallKollisjoner++;
                }
            }
        }
        return -1; //Dersom tabellen er full returnerer metoden -1
    }

    public int finnPos(int key) {
        int h1 = hashFunksjon1(key);
        int h2 = hashFunksjon2(key);

        for (int i = 0; i < TABELL_STORRELSE; i++) {
            int j = probe(h1, i);
            if (hashTabell[j] == 0) {
                return -1;
            }
            if (hashTabell[j] == key) {
                return j;
            }
        }
        return -1;
    }

    public int tall(int pos) {
        return hashTabell[pos];
    }
}
