package com.example.safeplast;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.safeplast.Room.Plasticos;

public class DetallePlasticoInformate extends Fragment{
    TextView titulo;
    ImageView imagen;
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.detalle_plastico, container, false);
        titulo = view.findViewById(R.id.textView2);
        imagen = view.findViewById(R.id.imageView9);
        Bundle objetoPlastico = getArguments();
        Plasticos plasticos = null;
        if (objetoPlastico != null){
            plasticos = (Plasticos) objetoPlastico.getSerializable("objeto");
            titulo.setText(plasticos.getNombre());
            imagen.setImageResource(plasticos.getFotografia());
        }
        return view;
    }
}
