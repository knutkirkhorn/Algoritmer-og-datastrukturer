package Oppgave2;

/**
 * Created by Knut on 13.09.2016.
 */
public class Kildekodeleser {

    char[] startParanteser = {'(', '[', '{'};
    char[] sluttParanteser = {')', ']', '}'};

    public boolean erRettAntallParanteser(String kildekode) {
        Stakk stakk = new Stakk(kildekode.length());

        //System.out.println(kildekode.length());
        //System.out.println(kildekode);

        for (int i = 0; i < kildekode.length(); i++) {
            char check = kildekode.charAt(i);

            //sjekke om noværende char er en parantes eller ikke
            for(int j = 0; j < startParanteser.length; j++) {
                if (check == startParanteser[j]) {
                    stakk.push(check);
                } else if (check == sluttParanteser[j]) {

                    if (stakk.tom()) { //Sjekke om stakken er tom, hvis den er det så er det ingen start paranteser som kan passe denne
                        return false;
                    } else {
                        //Sjekke hvilken bokstav denne er
                        switch (check) {
                            case ')':
                                if (stakk.pop() != '(') {
                                    return false;
                                }
                                break;
                            case ']':
                                if (stakk.pop() != '[') {
                                    return false;
                                }
                                break;
                            case '}':
                                if (stakk.pop() != '{') {
                                    return false;
                                }
                                break;
                        }
                    }
                }
            }
        }

        //Sjekke om det er noe igjen på stakken, hvis den er tom så return true
        if (stakk.tom()) {
            return true;
        }
        return false;
    }
}
