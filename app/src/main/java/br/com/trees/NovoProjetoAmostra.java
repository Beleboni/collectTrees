package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Fernando on 28/07/2016.
 */
public class NovoProjetoAmostra extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_projeto_amostra);
    }

//    public void novo_projeto_amostras(View v){
//        Intent abre_novo_projeto_amostras = new Intent(this, NovoProjetoAmostra.class);
//        startActivity(abre_novo_projeto_amostras);
//    }
}
