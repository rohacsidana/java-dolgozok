package model;

public class Ember {

    private String nev;
    private int kor, munkTöltÉv;
    private char nem;

    public Ember(String nev, int kor, char nem, int MunkTöltÉv) {
        this.nev = nev;
        this.kor = kor;
        this.munkTöltÉv = MunkTöltÉv;
        this.nem = nem;
    }

    public Ember(String nev, int kor, char nem) {
        this(nev, kor, nem, 0);
    }

    @Override
    public String toString() {
        return "Ember{" + "nev=" + nev + ", kor=" + kor + ", munkT\u00f6lt\u00c9v=" + munkTöltÉv + ", nem=" + nem + '}';
    }

}
