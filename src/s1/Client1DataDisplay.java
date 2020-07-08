package s1;

import java.net. *;
import java.io. *;

public class Client1DataDisplay implements Observer{
    DataOutputStream out = null;
    Socket socket = null;
    ServerSocket serverSocket = null;

    public  void baglan(){

        try {
            serverSocket = new ServerSocket(7755);

            socket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("port hatası");
        }

    }

    public Client1DataDisplay() {

    }

    private int testSayisi;
    private int hastaSaysi;
    private int olumSayisi;
    private int yBakimSayisi;
    private  int eHastaSayisi;
    private int iyilesenSayisi;
    private int tarihGun;
    private String tarihAy;
    private int tarihYil;
    private int toplamTestSayisi;
    private int toplamHastaSayisi;
    private int toplamOlumSayisi;
    private int toplamYbakimSayisi;
    private int toplamEhastaSayisi;
    private int toplamIyilesenSayisi;

    public void toplayici(){
        this.toplamTestSayisi +=testSayisi;
        this.toplamHastaSayisi +=hastaSaysi;
        this.toplamOlumSayisi +=olumSayisi;
        this.toplamYbakimSayisi +=yBakimSayisi;
        this.toplamEhastaSayisi +=eHastaSayisi;
        this.toplamIyilesenSayisi +=iyilesenSayisi;
    }

    public String display() {
        String gidici = testSayisi +"-_-"+hastaSaysi+"-_-"+olumSayisi+"-_-"+yBakimSayisi+"-_-"+eHastaSayisi+"-_-"+iyilesenSayisi+"-_-"+tarihGun+"-_-"+toplamTestSayisi+"-_-"+toplamHastaSayisi+"-_-"+toplamOlumSayisi+"-_-"+toplamYbakimSayisi+"-_-"+toplamEhastaSayisi+"-_-"+toplamIyilesenSayisi+"-_-"+tarihAy+"-_-"+tarihYil;
        System.out.println(gidici);

        try {
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(gidici);
        } catch (IOException e) {
            System.out.println("gönderilmemedi");
        }
        return gidici;
    }


    @Override
    public void update(int testSayisi, int hastaSaysi, int olumSayisi,int yBakimSayisi,int eHastaSayisi,int iyilesenSayisi, int tarihGun,String tarihAy,int tarihYil) {
        this.testSayisi = testSayisi;
        this.hastaSaysi= hastaSaysi;
        this.olumSayisi = olumSayisi;
        this.yBakimSayisi = yBakimSayisi;
        this.eHastaSayisi = eHastaSayisi;
        this.iyilesenSayisi = iyilesenSayisi;
        this.tarihGun = tarihGun;
        this.tarihAy = tarihAy;
        this.tarihYil = tarihYil;
        toplayici();
        display();


    }


}
