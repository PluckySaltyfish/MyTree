package com.example.plucky.mytree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;

public class me_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.me_fragment,container,false);
        LineChart LineChart = (LineChart)v.findViewById(R.id.task_category);
        PairData[] dataObjects ={new PairData(0,30),new PairData(1,99),new PairData(2,22),
                new PairData(3,44),new PairData(4,35),new PairData(5,60),new PairData(6,80)};

        SemiAnnualChart wkChart = new SemiAnnualChart(LineChart,dataObjects);
        wkChart.setData();
        wkChart.drawChart();
        return v;
    }

}
