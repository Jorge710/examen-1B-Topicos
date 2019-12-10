package com.example.examensistemadecalificaciones.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.examensistemadecalificaciones.MainActivity;
import com.example.examensistemadecalificaciones.R;
import com.example.examensistemadecalificaciones.ejemplo;
import com.example.examensistemadecalificaciones.notas;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        initUI(v);
        return v;

    }


    private void initUI(View v){
        Button b1 =(Button)v.findViewById(R.id.vernotas);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent se = new Intent(getActivity(), ejemplo.class);
                startActivity(se);
            }

        });

    }

}



