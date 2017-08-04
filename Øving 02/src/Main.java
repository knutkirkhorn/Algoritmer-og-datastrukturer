import java.util.Date;

/**
 * Created by Knut on 24.08.2016.
 * Øving 2 - Rekursiv programmering
 */
public class Main {

    public static void main(String[] args) {
        double base = 3000;
        double exponent = 2000;

        double antallGjennomganger = 10000;
        Date startTime = new Date();
        Date endTime;

        for(int i = 0; i < antallGjennomganger; i++) {
            calculateExponential(base, exponent);
        }
        endTime = new Date();
        System.out.println("Tid oppgave 1: " + (endTime.getTime() - startTime.getTime()) / antallGjennomganger + "ms");

        startTime = new Date();

        for(int i = 0; i < antallGjennomganger; i++) {
            calculateExponential2(base, exponent);
        }
        endTime = new Date();
        System.out.println("Tid oppgave 2: " + (endTime.getTime() - startTime.getTime()) / antallGjennomganger + "ms");

        /*
        System.out.println(Math.pow());
         */
    }

    /**
     * Oppgave 2.1-1
     */
    private static double calculateExponential(double base, double exponent) {
        if (exponent > 0) {
            return base * calculateExponential(base, exponent - 1);
        } else {
            return 1;
        }
    }

    /**
     * Oppgave 2.2-3
     */
    private static double calculateExponential2(double base, double exponent) {
        if (exponent > 0) {
            //Check if the exponent (n) is odd or even
            if (exponent%2 == 0) {
                //Even
                double newExponent = exponent / 2;
                return calculateExponential2((base * base), newExponent);
            } else {
                //Odd
                double newExponent = (exponent - 1) / 2;
                return base * calculateExponential2((base * base), newExponent);
            }
        }
        return 1;
    }
}
