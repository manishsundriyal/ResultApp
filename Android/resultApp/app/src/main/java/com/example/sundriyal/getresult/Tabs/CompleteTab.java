package com.example.sundriyal.getresult.Tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sundriyal.getresult.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompleteTab extends Fragment {


    public CompleteTab() {
        // Required empty public constructor
    }

    GraphView graphView;
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{

            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3),
            new DataPoint(3, 2),
            new DataPoint(4, 6)
    });
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_complete_tab, container, false);


        Button button = (Button) view.findViewById(R.id.btn);
        graphView = (GraphView) view.findViewById(R.id.graph);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                graphView.addSeries(series);

            }
        });


        return view;
    }

}
