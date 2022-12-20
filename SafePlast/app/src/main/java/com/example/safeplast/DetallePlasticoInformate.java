package com.example.safeplast;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safeplast.AdaptadoresParaInformate.AdapterPlasticos;
import com.example.safeplast.Room.PlasticoDao;
import com.example.safeplast.Room.PlasticoDataBase;
import com.example.safeplast.Room.Plasticos;

import java.util.ArrayList;
import java.util.List;

public class DetallePlasticoInformate extends Fragment implements SearchView.OnQueryTextListener{
    TextView titulo, descripcion;
    ImageView imagen;

    AdapterPlasticos adapterPlasticos;
    RecyclerView recyclerView;
    ArrayList<Plasticos> listaplasticos;

    private PlasticoDataBase plasticoDataBase;
    private PlasticoDao plasticoDao;

    SearchView buscarPlastico;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.detalle_plastico, container, false);

        plasticoDataBase = PlasticoDataBase.getInstance(getContext());
        plasticoDao = plasticoDataBase.getDao();
        titulo = view.findViewById(R.id.textView2);
        descripcion = view.findViewById(R.id.textView18);
        imagen = view.findViewById(R.id.imageView9);

        recyclerView = view.findViewById(R.id.recyclerViewDetallePlastico);
        listaplasticos = new ArrayList<Plasticos>();



        Bundle objetoPlastico = getArguments();
        Plasticos plasticos = null;
        if (objetoPlastico != null){
            plasticos = (Plasticos) objetoPlastico.getSerializable("objeto");
            cargarLista(plasticos.getNombre());
            titulo.setText("\t\t"+plasticos.getNombre());

            String textoPlasticos = "";
            for (Plasticos p : listaplasticos){
                textoPlasticos = textoPlasticos +"* "+ p.getNombre()+"\t\t";
            }
            descripcion.setText(plasticos.getDescripcion()+"\nAqui podemos encontrar los siguientes tipos de plasticos:\n"+textoPlasticos);
            imagen.setImageResource(plasticos.getFotografia());
        }


        buscarPlastico = view.findViewById(R.id.busquedaPlastico);
        buscarPlastico.setOnQueryTextListener(this);

        mostrarData(listaplasticos);
        return view;
    }
    private void mostrarData(ArrayList<Plasticos>plastic) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPlasticos = new AdapterPlasticos(getContext(), plastic);
        recyclerView.setAdapter(adapterPlasticos);
    }

    public void cargarLista(String tipoPlastico) {
        ArrayList<Plasticos> listatodosPlastico = new ArrayList<Plasticos>();
        listatodosPlastico.addAll(plasticoDao.getAllPlasticos());
        for (Plasticos p:listatodosPlastico){
            if (p.getCategoria().equalsIgnoreCase(tipoPlastico)){
                listaplasticos.add(p);
            }
        }
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        ArrayList<Plasticos>aux = new ArrayList<Plasticos>();
        aux.addAll(listaplasticos);
        ArrayList<Plasticos>busqueda = adapterPlasticos.Filtrado(aux, s);
        mostrarData(busqueda);
        return false;
    }
}
