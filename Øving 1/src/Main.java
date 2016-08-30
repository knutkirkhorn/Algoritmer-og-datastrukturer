import java.util.Date;
import java.util.Random;

/**
 * Created by Knut on 22.08.2016.
 */
public class Main {

    static int[] stockChange = {-1, 3, -9, 2, 2, -1, 2, -1, -5};

    public static void main(String[] args) {

        //int[] tabell = genererTilfeldigVerdiTabell(10, 100, 1000000);
        //int[] tabell = genererVerditabell(11, kursforandring);//genererTilfeldigVerdiTabell(10, 100, 1000);
        /*for(int i = 0; i < tabell.length; i++) {
            System.out.println(tabell[i]);
        }*/

        //calculateBuyAndSellDate(tabell);

        /*sluttTid = new Date();
        System.out.println(sluttTid.getTime() - startTid.getTime());*/

        System.out.println(completionTime(40000, 500));
    }

    private static double completionTime(int arrayLength, int runtimes) {

        int[] tabell = generateRandomValueArray(10, 100, arrayLength);

        Date startTime = new Date();
        Date endTime;

        for(int i = 0; i < runtimes; i++) {
            calculateBuyAndSellDate(tabell);
        }

        endTime = new Date();
        return ((endTime.getTime() - startTime.getTime())/(double)runtimes);
    }

    private static int[] generateValueTable(int startValue, int[] stockChange) {
        int[] valueArray = new int[stockChange.length];
        int value = startValue;

        for(int i = 0; i < stockChange.length; i++) { //n
            value += stockChange[i];
            valueArray[i] = value;
        }
        return valueArray;
    }

    private static int[] generateRandomValueArray(int minimumValue, int maximumValue, int size) {
        Random random = new Random();
        int[] valueArray = new int[size];
        for(int i = 0; i < size; i++) {
            valueArray[i] = random.nextInt(maximumValue - minimumValue) + minimumValue;
        }

        return valueArray;
    }

    private static void calculateBuyAndSellDate(int[] valueArray) {
        int maxDifference = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < valueArray.length; i++) { //Gjøres n ganger
            int value = valueArray[i];
            for(int j = i + 1; j < valueArray.length; j++) { //Gjøres også n ganger, tilsammen blir tiden n^(2) og + n fra en annen her
                int difference = valueArray[j] - value;
                if(difference > maxDifference) {
                    maxDifference = difference;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        } //n^2
        /*System.out.println("Maks differanse: " + maksDifferanse);
        System.out.println("Startdag: " + (maksStart + 1));
        System.out.println("Sluttdag: " + (maksSlutt + 1));*/
    }
}
