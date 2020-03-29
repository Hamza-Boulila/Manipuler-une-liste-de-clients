package com.example.manipuler;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioGroup;
import java.util.ArrayList;

public class GridViewClientSaisie extends AppCompatActivity {
    ArrayList<Client> listClient = new ArrayList<>();
    ArrayAdapter<String> adapter=null;
    String[] T; // = {"A","B","C","D","E","F","G","H","I"};;
    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_client_saisie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button save=(Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client cl = new Client();
                EditText nom=(EditText) findViewById(R.id.nom);
                EditText prenom=(EditText) findViewById(R.id.prenom);
                cl.setNom(nom.getText().toString());
                cl.setPrenom(prenom.getText().toString());
                RadioGroup sexes=(RadioGroup) findViewById(R.id.sexes);
                switch (sexes.getCheckedRadioButtonId()) {
                    case R.id.homme:
                        cl.setSexe("Homme");
                        break;
                    case R.id.femme:
                        cl.setSexe("Femme");
                        break;
                }
                listClient.add(cl);
                T = new String[3*listClient.size()];
                for(int i =0;i<listClient.size();i++){
                    T[3*i] = listClient.get(i).getNom();
                    T[3*i+1] = listClient.get(i).getPrenom();
                    T[3*i+2] = listClient.get(i).getSexe();
                }

//Toast.makeText(getApplicationContext(),listClient.get(0).getNom(),Toast.LENGTH_LONG).show();
                gv=(GridView) findViewById(R.id.gv);
                adapter = new
                        ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,
                        T);
                gv.setAdapter(adapter);

            }
        });
    }

}
