package com.ndphuc.dp.demo3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ndphuc.dp.demo3.fragment.address;
import com.ndphuc.dp.demo3.fragment.job;

public class PagerAdapter extends FragmentStateAdapter {

    private String [] titles=new String[]{"Job","Address"};

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new job();
            case 1:
                return new address();
            default:
                return new job();
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
