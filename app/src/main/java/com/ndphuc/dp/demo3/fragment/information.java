package com.ndphuc.dp.demo3.fragment;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ndphuc.dp.demo3.PagerAdapter;
import com.ndphuc.dp.demo3.R;
import com.ndphuc.dp.demo3.bean.contact;
import com.ndphuc.dp.demo3.iCallback;

import java.text.SimpleDateFormat;

public class information extends Fragment {

    private TextView txtName,txtBirth,txtJob,txtAddress,txtAbout;
    ImageView  txtAvatar;
    private SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");

    ViewPager2 viewPager2;
    TabLayout tabLayout;
    PagerAdapter adapter;

    String [] titles=new String[]{"Job","Address"};

    public static String KEY_DATA="data";
    public static information getInstance(contact ct)
    {
        information frg=new information();
        Bundle bundle=new Bundle();
        bundle.putSerializable("data",ct);
        frg.setArguments(bundle);
        return new information();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_information, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName=view.findViewById(R.id.txtName);
        txtBirth=view.findViewById(R.id.txtBirth);
        txtAbout=view.findViewById(R.id.txtAbout);
        txtAvatar= view.findViewById(R.id.txtAvatar);

        tabLayout = view.findViewById(R.id.tab_Layout);
        viewPager2=view.findViewById(R.id.vPager);





        if (getArguments() != null) {
            contact data = (contact) getArguments().getSerializable(KEY_DATA);
            SetInfo(data);
//            txtName.setText(data.getName());
        }

    }



    public void SetInfo(contact ct) {
        txtName.setText(ct.getName());
        txtBirth.setText((String) dd.format(ct.getBirthDay()));
        txtAbout.setText(ct.getAbout());

        // loading avatar
        Glide.with(getActivity())
                .load(ct.getAvatar())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(txtAvatar);

        adapter = new PagerAdapter(getActivity(),ct.getJob(),ct.getAddress());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();



    }


}