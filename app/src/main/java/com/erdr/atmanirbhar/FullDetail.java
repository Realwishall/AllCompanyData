package com.erdr.atmanirbhar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.h6ah4i.android.tablayouthelper.TabLayoutHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FullDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FullDetail extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View rootView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ViewPager screenpger;
    AdapterQuestionForStudentMCQ adapterQuestionForStudentMCQ;
    List<ListMy> listMIES;
    public FullDetail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FullDetail.
     */
    // TODO: Rename and change types and number of parameters
    public static FullDetail newInstance(String param1, String param2) {
        FullDetail fragment = new FullDetail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_full_detail, container, false);
        AllInOnCreate();
        return rootView;
    }

    private void AllInOnCreate() {

        listMIES = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("MyFinalFiles")
                .orderBy("PositionOnApp")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                    listMIES.add(new ListMy(document.get("AreaOfWork").toString(),document));
                             }
                            NowWork();
                        } else {

                         }
                    }
                });
    }

    private void NowWork() {

        screenpger = rootView.findViewById(R.id.screenvipager);
        adapterQuestionForStudentMCQ = new AdapterQuestionForStudentMCQ(getActivity(), listMIES);
        screenpger.setAdapter(adapterQuestionForStudentMCQ);
        TabLayout tabLayout = rootView.findViewById(R.id.tabL);
        TabLayoutHelper mTabLayoutHelper = new TabLayoutHelper(tabLayout, screenpger);

        for(int i = 0;i<tabLayout.getTabCount();i++){
            tabLayout.getTabAt(i).setText(listMIES.get(i).getAreaOfWork());
        }
        mTabLayoutHelper.setAutoAdjustTabModeEnabled(true);
    }

}
