import java.util.Date;

/**
 * Created by Knut on 30.08.2016.
 * Øving 3 - Avansert sortering
 */
public class Main {

    public static void main(String[] args) {
        Sortering sortering = new Sortering();

        int antallGjennomganger = 1000;
        //For å lage en tilfeldig tabell:
        int minsteTall = 10;
        int storsteTall = 100;
        int tabellLengde = 100000;


        //int[] tabell = new int[]{3, 4, 2, 3};//sortering.genererTilfeldigTallTabell(10, 100, 100); //Tabell som skal sorteres
        int[] tilfeldigTabell = sortering.genererTilfeldigTallTabell(minsteTall, storsteTall, tabellLengde); //Tabell som skal sorteres
        int[] tabell = new int[tilfeldigTabell.length]; //deklarerer den bare for at den ikke skal lage error senere i koden.

        Date startDate = new Date();
        Date endDate;

        for(int i = 0; i < antallGjennomganger; i++) {
            tabell = tilfeldigTabell;
            sortering.quicksortMedHjelpeAlgoritme(tabell, 0, tabell.length - 1);
        }
        endDate = new Date();

        System.out.println((endDate.getTime() - startDate.getTime()) / antallGjennomganger);

        /*int[] t2 = sortering.quicksortMedHjelpeAlgoritme(tabell, 0, tabell.length);
        for(int i = 0; i < t2.length; i++) {
            System.out.println(t2[i]);
        }*/
        /*sortering.bytt(tabell, 1, 3);*/
        /*for(int i = 0; i < tabell.length; i++) {
            System.out.println(tabell[i]);
        }//*/
        System.out.println(sortering.erSortert(tabell));
        //finnBesteDelingsTall();
    }

    private static int finnBesteDelingsTall() { //Fungerer ikke helt som den skal
        int slutt = 100000; //100 000
        int hopp = 1000;
        int antallGjennomganger = 100;
        int minsteTall = 10;
        int storsteTall = 100;
        int tabellLengde = 10000;

        int besteTall = 1000;
        long tall = 100000;

        Sortering sortering = new Sortering();
        int[] tilfeldigTabell = sortering.genererTilfeldigTallTabell(minsteTall, storsteTall, tabellLengde);

        for (int i = 1; i < 21; i++) {

            int[] tabell = tilfeldigTabell;
            Date starttime = new Date();
            Date endTime;
            for (int j = 0; j < 1000; j++) {
                sortering.quicksortMedHjelpeAlgoritme(tabell, 0, tabell.length - 1); //, i * 5000);
            }
            endTime = new Date();
            long gjennomForingsTid = (endTime.getTime() - starttime.getTime()) / 1000;

            if (tall >= gjennomForingsTid) {
                tall = gjennomForingsTid;
                besteTall = i * 5000;
            }
            System.out.println("_____________");
            System.out.println(besteTall);
            System.out.println(tall);
        }
        System.out.println("Beste tall: " + besteTall + ", tall: " + tall);
        return besteTall;
    }
}
