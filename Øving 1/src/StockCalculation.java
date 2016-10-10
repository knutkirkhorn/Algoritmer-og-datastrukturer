import java.util.Date;
import java.util.Random;

/**
 * Created by Knut on 30.08.2016.
 */
public class StockCalculation {

    private int[] stockChange;

    public StockCalculation(int[] stockChange) {
        this.stockChange = stockChange;
    }

    public double getCompletionTime(int arrayLength, int runtimes) {

        int[] tabell = generateRandomValueArray(10, 100, arrayLength);

        Date startTime = new Date();
        Date endTime;

        for(int i = 0; i < runtimes; i++) {
            calculateBuyAndSellDate(tabell);
        }

        endTime = new Date();
        return ((endTime.getTime() - startTime.getTime())/(double)runtimes);
    }

    private int[] generateValueTable(int startValue, int[] stockChange) {
        int[] valueArray = new int[stockChange.length];
        int value = startValue;

        for(int i = 0; i < stockChange.length; i++) { //n
            value += stockChange[i];
            valueArray[i] = value;
        }
        return valueArray;
    }
    private int[] generateRandomValueArray(int minimumValue, int maximumValue, int size) {
        Random random = new Random();
        int[] valueArray = new int[size];
        for(int i = 0; i < size; i++) {
            valueArray[i] = random.nextInt(maximumValue - minimumValue) + minimumValue;
        }

        return valueArray;
    }

    private void calculateBuyAndSellDate(int[] valueArray) {
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
