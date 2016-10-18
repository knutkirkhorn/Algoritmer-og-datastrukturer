import java.util.ArrayList;

/**
 * Kode gitt til øvingen, med tomme metoder som har blitt fylt ut
 */

public class RelationProperties {

    public boolean checkForMultipleValues(char[] set) {
        for (int i = 0; i < set.length - 1; i++) {
            for (int j = i + 1; j < set.length; j++) {
                if (set[i] == set[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForMultipleValues(char[][] rel) {
        for (int i = 0; i < rel.length - 1; i++) {
            for (int j = i + 1; j < rel.length; j++) {
                if (rel[i][0] == rel[j][0] && rel[i][1] == rel[j][1]) {
                    return false;
                }
            }
        }
        return true;
    }

    //private boolean reflexiveRelations(char)

    //For alle x element i A er (x, x) element i relasjonen R
    public boolean isReflexive(char[][] relation, char[] set){
        int teller = 0; //Teller for å sjekke om det er likt antall
        for (int i = 0; i < set.length; i++) { //
            for (int j = 0; j < relation.length; j++) {
                char[] currentRel = relation[j];
                if (currentRel[0] == set[i] && currentRel[0] == currentRel[1]) {
                    teller++;
                    j = relation.length;
                }
            }
        }

        if (teller == set.length) {
            return true;
        }
        return false;
    }

    private boolean symetricRelations(char[] rel1, char[] rel2) {
        if (rel1[0] == rel2[1] && rel1[1] == rel2[0]) {
            return true;
        }
        return false;
    }

    public boolean isSymmetric(char[][] relation, char[] set){
        ArrayList<char[]> chars = new ArrayList<char[]>();
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] != relation[i][1]) {
                chars.add(relation[i]);
            }
        }

        if (chars.size()%2 == 0) {
            int teller = 0;
            for (int i = 0; i < chars.size(); i++) {
                char[] currentRel = null;
                for (int j = i; j < chars.size(); j++) {
                    if (currentRel == null) {
                        currentRel = chars.get(i);
                    } else {
                        if (symetricRelations(currentRel, chars.get(j))) {
                            teller++;
                        }
                    }
                }
            }

            if (teller == (chars.size()/2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTransitive(char[][] relation, char[] set){
        boolean transitive = false;
        for (int i = 0; i < relation.length; i++) {
            for (int j = 0; j < relation.length; j++) {
                // (a, b)  (b, c)  (a, c)
                char[] a = relation[i];// (a, b) = (a[0], a[1])
                char[] b = relation[j];// (b, c) = (b[0], b[1])

                if (a[1] == b[0]) {
                    for (int k = 0; k < relation.length; k++) {
                        if (a[0] == relation[k][0] && b[1] == relation[k][1]) {
                            transitive = true;
                        }
                    }
                    if (!transitive) {
                        return false;
                    }
                }
                transitive = false;
            }
        }
        return true;
    }

    public boolean isAntiSymmetric(char[][] relation, char[] set){
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] != relation[i][1]) {
                for (int j = 0; j < relation.length; j++) {
                    if (relation[i][0] == relation[j][1] && relation[i][1] == relation[j][0]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isEquivalenceRelation(char[][] relation, char[] set){
        return isReflexive(relation, set) && isSymmetric(relation, set) && isTransitive(relation, set);
    }

    public boolean isPartialOrder(char[][] relation, char[] set){
        return isReflexive(relation, set) && isAntiSymmetric(relation, set) && isTransitive(relation, set);
    }
}
