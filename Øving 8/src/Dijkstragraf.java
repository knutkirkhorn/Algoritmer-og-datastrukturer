import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Knut on 10.10.2016.
 */
public class Dijkstragraf {

    private int N; //antall noder
    private int K; //antall kanter
    private Node[] node;
    private Heap heap;

    public Dijkstragraf(String filPlassering) {
        lagGrafFraFil(filPlassering);
    }

    private void lagGrafFraFil(String filPlassering) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filPlassering));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            node = new Node[N];

            for (int i = 0; i < N; i++) {
                node[i] = new Node();
                node[i].tall = i;
            }

            K = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = 0;  j < K; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int fra = Integer.parseInt(stringTokenizer.nextToken());
                int til = Integer.parseInt(stringTokenizer.nextToken());
                int vekt = Integer.parseInt(stringTokenizer.nextToken());
                VKant vKant = new VKant(node[til], (VKant)node[fra].kant1, vekt);
                node[fra].kant1 = vKant;
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void skrivut() {
        System.out.println("TEST:");
        System.out.println("Node | Forgjenger | Distanse");

        /*for(Node n : node) {
            //System.out.println(n.d + "..." + n.kant1.neste);
            //System.out.print("" + n.tall);
        }*/

        for (int i = 0; i < N; i++) {
            //System.out.println(node[i].tall + "    " + node[i].kant1.til.tall);
            System.out.println(node[i].tall);
        }
    }

    private void initforgj(Node s) {
        for (int i = N; i-- > 0;) {
            node[i].d = new Forgj();
        }
        ((Forgj)s.d).dist = 0;
    }

    private int hent_min() {
        int min = node[0];
        node[0] = node[--len];
        fiks_heap(0);
        return min;
    }


    private void dijkstra(Node s) {
        initforgj(s);
        Node[] pri = new Node[N];
        lag_priko(pri);
        for (int i = N; i > 1; --i) {
            Node n = hent_min(i, pri);
            for (VKant k = (VKant)n.kant1; k != null; k = (VKant)k.neste) {
                forkort(n, k);
            }
        }
    }
}
