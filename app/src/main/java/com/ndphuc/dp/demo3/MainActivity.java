package com.ndphuc.dp.demo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.ndphuc.dp.demo3.bean.contact;
import com.ndphuc.dp.demo3.fragment.addInfor;
import com.ndphuc.dp.demo3.fragment.information;

public class MainActivity extends AppCompatActivity implements iCallback{

    addInfor infor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        addControlls();
        addEvents();
    }

    private void addControlls() {
    }
    private void addEvents() {
        addInforFragment();

    }

    private void addInforFragment() {
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new addInfor();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void callbackJump(contact ct) {
        FragmentManager fragmentManager =getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putSerializable(information.KEY_DATA, ct);

        fragmentManager.beginTransaction().add(R.id.frame, information.class, bundle).commit();
    }

    @Override
    public void callbackJumpAdd() {
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new addInfor();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


}