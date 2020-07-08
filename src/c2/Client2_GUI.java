package c2;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.demo.charts.ExampleChart;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.ArrayList;


public class Client2_GUI  implements Runnable {

    private static Socket socket = null;
    static String mesaj = null;
    static String mesajFormat = null;
    static String[] mesajDizi;




////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static Client2_GUI instance;

    private Client2_GUI(){}
    public static Client2_GUI getInstance(){
        if(instance == null){
            instance = new Client2_GUI();
        }
        return instance;
    }



    public static void client2Ekran(){



        JFrame window = new JFrame("Client 2");
        window.setVisible(true);
        window.setSize(500,280);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new java.awt.Color(0, 184, 148));
        window.add(panel);
        JLabel lbl0 = new JLabel("TÜRKİYE GÜNLÜK KORONAVİRÜS TABLOSU");panel.add(lbl0);lbl0.setBounds(50,20,280,20);
        JLabel lbl1 = new JLabel("Toplam Test Sayısı :");JLabel lbl2 = new JLabel("Toplam Vaka Sayısı");JLabel lbl3 = new JLabel("Toplam Vefat Sayısı");JLabel lbl4 = new JLabel("Toplam Yoğun Bakım Hasta Sayısı:");JLabel lbl5 = new JLabel("Toplam Entübe Hasta Sayisi:");JLabel lbl6 = new JLabel("Toplam İyileşen Hasta Sayisi:");
        JLabel lbl7 = new JLabel("X X X");JLabel lbl8 = new JLabel("lbl8");JLabel lbl9 = new JLabel("lbl9");JLabel lbl10 = new JLabel("lbl10");JLabel lbl11 = new JLabel("lbl1");JLabel lbl12 = new JLabel("lbl12");

        panel.add(lbl1);panel.add(lbl2);panel.add(lbl3);panel.add(lbl4);panel.add(lbl5);panel.add(lbl6);panel.add(lbl7);panel.add(lbl8);panel.add(lbl9);panel.add(lbl10);panel.add(lbl11);panel.add(lbl12);
        lbl1.setBounds(50,50,150,20);lbl2.setBounds(50,80,200,20);lbl3.setBounds(50,110,200,20);lbl4.setBounds(50,140,200,20);lbl5.setBounds(50,170,200,20);lbl6.setBounds(50,200,200,20);
        lbl7.setBounds(270,50,150,20);lbl8.setBounds(270,80,200,20);lbl9.setBounds(270,110,200,20);lbl10.setBounds(270,140,200,20);lbl11.setBounds(270,170,200,20);lbl12.setBounds(270,200,200,20);

        JButton btnGrafik = new JButton("Grafiği Aç");
        btnGrafik.setBounds(370,90,100,100);
        btnGrafik.setBackground(new java.awt.Color(178, 190, 195));
        panel.add(btnGrafik);

        btnGrafik.addActionListener(new ActionListener() {  // Grafik çalıştırma
            @Override
            public void actionPerformed(ActionEvent e) {

                    //
                    // Buton işlevsizdir.


            }
        });




        InputStream socketIn = null;
        try {
            socket = new Socket("localhost",7750);
            socketIn = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream dis = new DataInputStream(socketIn);

        new Thread(new Client2_GUI()).start();
        while (true) {
            mesaj = null;
            try {
                mesaj = dis.readUTF().trim();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            mesajDizi = mesaj.split("-_-");
            mesajFormat = "Tarih: "+mesajDizi[3]+" / "+mesajDizi[10]+" / "+mesajDizi[11]+" Test Sayısı: "+mesajDizi[0]+"  Hasta Sayısı: "+mesajDizi[1]+"  Vefat Sayısı: "+mesajDizi[2]+"  Toplam Test Sayısı: "+mesajDizi[4]+"  Toplam Hasta Sayısı: "+mesajDizi[5]+"  Toplam Vefat Sayısı: "+mesajDizi[6]+"  Toplam Yoğun Bakım Hasta Sayısı: "+mesajDizi[7]+"  Toplam Entübe Hasta Sayısı: "+mesajDizi[8]+"  Toplam İyileşen Hasta Sayısı: "+mesajDizi[9];


            lbl7.setText(mesajDizi[4]);
            lbl8.setText(mesajDizi[5]);
            lbl9.setText(mesajDizi[6]);
            lbl10.setText(mesajDizi[7]);
            lbl11.setText(mesajDizi[8]);
            lbl12.setText(mesajDizi[9]);

            lbl5.revalidate();lbl6.revalidate();lbl7.revalidate();lbl8.revalidate();lbl9.revalidate();lbl10.revalidate();lbl11.revalidate();lbl12.revalidate();

            System.out.println(mesajFormat);
            dosyayaYaz();
            dosyayaYazGun();
            dosyayaYazVaka();
            dosyayaYazVefat();







        }

    }

    public static void dosyayaYaz(){
        File dosya = new File("Client2.txt");
        try {
            FileWriter yaz = new FileWriter(dosya,true);
            yaz.write(mesajFormat+"\n");
            yaz.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void dosyayaYazGun(){
        File dosya = new File("GrafikGun.txt");
        try {
            FileWriter yaz = new FileWriter(dosya,true);
            yaz.write(mesajDizi[3]+"\n");
            yaz.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//////////////////////////////////
    public static void dosyayaYazVaka(){
        File dosya = new File("GrafikVaka.txt");
        try {
            FileWriter yaz = new FileWriter(dosya,true);
            yaz.write(mesajDizi[1]+"\n");
            yaz.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //////////////////////////
    public static void dosyayaYazVefat(){
        File dosya = new File("GrafikVefat.txt");
        try {
            FileWriter yaz = new FileWriter(dosya,true);
            yaz.write(mesajDizi[2]+"\n");
            yaz.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }







    @Override
    public void run() {System.out.println("Bağlantı sağlandı.");}
}
