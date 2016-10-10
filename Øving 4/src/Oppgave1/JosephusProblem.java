package Oppgave1;

/**
 * Created by Knut on 12.09.2016.
 */
public class JosephusProblem {

    private DobbeltLenketSirkListe dl;

    public JosephusProblem(DobbeltLenketSirkListe dl) {
        this.dl = dl;
    }

    public JosephusProblem() {
        dl = new DobbeltLenketSirkListe();
    }

    public DobbeltLenketSirkListe finnDl() {
        return dl;
    }

    public void genererTabell(int antallPersoner) {
        for (int i = 0; i < antallPersoner; i++) {
            dl.settInnBakerst(i + 1);
        }
    }

    public double finnOverlevendePerson(int start, int intervall) {
        Node fjerning = dl.finnNr(start).forrige;

        while (dl.finnAntall() > 1) {
            for (int i = 0; i < intervall; i++) {
                fjerning = fjerning.neste;
            }

            Node backUp = fjerning.neste;
            dl.fjern(fjerning);
            fjerning = backUp.forrige;
        }

        return dl.finnNr(0).finnElement();
    }
}
