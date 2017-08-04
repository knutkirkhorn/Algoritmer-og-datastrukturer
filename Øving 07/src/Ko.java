/**
 * Created by Knut on 05.10.2016.
 */
public class Ko {

    private Object[] tab;
    private int start = 0;
    private int slutt = 0;
    private int antall = 0;

    public Ko(int storrelse) {
        tab = new Object[storrelse];
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean full() {
        return antall == tab.length;
    }

    public void leggIKo(Object e) {
        if (full()) {
            return;
        }

        tab[slutt] = e;
        slutt = (slutt + 1)%tab.length;
        ++antall;
    }

    public Object nesteIKo() {
        if (!tom()) {
            Object e = tab[start];
            start = (start + 1)%tab.length;
            --antall;
            return e;
        } else {
            return null;
        }
    }

    public Object sjekkKo() {
        if (!tom()) {
            return tab[start];
        } else {
            return null;
        }
    }
}
