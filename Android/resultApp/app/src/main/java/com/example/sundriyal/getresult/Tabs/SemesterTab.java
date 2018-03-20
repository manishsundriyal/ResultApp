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
import android.widget.Toast;

import com.example.sundriyal.getresult.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemesterTab extends Fragment {

    private Spinner semesterSpinner;
    private List<String> semesters;
    public SemesterTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_semester_tab, container, false);
        semesters = new ArrayList<String>();

        semesterSpinner = (Spinner) view.findViewById(R.id.semesterSpinner);

        semesters.add("Select Semester");
        semesters.add("Semester 1");
        semesters.add("Semester 2");
        semesters.add("Semester 3");
        semesters.add("Semester 4");
        semesters.add("Semester 5");
        semesters.add("Semester 6");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_dropdown_item,semesters);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSpinner.setAdapter(adapter);


        semesterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i!=0){
                    Toast.makeText(getActivity(), "Semester "+i, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

}
