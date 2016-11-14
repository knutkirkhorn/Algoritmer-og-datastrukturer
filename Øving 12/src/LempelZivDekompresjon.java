import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Knut on 13.11.2016.
 */
public class LempelZivDekompresjon {

    private String komprimertFil = "";
    private String filUt = "";

    private byte[] bytesFromFile = new byte[0];
    private byte[] ukomprimertBuffer = new byte[0];

    //Tom konstruktør dersom man vil skrive inn innfil og utfil senere
    public LempelZivDekompresjon() {

    }

    public LempelZivDekompresjon(String komprimertFil, String filUt) {
        this.komprimertFil = komprimertFil;
        this.filUt = filUt;
        lesFil();
    }

    private void lesFil() {
        try {
            bytesFromFile = Files.readAllBytes(Paths.get(komprimertFil));
            ukomprimertBuffer = new byte[bytesFromFile.length*2];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void skrivFil() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filUt)));
            dataOutputStream.write(ukomprimertBuffer);
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Dersom det er noen bytes som er ukomprimert: [z] negativ verdi, men kan også være 0
    //Eller dersom det er noen bytes som kan komprimeres: [-x, y] bare positiv verdi

    public void dekomprimerFil() {
        int bufferIndex = 0;
        int hentIndex = 0;
        while (hentIndex != bytesFromFile.length) { //TODO: mindre enn eller blir den akkurat tallet


            if (bytesFromFile[hentIndex] > 0) {//komprimert
                int start = bufferIndex - bytesFromFile[hentIndex];

                hentIndex++;
                int lengde = bytesFromFile[hentIndex];

                for (int i = start; i < start + lengde; i++, bufferIndex++) {
                    ukomprimertBuffer[bufferIndex] = ukomprimertBuffer[i];
                }

                hentIndex++;

            } else { //ukomprimert

                int uncompressedBytes = Math.abs(bytesFromFile[hentIndex]); //gir negativt tall, så må ha absoluttverdien
                int start = hentIndex + 1;

                for (int i = start; i < uncompressedBytes + start; i++, bufferIndex++) {
                    ukomprimertBuffer[bufferIndex] = bytesFromFile[i];
                }

                hentIndex += uncompressedBytes + 1;
            }
        }
        fixEmptyBufferBytes(ukomprimertBuffer, bufferIndex);
        skrivFil();
    }

    private void fixEmptyBufferBytes(byte[] buffer, int bufferLength) {
        ukomprimertBuffer = new byte[bufferLength];
        for (int i = 0; i < bufferLength; i++) {
            ukomprimertBuffer[i] = buffer[i];
        }
    }

    public static void main(String[] args) {
        LempelZivDekompresjon lempelZivNyDekompresjon = new LempelZivDekompresjon("TestFilKomprimert.ingknu", "TestFilDekomprimert.txt");
        lempelZivNyDekompresjon.dekomprimerFil();
    }
}