package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Fernando on 22/04/2016.
 */
public class PainelActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel);
    }

    public void novo_projeto_censo(View v){
        Intent abre_novo_censo = new Intent(this, NovoProjetoCenso.class);
        startActivity(abre_novo_censo);
    }

    public void novo_projeto_amostras(View v){
        Intent abre_novo_amostras = new Intent(this, NovoProjetoAmostra.class);
        startActivity(abre_novo_amostras);
    }

    public void todos_projetos_censo(View v){
        Intent abre_todos_projetos_censo = new Intent(this, TodosProjetosCenso.class);
        startActivity(abre_todos_projetos_censo);
    }

    public void todos_projetos_amostras(View v){
        Intent abre_todos_projetos_amostras  = new Intent(this, TodosProjetosAmostra.class);
        startActivity(abre_todos_projetos_amostras);
    }



}
