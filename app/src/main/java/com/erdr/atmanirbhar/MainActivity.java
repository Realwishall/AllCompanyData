package com.erdr.atmanirbhar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyInterfaceMain{
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.atm_card_back));
        }
        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.MainPageFrame) != null){
            if(savedInstanceState != null)
            {
                return;
            }
            Bundle bundle = new Bundle();
            MainData mainData = new MainData();
            fragmentManager.beginTransaction().add(R.id.MainPageFrame,mainData).commit();
        }
    }

    @Override
    public void OpenAnalysisPage() {
        FullDetail fullDetail = new FullDetail();
        SwitchToThisFragment( fullDetail,"Demo Text",false);
    }

    private void SwitchToThisFragment(Fragment fragment, String demo_text, boolean b) {
        FragmentTransaction replace = fragmentManager.beginTransaction().replace(R.id.MainPageFrame, fragment, demo_text);
        if(b){
            replace.addToBackStack(demo_text);
        }
        replace.commit();
    }
}
