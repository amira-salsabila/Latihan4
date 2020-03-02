package com.example.fragmentpahlawan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private RecyclerView rvHero;
    private ArrayList<ListPahlawanModel> list = new ArrayList<>();

    public FragmentHome() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvHero = view.findViewById(R.id.fragmenthome_recyclerview);
        rvHero.setHasFixedSize(true);
        list.addAll(ListPahlawanData.getHeroList());

        rvHero.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListPahlawanAdapter listPahlawanAdapter = new ListPahlawanAdapter(ListPahlawanData.getHeroList(), getActivity());
        rvHero.setAdapter(listPahlawanAdapter);

    }

}
