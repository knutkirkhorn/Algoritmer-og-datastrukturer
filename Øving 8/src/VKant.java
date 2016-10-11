/**
 * Created by Knut on 10.10.2016.
 */
public class VKant extends Kant {

    int avstand; //vekten mellom kantene, men i dette tilfellet avstanden

    public VKant(Node n, VKant neste, int avstand) {
        super(n, neste);
        this.avstand = avstand;
    }
}
