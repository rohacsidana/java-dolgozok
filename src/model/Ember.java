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

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getMunkTöltÉv() {
        return munkTöltÉv;
    }

    public void setMunkTöltÉv(int munkTöltÉv) {
        this.munkTöltÉv = munkTöltÉv;
    }

    public char getNem() {
        return nem;
    }

    public void setNem(char nem) {
        this.nem = nem;
    }
    
    

    @Override
    public String toString() {
        return "Ember{" + "nev=" + nev + ", kor=" + kor + ", munkT\u00f6lt\u00c9v=" + munkTöltÉv + ", nem=" + nem + '}';
    }

}
