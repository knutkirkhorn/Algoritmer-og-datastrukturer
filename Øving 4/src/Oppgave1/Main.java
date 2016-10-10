package Oppgave1;

/**
 * Created by Knut on 12.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        /*double[] tabell = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //{1, 2, 3, 7, 8, 9};
        DobbeltLenketSirkListe dl = new DobbeltLenketSirkListe();

        for (int i = 0; i < tabell.length; i++) {
            dl.settInnBakerst(tabell[i]);
        }


        Oppgave1.Iterator iterator = new Oppgave1.Iterator(dl);

        while (!iterator.slutt()) {
            System.out.println(iterator.finnElement());
            iterator.neste();
        }*/

        /*for(int i = 0; i < dl.finnAntall(); i++) {
            System.out.println(dl.finnNr(i).finnElement());
        }

        dl.fiks();*/

        JosephusProblem josephusProblem = new JosephusProblem();
        josephusProblem.genererTabell(10);

        /*for(int i = 0; i < josephusProblem.finnDl().finnAntall(); i++) {
            System.out.println(josephusProblem.finnDl().finnNr(i).finnElement());
        }*/

        System.out.println(josephusProblem.finnOverlevendePerson(0, 4));
    }
}
