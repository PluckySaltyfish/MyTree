package com.example.plucky.mytree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;

public class test_chart_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);

        // in this example, a LineChart is initialized from xml
        LineChart LineChart = (LineChart) findViewById(R.id.task_category);
        PairData[] dataObjects ={new PairData(0,30),new PairData(1,99),new PairData(2,22),
                new PairData(3,44),new PairData(4,35),new PairData(5,60),new PairData(6,80)};

        SemiAnnualChart wkChart = new SemiAnnualChart(LineChart,dataObjects);
        wkChart.setData();
        wkChart.drawChart();
    }

}
