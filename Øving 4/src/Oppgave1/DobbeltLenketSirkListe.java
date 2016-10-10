package Oppgave1;

/**
 * Created by Knut on 12.09.2016.
 */
public class DobbeltLenketSirkListe {

    private Node hode = null;
    private Node hale = null;
    private int antElementer = 0;

    public int finnAntall() {
        return antElementer;
    }

    public Node finnHode() {
        return hode;
    }

    public Node finnHale() {
        return hale;
    }

    public void settInnFremst(double verdi) {
        hode = new Node(verdi, hode, null);

        if (hale == null) {
            hale = hode;
        } else {
            hode.neste.forrige = hode;
        }

        hode.forrige = hale;

        antElementer++;
    }

    public void settInnBakerst(double verdi) {
        Node ny = new Node(verdi, null, hale);
        if (hale != null) {
            hale.neste = ny;
        } else {
            hode = ny;
        }
        hale = ny;
        ny.neste = hode;
        hode.forrige = ny;

        antElementer++;
    }

    public Node fjern(Node n) {
        if (n.forrige != null) {
            n.forrige.neste = n.neste;
        } else {
            hode = n.neste;
        }

        if (n.neste != null) {
            n.neste.forrige = n.forrige;
        } else {
            hale = n.forrige;
        }

        if (n == hode) {
            hode = n.neste;
        } else if (n == hale){
            hale = n.forrige;
        }

        n.neste = null;
        n.forrige = null;

        antElementer--;
        return n;
    }

    public Node fjern(int i) {
        return fjern(finnNr(i));
    }

    public Node finnNr(int nr) {
        Node denne = hode;
        if (nr < antElementer) {
            for (int i = 0; i < nr; i++) {
                denne = denne.neste;
            }
            return denne;
        } else {
            return null;
        }
    }

    public void slettAlle() {
        hode = null;
        antElementer = 0;
    }
}
