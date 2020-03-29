package com.example.manipuler;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GridViewClient extends AppCompatActivity {
    ArrayList<Client> listClient = new ArrayList<>();
    ArrayAdapter<String> adapter=null;
    String[] T; // = {"A","B","C","D","E","F","G","H","I"};;
    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_client);
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
        listClient.add(new Client("Alami","Khalid","Homme"));
        listClient.add(new Client("Wahbi","Rachid","Homme"));
        listClient.add(new Client("Naji","Sanae","Femme"));
        listClient.add(new Client("Talbi","Aicha","Femme"));
        gv=(GridView) findViewById(R.id.gv);
        Button save=(Button) findViewById(R.id.save);
        //adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,T);
        final String T[] = new String[3*listClient.size()];
        for(int i =0;i<listClient.size();i++){
            T[3*i] = listClient.get(i).getNom();
            T[3*i+1] = listClient.get(i).getPrenom();
            T[3*i+2] = listClient.get(i).getSexe();
        }

//Toast.makeText(getApplicationContext(),listClient.get(0).getNom(),Toast.LENGTH_LONG).show();
// gv=(GridView) findViewById(R.id.gv);

        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,T) ;
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                EditText nom=(EditText) findViewById(R.id.nom);
                EditText prenom=(EditText) findViewById(R.id.prenom);
                RadioGroup sexes=(RadioGroup) findViewById(R.id.sexes);
                nom.setText(T[position]);
                prenom.setText(T[position+1]);
                if (T[position+2] == "Homme"){
                    RadioButton homme = (RadioButton) findViewById(R.id.homme);
                    homme.setChecked(true);
                }
                else {
                    RadioButton femme = (RadioButton) findViewById(R.id.femme);
                    femme.setChecked(true);
                }
            }
        });
    }
}
