package com.example.safeplast;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.safeplast.AdaptadoresParaInformate.AdapterPlasticos;
import com.example.safeplast.Room.Plasticos;

import java.util.ArrayList;


public class Informate extends Fragment {
    /*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Informate() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Informate.

    // TODO: Rename and change types and number of parameters
    public static Informate newInstance(String param1, String param2) {
        Informate fragment = new Informate();
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
    */
    AdapterPlasticos adapterPlasticos;
    RecyclerView recyclerView;
    ArrayList<Plasticos>listaplasticos;
    //Referencias para comunicar Fragments
    Activity activity;
    iComunicaInformate interfaceComunicaFragments;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informate, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        listaplasticos = new ArrayList<Plasticos>();
        cargarLista();
        mostrarData();
        return view;
    }

    private void mostrarData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPlasticos = new AdapterPlasticos(getContext(), listaplasticos);
        recyclerView.setAdapter(adapterPlasticos);
        adapterPlasticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = listaplasticos.get(recyclerView.getChildAdapterPosition(view)).getNombre();
                Toast.makeText(getContext(),"Selecciono: "+nombre,Toast.LENGTH_SHORT).show();
                interfaceComunicaFragments.enviarPlastico(listaplasticos.get(recyclerView.getChildAdapterPosition(view)));
            }
        });
    }

    public void cargarLista() {
        listaplasticos.add(new Plasticos(1,"ds","sds","1","1","1","sd",R.drawable.bryan));
        listaplasticos.add(new Plasticos(2,"ds","sds","1","1","1","sd",R.drawable.bryan));
        listaplasticos.add(new Plasticos(3,"ds","sds","1","1","1","sd",R.drawable.jimy));
        listaplasticos.add(new Plasticos(4,"ds","sds","1","1","1","sd",R.drawable.bryan));
        listaplasticos.add(new Plasticos(5,"ds","sds","1","1","1","sd",R.drawable.bryan));
        listaplasticos.add(new Plasticos(6,"ds","sds","1","1","1","sd",R.drawable.bryan));
        listaplasticos.add(new Plasticos(7,"ds","sds","1","1","1","sd",R.drawable.bryan));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicaFragments = (iComunicaInformate) this.activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}