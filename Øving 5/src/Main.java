import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Knut on 18.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        //OPPGAVE 1
        String navneListe = lesFraFil("C:\\Users\\Knut\\Dropbox\\Algdat - øving 5\\out\\production\\Algdat - øving 5\\navn.txt");
        String[] navn = navneListe.split("\n");

        int antLinjer = navn.length;
        antLinjer = (int) Math.floor((antLinjer/75) * 100);
        Hashtabell hashtabell = new Hashtabell(101);
        for (int i = 0; i < navn.length; i++) {
            if (hashtabell.leggInn(navn[i]) != -1) {

            } else {
                System.out.println("full?? " + navn[i] + " " + i);
            }
        }

        System.out.println("Lastfaktor: " + hashtabell.lastfaktor());
        System.out.println("Kollisjoner: " + hashtabell.getAntallKollisjoner());


        //OPPGAVE 2
        int lengde = 10000000;
        int[] tilfeldigTabell = genererTilfeldigTabell(lengde);
        int storrelse = (int) Math.floor((lengde/75) * 100);

        int antallGjK = 10;

        Date startTime = new Date();
        Date endTime;
        for(int j = 0; j < antallGjK; j++) {
            HashtabellHeltall hashtabellHeltall = new HashtabellHeltall(12000017);
            for (int i = 0; i < tilfeldigTabell.length; i++) {
                //System.out.println(tilfeldigTabell[i]);
                hashtabellHeltall.leggInn(tilfeldigTabell[i]);
            }
        }
        endTime = new Date();
        System.out.println("Min heltallsHasjfunksjon: " + (endTime.getTime() - startTime.getTime())/(double)antallGjK);

        startTime = new Date();
        for(int i = 0; i < antallGjK; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            for(int k = 0; k < lengde; k++) {
                hashMap.put(k, tilfeldigTabell[k]);
            }
        }
        System.out.println("HashMap: " + (endTime.getTime() - startTime.getTime())/(double)antallGjK);


    }

    private static int[] genererTilfeldigTabell(int lengde) {
        Random random = new Random();
        int[] tilfeldigTabell = new int[lengde];
        for (int i = 0; i < lengde; i++) {
            tilfeldigTabell[i] = random.nextInt() * Integer.MAX_VALUE;
        }
        return tilfeldigTabell;
    }

    private static String lesFraFil(String plassering) {
        String melding = "";

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(plassering));
            StringBuilder stringBuilder = new StringBuilder();
            String linje = buffReader.readLine();

            while (linje != null) {
                stringBuilder.append(linje);
                stringBuilder.append("\n");
                linje = buffReader.readLine();
            }

            return stringBuilder.toString();
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return melding;
    }

    private static int hentAntallLinjer(String plassering) {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(plassering));
            StringBuilder stringBuilder = new StringBuilder();
            String linje = buffReader.readLine();

            int antallLinjer = 0;

            while (linje != null) {
                stringBuilder.append(linje);
                stringBuilder.append("\n");
                linje = buffReader.readLine();
                antallLinjer++;
            }

            return antallLinjer;
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return -1;
    }
}
