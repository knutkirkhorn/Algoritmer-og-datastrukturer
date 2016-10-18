/**
 * Created by Knut on 18.10.2016.
 */
public class Main {
    public static void main(String[] args) {

        RelationProperties relProp = new RelationProperties();

        char[] setA = {'a','x','r','m','2','0'};
        char[][] rel1 = {{'a','a'},{'r','a'},{'a','2'},{'x','x'},{'r','2'},{'r','r'},{'m','m'},{'2','r'},{'0','0'},{'a','r'},{'2','2'},{'2','a'}};
        char[][] rel2 = {{'a','x'},{'r','2'},{'0','0'},{'m','2'}};

        if (relProp.checkForMultipleValues(rel1) && relProp.checkForMultipleValues(rel2) && relProp.checkForMultipleValues(setA)) {
            System.out.println();
        }

        System.out.println("Rel1 is reflexive: " + relProp.isReflexive(rel1, setA));
        System.out.println("Rel2 is reflexive: " + relProp.isReflexive(rel2, setA));
        System.out.println("Rel1 is symmetric: " + relProp.isSymmetric(rel1, setA));
        System.out.println("Rel2 is symmetric: " + relProp.isSymmetric(rel2, setA));
        System.out.println("Rel1 is transitive: " + relProp.isTransitive(rel1, setA));
        System.out.println("Rel2 is transitive: " + relProp.isTransitive(rel2, setA));
        System.out.println("Rel1 is antisymmetric: " + relProp.isAntiSymmetric(rel1, setA));
        System.out.println("Rel2 is antisymmetric: " + relProp.isAntiSymmetric(rel2, setA));
        System.out.println("Rel1 is an equivalence relation: " + relProp.isEquivalenceRelation(rel1, setA));
        System.out.println("Rel2 is an equivalence relation: " + relProp.isEquivalenceRelation(rel2, setA));
        System.out.println("Rel1 is a partial order: " + relProp.isPartialOrder(rel1, setA));
        System.out.println("Rel2 is a partial order: " + relProp.isPartialOrder(rel2, setA));

        /* skal gi følgende utskrift:
           Rel1 is reflexive: true
           Rel2 is reflexive: false
           Rel1 is symmetric: true
           Rel2 is symmetric: false
           Rel1 is transitive: true
           Rel2 is transitive: true
           Rel1 is antisymmetric: false
           Rel2 is antisymmetric: true
           Rel1 is an equivalence relation: true
           Rel2 is an equivalence relation: false
           Rel1 is a partial order: false
           Rel2 is a partial order: false
        */
    }
}
