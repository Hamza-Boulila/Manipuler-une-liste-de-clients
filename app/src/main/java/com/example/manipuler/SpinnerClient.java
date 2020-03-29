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
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class SpinnerClient extends AppCompatActivity {
    List<Client> listClient=new ArrayList<>();
    ArrayAdapter<Client> adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_client);
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
        adapter=new
                ArrayAdapter<Client>(this,android.R.layout.simple_list_item_1,listClient);
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
                Spinner combo=(Spinner) findViewById(R.id.CboClients);
                combo.setAdapter(adapter);
            }
        });
    }

}
