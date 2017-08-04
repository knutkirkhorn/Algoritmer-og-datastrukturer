package Oppgave2;

/**
 * Created by Knut on 13.09.2016.
 */
public class Stakk {
    private char[] tabell;
    private int antall = 0;

    public Stakk(int storrelse) {
        tabell = new char[storrelse];
    }

    public boolean tom() {
        return (antall == 0);
    }

    public boolean full() {
        return (antall == tabell.length);
    }

    public void push(char ch) {
        if (!full()) {
            tabell[antall++] = ch;
        }
    }

    public char pop() {
        if (!tom()) {
            return tabell[--antall];
        } else {
            return '_';
        }
    }

    public char sjekkStakk() {
        if (!tom()) {
            return tabell[antall - 1];
        } else {
            return '_';
        }
    }
}
