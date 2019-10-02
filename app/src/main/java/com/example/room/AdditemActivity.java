package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AdditemActivity extends AppCompatActivity {

    private EditText editNome, editQtde;

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
    }
}
