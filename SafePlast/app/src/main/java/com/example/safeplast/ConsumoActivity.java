package com.example.safeplast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ConsumoActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    RegisterFragment registerFragment = new RegisterFragment();
    EditFragment editFragment = new EditFragment();

   /* Spinner categoria = findViewById(R.id.categorySpinner);
    Spinner presentacion = findViewById(R.id.presentationSpinner);

    ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,
            R.array.categorias_, android.R.layout.simple_spinner_dropdown_item);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo);
        navigationView = findViewById(R.id.consumo_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.consumo_container,registerFragment).commit();

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.NewConsumo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.consumo_container, registerFragment).commit();
                    case R.id.EditConsumo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.consumo_container, editFragment).commit();
                    case R.id.ListConsumo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.consumo_container, registerFragment).commit();
                    case R.id.DeleteConsumo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.consumo_container, editFragment).commit();
                }
                return false;
            }
        });
    }
}