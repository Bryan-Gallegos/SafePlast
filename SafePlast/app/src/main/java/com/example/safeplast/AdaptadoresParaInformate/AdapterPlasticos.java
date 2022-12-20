package com.example.safeplast.AdaptadoresParaInformate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.safeplast.R;
import com.example.safeplast.Room.Plasticos;

import java.util.ArrayList;

public class AdapterPlasticos extends RecyclerView.Adapter<AdapterPlasticos.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    public ArrayList<Plasticos> model;
    ArrayList<Plasticos> plasticosBuscados;

    //Listener
    private View.OnClickListener listener;

    public AdapterPlasticos(Context context, ArrayList<Plasticos> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
        plasticosBuscados = new ArrayList<Plasticos>();
        plasticosBuscados.addAll(model);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_plasticos, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String tituloPlastico = model.get(position).getNombre();
        String descripcion = model.get(position).getDescripcion();
        int imagen = model.get(position).getFotografia();
        holder.tituloPlastico.setText(tituloPlastico);
        holder.descripción.setText(descripcion);
        holder.imagen.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
    public  void setOnClickListener (View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    public ArrayList<Plasticos> Filtrado(ArrayList<Plasticos> aux, String s) {
        int longitud = s.length();
        if (longitud == 0){
            plasticosBuscados.clear();
            return aux;
        }
        else{
            plasticosBuscados.clear();
            for (Plasticos c: aux){
                if (c.getNombre().toLowerCase().contains(s.toLowerCase())){
                    plasticosBuscados.add(c);
                }
            }
        }
        notifyDataSetChanged();
        return plasticosBuscados;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tituloPlastico, descripción;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloPlastico = itemView.findViewById(R.id.textView17);
            descripción = itemView.findViewById(R.id.textView18);
            imagen = itemView.findViewById(R.id.imagen_plastico);
        }
    }
}
