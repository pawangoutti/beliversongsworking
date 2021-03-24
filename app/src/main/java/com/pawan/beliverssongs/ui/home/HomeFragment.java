package com.pawan.beliverssongs.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pawan.beliverssongs.R;
import com.pawan.beliverssongs.SongShowHindi;
import com.pawan.beliverssongs.songShowMarthi;
import com.pawan.beliverssongs.SongShowEnglish;

public class HomeFragment extends Fragment {

    Button btn_eng_songs,hindi,marthi;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);




        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
              //  textView.setText(s);
            }
        });

        btn_eng_songs = root.findViewById(R.id.btn_eng_songs);
        btn_eng_songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent engIntent = new Intent(getActivity(), SongShowEnglish.class);
                startActivity(engIntent);
            }
        });


        hindi = root.findViewById(R.id.btn_hindi_songs);
        marthi = root.findViewById(R.id.btn_marthi_songs);







        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hindiIntent = new Intent(getActivity(), SongShowHindi.class);
                startActivity(hindiIntent);
            }
        });



        marthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent marthiIntent = new Intent(getActivity(), songShowMarthi.class);
                startActivity(marthiIntent);
            }
        });


        return root;
    }



}