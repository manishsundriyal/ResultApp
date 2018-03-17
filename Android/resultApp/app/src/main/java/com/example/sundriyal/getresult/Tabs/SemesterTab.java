package com.example.sundriyal.getresult.Tabs;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sundriyal.getresult.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemesterTab extends Fragment {

    private Spinner semesterSpinner;
    private List<String> semsters;
    private TextView centerText;
    public SemesterTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_semester_tab, container, false);
        semsters = new ArrayList<String>();

        semesterSpinner = (Spinner) view.findViewById(R.id.semesterSpinner);
        semesterSpinner.setBackgroundColor(Color.GRAY);

        centerText = (TextView) view.findViewById(R.id.semesterTabText);


        semsters.add("Select Semester");
        semsters.add("Semester 1");
        semsters.add("Semester 2");
        semsters.add("Semester 3");
        semsters.add("Semester 4");
        semsters.add("Semester 5");
        semsters.add("Semester 6");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,semsters);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(adapter);

        return view;
    }

}
