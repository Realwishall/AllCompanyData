package com.erdr.atmanirbhar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterQuestionForStudentMCQ extends PagerAdapter {

    Context mCtx;
    List<ListMy> screenItemsList;
    String display ="-";


    AdapterRecylerView adapterRecylerView;
    List<ListRecyclerInView> listRecyclerInViews;
    RecyclerView recyclerView;


    public AdapterQuestionForStudentMCQ(Context mCtx, List<ListMy> screenItemsList) {
        this.mCtx = mCtx;
        this.screenItemsList = screenItemsList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View layoutScreen = inflater.inflate(R.layout.layout_for_batch_assiner,null);
        SettingAllPage(layoutScreen,position);
        container.addView(layoutScreen);
        return layoutScreen;
    }

    private void SettingAllPage(View layoutScreen, int position) {
        recyclerView= layoutScreen.findViewById(R.id.ThisRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mCtx));
        listRecyclerInViews = new ArrayList<>();
        int i = 1;
        while (screenItemsList.get(position).getDocument().get(i+"China") != null){
            listRecyclerInViews.add(new ListRecyclerInView(
                    screenItemsList.get(position).getDocument().get(i+"CompanyName").toString(),
                    screenItemsList.get(position).getDocument().get(i+"ImageName").toString(),
                    screenItemsList.get(position).getDocument().get(i+"China").toString(),
                    screenItemsList.get(position).getDocument().get(i+"India").toString(),
                    screenItemsList.get(position).getDocument().get(i+"String").toString()));
            i++;
        }

        adapterRecylerView = new AdapterRecylerView(mCtx, listRecyclerInViews);
        recyclerView.setAdapter(adapterRecylerView);
    }


    @Override
    public int getCount() {
        return screenItemsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
