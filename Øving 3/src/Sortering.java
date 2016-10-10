import java.util.Random;

/**
 * Created by Knut on 31.08.2016.
 * Sorteringsklasse som inneholder metodene for de ulike sorteringene i de ulike oppgavene.
 * Flere av disse sorteringsmetodene er hentet fra læreboken (Algoritmer og datastrukturer, Helge Hafting og Mildrid Ljosland)
 */
public class Sortering {

    public Sortering() {

    }

    /**
     * Metode for å lage en tabell med gitt lengde, maksimumsverdi og minimumsverdi, som legger inn tilfeldige tall.
     * @return en tabell med tilfeldige tall
     */
    public int[] genererTilfeldigTallTabell(int minimumsVerdi, int maksimumsVerdi, int lengde) {
        int[] tabell = new int[lengde];
        Random random = new Random();
        for(int i = 0; i < lengde; i++) {
            int nyttTilfeldigTall = random.nextInt(maksimumsVerdi - minimumsVerdi) + minimumsVerdi;
            tabell[i] = nyttTilfeldigTall;
        }
        return tabell;
    }

    /**
     * Sjekker om en gitt tabell er sortert eller ikke.
     * Metoden går igjennom tabellen og sjekker om neste verdi er større enn forrige.
     * @param tabell er tabellen man sjekker verdier for.
     * @return true hvis den er sortert, og false dersom ikke.
     */
    public boolean erSortert(int[] tabell) {
        for(int i = 0; i < tabell.length - 1; i++) {
            if (tabell[i + 1] < tabell[i]) {
                return false;
            }
        }
        return true; //Dersom koden kjører så langt så er den sortert.
    }

    /**
     * Sorteringsoppgave 1, quicksort med hjelpealgoritme
     * Hjelpealgoritme som brukes her er shellsort, shellsort brukes dersom tabellen kommer under en gitt verdi.
     */
    public void quicksortMedHjelpeAlgoritme(int[] tabell, int v, int h) { //, int deling) {

        /*int deling = 2;

        if (tabell.length > 10000) {
            deling = tabell.length / 500;
        } else if (tabell.length < 10000 && tabell.length > 500){
            deling = 200; //?????
        }*/

        //deling  == 20 000

        if ((h - v) > 25000) {//deling) { //20 000 ga best resultat med lengde 10 000 000, dvs: 1/500
            int delepos = splitt(tabell, v, h);
            quicksortMedHjelpeAlgoritme(tabell, v, delepos - 1);
            quicksortMedHjelpeAlgoritme(tabell, delepos + 1, h);
        } else {
            //annen metode
            //median3sort(tabell, v, h);
            shellSort(tabell, v, h);
        }
    }

    private void shellSort(int[] t, int fra, int til) {
        int s = fra + (til - fra) / 2; //Dersom fra ikke var lagt til før parantesen så sorterte den ikke skikkelig.
        while (s > 0) {
            for (int i = s + fra; i < til + 1; i++) {
                int j = i;
                int flytt = t[i];

                while(j >= (fra + s) && flytt < t[j - s]) {
                    t[j] = t[j - s];
                    j -= s;
                }
                t[j] = flytt;
            }
            if (s == 2) {
                s = 1;
            } else {
                s = (int) (s/ 2.2);
            }
        }
    }

    private int splitt(int[] tabell, int v, int h) {
        int iv, ih;
        int m = median3sort(tabell, v, h);
        int dv = tabell[m];
        bytt(tabell, m, h - 1);

        for (iv = v, ih = h - 1;;) {
            while(tabell[++iv] < dv);
            while(tabell[--ih] > dv);
            if (iv >= ih) {
                break;
            }
            bytt(tabell, iv, ih);
        }
        bytt(tabell, iv, h - 1);
        return iv;
    }

    private void bytt(int[] tabell, int i, int j) {
        int k = tabell[j];
        tabell[j] = tabell[i];
        tabell[i] = k;
    }

    private int median3sort(int[] tabell, int v, int h) {
        int m = (v + h) / 2;
        if (tabell[v] > tabell[m]) {
            bytt(tabell, v, m);
        }

        if(tabell[m] > tabell[h]) {
            bytt(tabell, m, h);
            if (tabell[v] > tabell[m]) {
                bytt(tabell, v, m);
            }
        }
        return m;
    }
}
