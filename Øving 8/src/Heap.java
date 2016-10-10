/**
 * Created by Knut on 10.10.2016.
 */
public class Heap {
    int len;
    int[] node;

    int over(int i) {
        return (i - 1) >> 1;
    }

    int venstre(int i) {
        return (i << 1) + 1;
    }

    int hoyre(int i) {
        return (i+1) << 1;
    }

    public void bytt(int[] tabell, int i, int j) {
        int backup = tabell[j];
        tabell[j] = tabell[i];
        tabell[i] = backup;
    }

    public void fiksHeap(int i) {
        int m = venstre(i);
        if (m < len) {
            int h = m + 1;
            if (h < len && node[h] > node[m]) {
                m = h;
            }

            if (node[m] > node[i]) {
                bytt(node, i, m);
                fiksHeap(m);
            }
        }
    }

    public void lagHeap() {
        int i = len / 2;
        while (i-- > 0) {
            fiksHeap(i);
        }
    }
}