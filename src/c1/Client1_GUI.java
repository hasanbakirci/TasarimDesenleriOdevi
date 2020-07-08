package c1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;


public class Client1_GUI implements Runnable {

    private static Socket socket = null;
    static String mesaj = null;
    static String[] mesajDizi;
    static String mesajFormat = null;

    private static Client1_GUI instance;

    private Client1_GUI(){}
    public static Client1_GUI getInstance(){
        if(instance == null){
            instance = new Client1_GUI();
        }
        return instance;
    }







    public static void client1Ekran(){
        JFrame window = new JFrame("Client 1");
        window.setVisible(true);
        window.setSize(370,420);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(0, 184, 148));
        window.add(panel);
        JLabel lbl0 = new JLabel("TÜRKİYE GÜNLÜK KORONAVİRÜS TABLOSU");panel.add(lbl0);lbl0.setBounds(60,20,280,20);
        JLabel lbl1 = new JLabel("Bugünkü Test Sayısı :");JLabel lbl2 = new JLabel("Bugünkü Vaka Sayısı");JLabel lbl3 = new JLabel("Bugünkü Vefat Sayısı");JLabel lbl4 = new JLabel("Bugünkü İyileşen Sayısı:");JLabel lbl5 = new JLabel("lbl5");JLabel lbl6 = new JLabel("lbl6");JLabel lbl7 = new JLabel("lbl7");JLabel lbl8 = new JLabel("lbl8");
        JLabel lbl9 = new JLabel("Tarih");
        JLabel lbl10 = new JLabel("Toplam Test Sayısı:");JLabel lbl11 = new JLabel("Toplam Vaka Sayısı:");JLabel lbl12 = new JLabel("Toplam Vefat Sayısı:");JLabel lbl13 = new JLabel("Toplam Yoğun Bakım Hasta Sayısı:");JLabel lbl14 = new JLabel("Toplam Entübe Hasta Sayısı:");JLabel lbl15 = new JLabel("Toplam İyileşen Hasta Sayısı:");
        JLabel lbl16 = new JLabel("lbl16");JLabel lbl17 = new JLabel("lbl17");JLabel lbl18 = new JLabel("lbl18");JLabel lbl19 = new JLabel("lbl19");JLabel lbl20 = new JLabel("lbl20");JLabel lbl21 = new JLabel("lbl21");JLabel lbl22 = new JLabel("lbl22");JLabel lbl23 = new JLabel("lbl23");
        panel.add(lbl1);panel.add(lbl2);panel.add(lbl3);panel.add(lbl4);panel.add(lbl5);panel.add(lbl6);panel.add(lbl7);panel.add(lbl8);panel.add(lbl9);panel.add(lbl10);panel.add(lbl11);panel.add(lbl12);panel.add(lbl13);panel.add(lbl14);panel.add(lbl15);panel.add(lbl16);panel.add(lbl17);panel.add(lbl18);panel.add(lbl19);panel.add(lbl20);panel.add(lbl21);panel.add(lbl22);panel.add(lbl23);
        // Günlük Sabitler
        lbl1.setBounds(50,50,150,20);lbl2.setBounds(50,80,150,20);lbl3.setBounds(50,110,150,20);lbl4.setBounds(50,140,150,20);

        // Günlük Değişkenler
        lbl5.setBounds(210,50,100,20);lbl6.setBounds(210,80,100,20);lbl7.setBounds(210,110,100,20);lbl8.setBounds(210,140,100,20);
        // Tarih
        lbl9.setBounds(90,170,100,20);lbl22.setBounds(170,170,50,20);lbl23.setBounds(250,170,100,20);
        // Toplam Sabitler
        lbl10.setBounds(50,200,150,20);lbl11.setBounds(50,230,160,20);lbl12.setBounds(50,260,160,20);lbl13.setBounds(50,290,200,20);lbl14.setBounds(50,320,160,20);lbl15.setBounds(50,350,180,20);
        // Toplam Değişkenler
        lbl16.setBounds(260,200,100,20);lbl17.setBounds(260,230,100,20);lbl18.setBounds(260,260,100,20);lbl19.setBounds(260,290,100,20);lbl20.setBounds(260,320,100,20);lbl21.setBounds(260,350,100,20);




        ///////////////////////////////////////////////////////////////////////
        ////////////////////               Client kodları           //////////
        //////////////////////////////////////////////////////////////////////

        InputStream socketIn = null;
        try {
            socket = new Socket("localhost",7755);
            socketIn = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream dis = new DataInputStream(socketIn);

        new Thread(new Client1_GUI()).start();
        while (true) {
            mesaj = null;
            try {
                mesaj = dis.readUTF().trim();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(mesaj);
            mesajDizi = mesaj.split("-_-");
            //mesaj format
            mesajFormat = "Tarih: "+mesajDizi[6]+" / "+mesajDizi[13]+" / "+mesajDizi[14]+" Test Sayısı: "+mesajDizi[0]+"  Hasta Sayısı: "+mesajDizi[1]+"  Vefat Sayısı: "+mesajDizi[2]+"  Yoğun Bakım Hasta Sayısı: "+mesajDizi[3]+"  Entübe Hasta Sayısı: "+mesajDizi[4]+"  İyileşen Hasta Sayısı: "+mesajDizi[5]+"  Toplam Test Sayısı: "+mesajDizi[7]+"  Toplam Hasta Sayısı: "+mesajDizi[8]+"  Toplam Vefat Sayısı: "+mesajDizi[9]+"  Toplam Yoğun Bakım Hasta Sayısı: "+mesajDizi[10]+"  Toplam Entübe Hasta Sayısı: "+mesajDizi[11]+"  Toplam İyileşen Hasta Sayısı: "+mesajDizi[12];
            //günlük
            lbl5.setText(mesajDizi[0]);
            lbl6.setText(mesajDizi[1]);
            lbl7.setText(mesajDizi[2]);
            lbl8.setText(mesajDizi[3]);
            //tarih
            lbl9.setText(mesajDizi[6]);
            lbl22.setText(mesajDizi[13]);
            lbl23.setText(mesajDizi[14]);
            //toplam
            lbl16.setText(mesajDizi[7]);
            lbl17.setText(mesajDizi[8]);
            lbl18.setText(mesajDizi[9]);
            lbl19.setText(mesajDizi[10]);
            lbl20.setText(mesajDizi[11]);
            lbl21.setText(mesajDizi[12]);

            dosyayaYaz();

            lbl5.revalidate();lbl6.revalidate();lbl7.revalidate();lbl8.revalidate();lbl9.revalidate();lbl16.revalidate();lbl17.revalidate();lbl18.revalidate();lbl19.revalidate();lbl20.revalidate();lbl21.revalidate();lbl22.revalidate();lbl23.revalidate();

        }

    }

    public static void dosyayaYaz(){
        File dosya = new File("Client1.txt");
        try {
            FileWriter yaz = new FileWriter(dosya,true);
            yaz.write(mesajFormat+"\n");
            yaz.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        System.out.println("Bağlantı sağlandı.");
    }
}
