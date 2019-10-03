package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listcompras;
    private List<Item> itens;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listcompras = findViewById(R.id.listCompras);
        findViewById(R.id.btnNovoItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novoItem();
            }
        });
    }

    private void novoItem() {
        Intent intent = new Intent(MainActivity.this, AdditemActivity.class);
        startActivity(intent);
    }
}
