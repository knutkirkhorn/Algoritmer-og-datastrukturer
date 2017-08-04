/**
 * Created by Knut on 04.10.2016.
 */
public class Forgj {
    int dist;
    Node forgj;
    static int uendelig = 1000000000;

    public Forgj() {
        dist = uendelig;
    }
    public int finnDist() {
        return dist;
    }

    public Node finnForgj() {
        return forgj;
    }
}
