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


public class address extends Fragment {
    TextView lbladdress;
    String addresstext;

    public address( String addresstext){
        this.addresstext = addresstext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_address, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        lbladdress = view.findViewById(R.id.lblAddressInf);
        setAddress();
    }

    private void setAddress() {
        lbladdress.setText(addresstext);
    }
}