import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Knut on 04.10.2016.
 */
public class TopologiskSortering {
    int N;
    int K;
    Node[] node;

    public String finnNr(Node noden) {
        String nr = "";
        for (int i = 0; i < node.length; i++) {
            if (node[i] == noden) {
                return nr + i;
            }
        }
        return nr + " ";
    }


    public void topsort(String filnavn) {
        lagGrafFraFil(filnavn);
        Node n = topologisort();
        Topo_lst t = (Topo_lst) n.d;
        while (n != null) {
            System.out.println(finnNr(n));
            if(t.neste != null) {
                n = t.neste;
                t = (Topo_lst) n.d;
            } else {
                return;
            }
        }
    }

    public void lagGrafFraFil(String filPlassering) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filPlassering));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            node = new Node[N];

            for (int i = 0; i < N; i++) {
                node[i] = new Node();
            }

            K = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = 0; j < K; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int fra = Integer.parseInt(stringTokenizer.nextToken());
                int til = Integer.parseInt(stringTokenizer.nextToken());
                Kant k = new Kant(node[til], node[fra].kant1);
                node[fra].kant1 = k;
            }
        } catch (IOException ioe) {

        }
    }

    Node df_topo(Node n, Node l) {
        Topo_lst nd = (Topo_lst)n.d;
        if (nd.funnet) {
            return l;
        }

        nd.funnet = true;

        for (Kant k = n.kant1; k != null; k = k.neste) {
            l = df_topo(k.til, l);
        }

        nd.neste = l;
        return n;
    }

    Node topologisort() {
        Node l = null;
        for (int i = N; i-- > 0;) {
            node[i].d = new Topo_lst();
        }
        for (int i = N; i-- > 0;) {
            l = df_topo(node[i], l);
        }
        return l;
    }
}
