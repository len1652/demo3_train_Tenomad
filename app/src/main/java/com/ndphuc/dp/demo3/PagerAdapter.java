package com.ndphuc.dp.demo3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ndphuc.dp.demo3.fragment.address;
import com.ndphuc.dp.demo3.fragment.job;

public class PagerAdapter extends FragmentStateAdapter {

    private String [] titles=new String[]{"Job","Address"};
    String job="";
    String address="";

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity,String job, String address) {
        super(fragmentActivity);
        this.job = job;
        this.address = address;
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new job(job);
            case 1:
                return new address(address);
            default:
                return new job(job);
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
