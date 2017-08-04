import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Knut on 04.10.2016.
 */
public class BreddeForSok {

    int N; //antallNoder
    int K; //antallKanter
    Node[] node;

    private String finnNr(Node noden) {
        String nr = "";
        for (int i = 0; i < node.length; i++) {
            if (node[i] == noden) {
                return nr + i;
            }
        }
        return nr + " ";
    }

    public void skrivUtGraf() {
        System.out.println("Node | Forgj | Dist");
        for (int i = 0; i < node.length; i++) {
            System.out.println(i + "    | " + finnNr(((Forgj)node[i].d).finnForgj()) + "     | " + ((Forgj)node[i].d).finnDist());
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

    private void initforgj(Node s) {
        for (int i = N; i-- > 0;) {
            node[i].d = new Forgj();
        }
        ((Forgj)s.d).dist = 0;
    }

    public void bfs(int start) {
        Node s = node[start];
        initforgj(s);
        Ko ko = new Ko(N - 1);
        ko.leggIKo(s);
        while(!ko.tom()) {
            Node n = (Node)ko.nesteIKo();
            for (Kant k = n.kant1; k != null; k = k.neste) {
                Forgj f = (Forgj)k.til.d;
                if (f.dist == f.uendelig) {
                    f.dist = ((Forgj)n.d).dist + 1;
                    f.forgj = n;
                    ko.leggIKo(k.til);
                }
            }
        }
    }
}
