/**
 * Created by Knut on 10.10.2016.
 */
public class VKant extends Kant {

    int avstandMellom; //vekten mellom kantene, men i dette tilfellet avstanden mellom to noder

    public VKant(Node n, VKant neste, int avstandMellom) {
        super(n, neste);
        this.avstandMellom = avstandMellom;
    }
}
