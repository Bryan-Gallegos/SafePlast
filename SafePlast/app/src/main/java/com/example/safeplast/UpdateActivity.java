package com.example.safeplast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.safeplast.Room.PlasticoDao;
import com.example.safeplast.Room.PlasticoDataBase;
import com.example.safeplast.Room.Plasticos;

public class UpdateActivity extends AppCompatActivity {

    private EditText txtNombre, txtDescripcion, txtUsuario, txtOrigen, txtUbicacion, txtFotografia;
    private Button btnActualizar;
    private Spinner conSpinner;
    private Plasticos plasticos;

    private PlasticoDataBase plasticoDataBase;
    private PlasticoDao plasticoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        plasticoDataBase = PlasticoDataBase.getInstance(this);
        plasticoDao = plasticoDataBase.getDao();

        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtOrigen = findViewById(R.id.txtOrigen);
        txtUbicacion = findViewById(R.id.txtUbicacion);
        //txtFotografia = findViewById(R.id.txtFotografia);
        btnActualizar = findViewById(R.id.btnActualizar);
        //spinner
        conSpinner = findViewById(R.id.conSpinner);
        String[] categoriasPresentacion = {"PET","HDPE","PVC","LDPE","PP","PS","Otros"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriasPresentacion);
        conSpinner.setAdapter(adapter);

        plasticos =(Plasticos) getIntent().getSerializableExtra("model");

        txtNombre.setText(plasticos.getNombre());
        txtDescripcion.setText(plasticos.getDescripcion());
        txtUsuario.setText(plasticos.getUsuario());
        txtOrigen.setText(plasticos.getOrigen());
        txtUbicacion.setText(plasticos.getUbicacion());
        int aux = 0;
        if(plasticos.getCategoria().equals(categoriasPresentacion[1]))
            aux = 1;
        else if(plasticos.getCategoria().equals(categoriasPresentacion[2]))
            aux = 2;
        else if(plasticos.getCategoria().equals(categoriasPresentacion[3]))
            aux = 3;
        else if(plasticos.getCategoria().equals(categoriasPresentacion[4]))
            aux = 4;
        else if(plasticos.getCategoria().equals(categoriasPresentacion[5]))
            aux = 5;
        else if(plasticos.getCategoria().equals(categoriasPresentacion[6]))
            aux = 6;
        conSpinner.setSelection(aux);
        //txtFotografia.setText(plasticos.getFotografia());

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Plasticos plasticoModel = new Plasticos(plasticos.getId(),txtNombre.getText().toString(),txtDescripcion.getText().toString(),txtUsuario.getText().toString(),txtOrigen.getText().toString(),txtUbicacion.getText().toString(),conSpinner.getSelectedItem().toString(),R.drawable.ic_baseline_person_24);
                plasticoDao.update(plasticoModel);
                finish();
            }
        });

    }
}