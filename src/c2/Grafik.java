package c2;

import org.knowm.xchart.*;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafik implements ExampleChart<XYChart> {
    static ArrayList<Integer> grafikGun = new ArrayList<>();
    static ArrayList<Integer> grafikVaka = new ArrayList<>();
    static ArrayList<Integer> grafikVefat = new ArrayList<>();





    public static void main(String[] args)  {

        File dosya = new File("GrafikGun.txt");
        Scanner tara = null;
        try {
            tara = new Scanner(dosya);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(tara.hasNextLine()){
            grafikGun.add(Integer.parseInt(tara.nextLine()));
        }

        File dosya1 = new File("GrafikVaka.txt");
        Scanner tara1 = null;
        try {
            tara1 = new Scanner(dosya1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(tara1.hasNextLine()){
            grafikVaka.add(Integer.parseInt(tara1.nextLine()));
        }

        File dosya2 = new File("GrafikVefat.txt");
        Scanner tara2 = null;
        try {
            tara2 = new Scanner(dosya2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(tara2.hasNextLine()){
            grafikVefat.add(Integer.parseInt(tara2.nextLine()));
        }




        ExampleChart<XYChart> exampleChart = new Grafik();
        XYChart chart = exampleChart.getChart();
        new SwingWrapper<XYChart>(chart).displayChart();

 /*      try {
            Thread.sleep(5000);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
    }





    @Override
    public XYChart getChart() {


        XYChart chart = new XYChartBuilder().width(600).height(300).title("GRAFİK").xAxisTitle("Gün").yAxisTitle("").build();


        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setYAxisLabelAlignment(Styler.TextAlignment.Right);
        chart.getStyler().setYAxisDecimalPattern("#,###.##");
        chart.getStyler().setPlotMargin(0);
        chart.getStyler().setPlotContentSize(.95);




        chart.addSeries("Vaka Sayısı", grafikGun, grafikVaka);
        chart.addSeries("Vefat Sayısı", grafikGun, grafikVefat);


        return chart;
    }


    @Override
    public String getExampleChartName() {
        return null;
    }

}
