package Oppgave1;

/**
 * Created by Knut on 12.09.2016.
 */
public class Iterator {

    private Node plass;

    public Iterator(DobbeltLenketSirkListe dl) {
        plass = dl.finnHode();
    }

    public boolean slutt() {
        return (plass == null);
    }

    public double finnElement() {
        if (!slutt()) {
            return plass.finnElement();
        } else {
            return Double.NaN;
        }
    }

    public void neste() {
        if (!slutt()) {
            plass = plass.finnNeste();
        }
    }
}
