package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Fernando on 29/07/2016.
 */
public class DadosProjetoAmostra extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_censo);
    }

    public void dados_projeto_amostra(View v){
        Intent abre_dados_amostra = new Intent(this, DadosProjetoAmostra.class);
        startActivity(abre_dados_amostra);
    }
}
