package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdditemActivity extends AppCompatActivity {

    private EditText editNome, editQtde;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        editNome=findViewById(R.id.editNome);
        editQtde=findViewById(R.id.editQtde);

        findViewById(R.id.btnSalvar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarItem();
            }
        });
    }

    private void salvarItem() {
        String nome=editNome.getText().toString().trim();
        String qtde_s=editQtde.getText().toString().trim();

        if(nome.isEmpty()){
            editNome.setError("Campo nome obrigatorio.");
            editNome.requestFocus();
            return;
        }
        if(qtde_s.isEmpty()){
            editQtde.setError("campo quantidade obrigatorio.");
            editQtde.requestFocus();
            return;
        }
        db = AppDatabase.getInstance(getApplicationContext());
        Item item = new Item(nome, Integer.parseInt(qtde_s));

        long resultado = db.itemDAO().insert(item);

        if(resultado > 0){
            Toast.makeText(this, "Item salvo!", Toast.LENGTH_SHORT).show();
            voltar();
        }else{
            Toast.makeText(this, "Erro ao salvar!", Toast.LENGTH_SHORT).show();
        }
    }

    private void voltar() {
        Intent intent = new Intent(AdditemActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
