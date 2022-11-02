package com.ndphuc.dp.demo3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ndphuc.dp.demo3.R;


public class job extends Fragment {
    TextView lbljobInf;
    String jobtext;
    public job (String job){
        jobtext = job;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_job, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        lbljobInf = view.findViewById(R.id.lblJobInf);
        setJob();
    }

    private void setJob() {
        lbljobInf.setText(jobtext);
    }

}