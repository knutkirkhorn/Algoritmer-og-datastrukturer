package Oppgave2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


/**
 * Created by Knut on 13.09.2016.
 */
public class Main {

    public static void main(String[] args) {
        Kildekodeleser kildekodeleser = new Kildekodeleser();
        kildekodeleser.erRettAntallParanteser("{{},\n2");

        System.out.println(kildekodeleser.erRettAntallParanteser("{{},\n2"));
        System.out.println(kildekodeleser.erRettAntallParanteser("{{}},\n2"));
        System.out.println(kildekodeleser.erRettAntallParanteser("{{}}),\n2"));
        System.out.println(kildekodeleser.erRettAntallParanteser("{{}-},\n2"));

        System.out.println(kildekodeleser.erRettAntallParanteser(lesKodeFraFil("C:\\Users\\Knut\\Downloads\\Algdat - øving 4\\src\\Oppgave1\\DobbeltLenketSirkListe.java")));
    }

    private static String lesKodeFraFil(String plassering) {
        String melding = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(plassering));
            StringBuilder stringBuilder = new StringBuilder();
            String linje = bufferedReader.readLine();

            while (linje != null) {
                stringBuilder.append(linje);
                stringBuilder.append("\n");
                linje = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        return melding;
    }
}
