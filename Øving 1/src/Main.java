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

        StockCalculation stockCalculation = new StockCalculation(stockChange);

        System.out.println(stockCalculation.getCompletionTime(40000, 500));
    }
}
