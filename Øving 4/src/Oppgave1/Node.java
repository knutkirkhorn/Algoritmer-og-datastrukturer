package Oppgave1;

/**
 * Created by Knut on 12.09.2016.
 */
public class Node {

    private double element;
    Node forrige;
    Node neste;

    public Node(double element, Node neste, Node forrige) {
        this.element = element;
        this.forrige = forrige;
        this.neste = neste;
    }

    public double finnElement() {
        return element;
    }

    public Node finnForrige() {
        return forrige;
    }

    public Node finnNeste() {
        return neste;
    }
}
