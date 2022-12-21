package com.example.safeplast;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Perfil extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        AgregarUsuario activity=new AgregarUsuario();
        TextView Nom1=view.findViewById(R.id.nomID);
        //Nom1.setText(recibedato);
        Button btnLanzarActivity = (Button) view.findViewById(R.id.editar);
        btnLanzarActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AgregarUsuario.class);
                startActivity(intent);
            }
        });
        return view;
    }
}