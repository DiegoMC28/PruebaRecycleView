package com.example.pruebarecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;


    private EditText ETaddText;
    private Button BTaddText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ETaddText = (EditText) findViewById(R.id.editTextAdd);
        BTaddText = (Button) findViewById(R.id.buttonAdd);
        BTaddText.setOnClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        /*
         * Si la colección de datos tiene un tamaño fijo utiliza:
         *  mRecyclerView.setHasFixedSize(true);
         *  para mejorar el rendimiento
         * */

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(this);


        //Precarga de datos de ejemplo
        for (int i = 0; i < 5; i++) {
            mAdapter.add(new Item(getResources().getDrawable(R.mipmap.ic_launcher), "Texto: " +i));
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {


            String texto = ETaddText.getText().toString();
            mAdapter.add(new Item(getResources().getDrawable(R.mipmap.ic_launcher), texto));





    }
}