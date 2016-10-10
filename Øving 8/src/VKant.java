/**
 * Created by Knut on 10.10.2016.
 */
public class VKant extends Kant {

    int vekt;

    public VKant(Node n, VKant neste, int vekt) {
        super(n, neste);
        this.vekt = vekt;
    }
}
