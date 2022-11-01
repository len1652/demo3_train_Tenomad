package com.ndphuc.dp.demo3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ndphuc.dp.demo3.bean.contact;
import com.ndphuc.dp.demo3.iCallback;
import com.ndphuc.dp.demo3.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class addInfor extends Fragment {

    private Button btnDone;
    private TextView lblbar,edtName,edtBirth,edtAvatar,edtJob,edtAddress,edtAbout;
    private iCallback callback;
    contact ct = new contact();
    private SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        callback = (iCallback) getActivity();
        View view = inflater.inflate(R.layout.fragment_add_infor, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lblbar = getActivity().findViewById(R.id.lblBar);
        btnDone = view.findViewById(R.id.btnDone);

        edtName = view.findViewById(R.id.edtName);
        edtBirth = view.findViewById(R.id.edtBirth);
        edtAvatar = view.findViewById(R.id.edtAvatar);
        edtJob = view.findViewById(R.id.edtJob);
        edtAddress = view.findViewById(R.id.edtAddress);
        edtAbout = view.findViewById(R.id.edtAbout);

        addEvents();


    }

    private void addEvents() {

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean kt ;
                kt = kiemtra();
                if (kt==true){
                    setAppBar();
                    setContact();
                    callback.callbackJump(ct);
                }
                else{
                    Toast.makeText(getActivity(),R.string.LackOfInformation,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private Boolean kiemtra() {

        if(edtName.getText().length()==0
                ||edtAbout.getText().length()==0
                ||edtBirth.getText().length()==0
                ||edtAvatar.getText().length()==0
                || edtAddress.getText().length()==0
                ||edtJob.getText().length()==0){
            return false;
        }

        return true;
    }

    private void setContact()  {
        try {
            ct.setId("123");
            ct.setName(edtName.getText().toString());
            ct.setBirthDay(dd.parse(edtBirth.getText().toString()));
            ct.setAvatar(edtAvatar.getText().toString());
            ct.setJob(edtJob.getText().toString());
            ct.setAddress( edtAddress.getText().toString());
            ct.setAbout(edtAbout.getText().toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void setAppBar() {
        lblbar.setText("Information");
    }
}