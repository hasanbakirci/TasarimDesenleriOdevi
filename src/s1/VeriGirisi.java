package s1;

import java.util.Vector;

public class VeriGirisi implements Subject {
    private int txt1;
    private int txt2;
    private int txt3;
    private int txt4;
    private int txt5;
    private int txt6;
    private  int txt7;
    private String txt8;
    private int txt9;


    public void setTxt1(int txt1) {
        this.txt1 = txt1;
    }

    public void setTxt2(int txt2) {this.txt2 = txt2; }

    public void setTxt3(int txt3) {this.txt3 = txt3; }

    public void setTxt4(int txt4) {this.txt4 = txt4; }

    public void setTxt5(int txt5) {this.txt5 = txt5; }

    public void setTxt6(int txt6) {this.txt6 = txt6; }

    public void setTxt7(int txt7) {this.txt7 = txt7; }

    public void setTxt8(String txt8) {this.txt8 = txt8; }

    public void setTxt9(int txt9) {this.txt9 = txt9; }

    private Vector<Observer> observers;

    public VeriGirisi(){
        observers = new Vector<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        int testSayisi = txt1;
        int hastaSaysi = txt2;
        int olumSayisi = txt3;
        int yBakimSayisi = txt4;
        int eHastaSayisi = txt5;
        int iyilesenSayisi = txt6;
        int tarihGun = txt7;
        String tarihAy = txt8;
        int tarihYil = txt9;

        for (Observer observer:observers
        ) {observer.update(testSayisi,hastaSaysi,olumSayisi,yBakimSayisi,eHastaSayisi,iyilesenSayisi,tarihGun,tarihAy,tarihYil);

        }

    }

}
