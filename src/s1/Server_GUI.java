package s1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server_GUI {

    public void serverEkran(){
        Client1DataDisplay d1 = new Client1DataDisplay();
        Client2DataDisplay d2 = new Client2DataDisplay();
        VeriGirisi data = new VeriGirisi();
        data.addObserver(d1);
        data.addObserver(d2);




        JFrame window = new JFrame("Server");
        window.setVisible(true);
        window.setSize(350,420);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        window.add(panel);
        panel.setBackground(new java.awt.Color(0, 184, 148));
        JLabel lbl0 = new JLabel("VERİ GİRİŞ EKRANI");panel.add(lbl0);lbl0.setBounds(100,20,280,20);
        JLabel lbl1 = new JLabel("Test Sayısı:");panel.add(lbl1);lbl1.setBounds(35,50,150,20);
        JLabel lbl2 = new JLabel("Vaka Syısı:");panel.add(lbl2);lbl2.setBounds(35,80,150,20);
        JLabel lbl3 = new JLabel("Vefat Sayısı:");panel.add(lbl3);lbl3.setBounds(35,110,150,20);
        JLabel lbl4 = new JLabel("Yoğun Bakım Hasta Sayısı:");panel.add(lbl4);lbl4.setBounds(35,140,150,20);
        JLabel lbl5 = new JLabel("Entübe Hasta Sayısı:");panel.add(lbl5);lbl5.setBounds(35,170,150,20);
        JLabel lbl6 = new JLabel("İyileşen Hasta Sayısı:");panel.add(lbl6);lbl6.setBounds(35,200,150,20);
        JLabel lbl7 = new JLabel("Tarih:");panel.add(lbl7);lbl7.setBounds(35,230,150,20);
        /// Text
        JTextField txt1 = new JTextField(4);panel.add(txt1);txt1.setBounds(200,50,50,20);
        JTextField txt2 = new JTextField(4);panel.add(txt2);txt2.setBounds(200,80,50,20);
        JTextField txt3 = new JTextField(4);panel.add(txt3);txt3.setBounds(200,110,50,20);
        JTextField txt4 = new JTextField(4);panel.add(txt4);txt4.setBounds(200,140,50,20);
        JTextField txt5 = new JTextField(4);panel.add(txt5);txt5.setBounds(200,170,50,20);
        JTextField txt6 = new JTextField(4);panel.add(txt6);txt6.setBounds(200,200,50,20);
  //      JTextField txt7 = new JTextField(4);panel.add(txt7);txt7.setBounds(200,230,50,20);

    /*    try {
            MaskFormatter tarihFormat = new MaskFormatter("DD/MM/YYYY");
            JFormattedTextField txt7 = new JFormattedTextField(tarihFormat);panel.add(txt7);txt7.setBounds(200,230,50,20);
        } catch (ParseException e) {
            e.printStackTrace();
        }
      */

        JButton btnGonder = new JButton("GÖNDER");panel.add(btnGonder);btnGonder.setBounds(100,270,100,30);
        JButton btnBaglantiAc = new JButton("BAĞLANTI AÇ");panel.add(btnBaglantiAc);btnBaglantiAc.setBounds(80,350,150,20);

        JComboBox<Integer> gun = new JComboBox();
        gun.addItem(1);gun.addItem(2);gun.addItem(3);gun.addItem(4);gun.addItem(5);gun.addItem(6);gun.addItem(7);gun.addItem(8);gun.addItem(9);gun.addItem(10);
        gun.addItem(11);gun.addItem(12);gun.addItem(13);gun.addItem(14);gun.addItem(15);gun.addItem(16);gun.addItem(17);gun.addItem(18);gun.addItem(19);gun.addItem(20);
        gun.addItem(21);gun.addItem(22);gun.addItem(23);gun.addItem(24);gun.addItem(25);gun.addItem(26);gun.addItem(27);gun.addItem(28);gun.addItem(29);gun.addItem(30);
        gun.addItem(31);
        panel.add(gun);gun.setBounds(85,230,35,20);
        JComboBox<String> ay = new JComboBox();
        ay.addItem("Ocak");ay.addItem("Şubat");ay.addItem("Mart");ay.addItem("Nisan");ay.addItem("Mayıs");ay.addItem("Haziran");
        ay.addItem("Temmuz");ay.addItem("Ağustos");ay.addItem("Eylül");ay.addItem("Ekim");ay.addItem("Kasım");ay.addItem("Aralık");
        panel.add(ay);ay.setBounds(125,230,70,20);
        JComboBox<Integer> yil = new JComboBox();
        yil.addItem(2020);yil.addItem(2021);yil.addItem(2022);
        panel.add(yil);yil.setBounds(200,230,50,20);




        btnGonder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                data.setTxt1(Integer.parseInt(txt1.getText()));
                data.setTxt2(Integer.parseInt(txt2.getText()));
                data.setTxt3(Integer.parseInt(txt3.getText()));
                data.setTxt4(Integer.parseInt(txt4.getText()));
                data.setTxt5(Integer.parseInt(txt5.getText()));
                data.setTxt6(Integer.parseInt(txt6.getText()));
              //  data.setTxt7(Integer.parseInt(txt7.getText()));
                data.setTxt7(Integer.parseInt(gun.getSelectedItem().toString()));
                data.setTxt8(ay.getSelectedItem().toString());
                data.setTxt9(Integer.parseInt(yil.getSelectedItem().toString()));


                data.notifyObserver();

            }
        });

        btnBaglantiAc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                d1.baglan();
                d2.baglan();

            }
        });
    }
}
