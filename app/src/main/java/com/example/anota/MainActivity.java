package com.example.anota;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //private FloatingActionButton BotaoSalvar;
    private AnotacaoPreferencia preferencia;
    private EditText editAnotacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencia = new AnotacaoPreferencia( getApplicationContext() );

        FloatingActionButton BotaoSalvar = findViewById(R.id.BotaoSalvar);

        BotaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar se foi digitado algo
                String textoRecuperado = editAnotacao.getText().toString();
                if ( textoRecuperado.equals("") ){
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                }else {
                    preferencia.salvarAnotacao( textoRecuperado );
                    Snackbar.make(view, "Anotacao Salva com Sucesso", Snackbar.LENGTH_LONG).show();
                }

                //Snackbar.make(view, "Substitua por sua própria ação", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
            }
        });

        // Recuperar Anotacao
        String anotacao =  preferencia.recuperarAnotacao();
        if ( !anotacao.equals("") ){
            editAnotacao.setText( anotacao );
        }
    }
}