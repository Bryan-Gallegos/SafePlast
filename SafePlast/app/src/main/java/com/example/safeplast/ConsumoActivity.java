package com.example.safeplast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.safeplast.Room.PlasticoDao;
import com.example.safeplast.Room.PlasticoDataBase;
import com.example.safeplast.Room.Plasticos;

import java.util.List;

public class ConsumoActivity extends AppCompatActivity implements AdapterListener {

    EditText txtNombre, txtDescripcion, txtUsuario, txtOrigen, txtUbicacion, txtFotografia;
    Button btnGuardar, btnActualizar;
    RecyclerView plasticosRecycler;
    Spinner conSpinner;

    private PlasticoDataBase plasticoDataBase;
    private PlasticoDao plasticoDao;

    private PlasticoAdapter plasticoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo);

        //Room Database
        plasticoDataBase = PlasticoDataBase.getInstance(this);
        plasticoDao = plasticoDataBase.getDao();
        txtNombre = findViewById(R.id.txtNombre);
        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtOrigen = findViewById(R.id.txtOrigen);
        txtUbicacion = findViewById(R.id.txtUbicacion);
        //txtFotografia = findViewById(R.id.txtFotografia);
        btnGuardar = findViewById(R.id.btnGuardar);
        plasticosRecycler = findViewById(R.id.plasticosRecycler);
        //spinner
        conSpinner = findViewById(R.id.conSpinner);
        String[] categoriasPresentacion = {"PET","HDPE","PVC","LDPE","PP","PS","Otros"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriasPresentacion);
        conSpinner.setAdapter(adapter);

        plasticoAdapter = new PlasticoAdapter(this, this);
        plasticosRecycler.setAdapter(plasticoAdapter);
        plasticosRecycler.setLayoutManager(new LinearLayoutManager(this));

        //fetchData();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = txtNombre.getText().toString();
                String descripcion = txtDescripcion.getText().toString();
                String usuario = txtUsuario.getText().toString();
                String origen = txtOrigen.getText().toString();
                String ubicacion = txtUbicacion.getText().toString();
                String categoria = conSpinner.getSelectedItem().toString();
                //String fotografia = txtFotografia.getText().toString();
                int fotografia = R.drawable.ldpe;
                //"HDPE","PVC","LDPE","PP","PS"
                if (categoria.equalsIgnoreCase("PET")){
                    fotografia = R.drawable.pet;
                }
                else if (categoria.equalsIgnoreCase("HDPE")){
                    fotografia = R.drawable.hdpe;
                }
                else if (categoria.equalsIgnoreCase("PVC")){
                    fotografia = R.drawable.pvc;
                }
                else if (categoria.equalsIgnoreCase("PP")){
                    fotografia = R.drawable.pp;
                }
                else if (categoria.equalsIgnoreCase("PS")){
                    fotografia = R.drawable.ps;
                }
                Plasticos plasticos = new Plasticos(0,nombre,descripcion,usuario,origen,ubicacion,categoria,fotografia);
                plasticoAdapter.addPlastico(plasticos);
                plasticoDao.insert(plasticos);

                txtNombre.setText("");
                txtDescripcion.setText("");
                txtUsuario.setText("");
                txtOrigen.setText("");
                txtUbicacion.setText("");
                conSpinner.setSelection(0);
                //txtFotografia.setText("");

                Toast.makeText(ConsumoActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void fetchData(){
        plasticoAdapter.clearData();
        List<Plasticos> plasticosList = plasticoDao.getAllPlasticos();
        for (int i = 0; i < plasticosList.size(); i++){
            Plasticos plasticos = plasticosList.get(i);
            plasticoAdapter.addPlastico(plasticos);
        }
    }

    @Override
    public void OnUpdate(Plasticos plasticos) {
        Intent intent = new Intent(this,UpdateActivity.class);
        intent.putExtra("model",plasticos);
        startActivity(intent);

    }

    @Override
    public void OnDelete(int id, int pos) {
        plasticoDao.delete(id);
        plasticoAdapter.removePlastico(pos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }
}