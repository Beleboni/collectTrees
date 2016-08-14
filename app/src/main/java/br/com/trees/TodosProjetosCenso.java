package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Fernando on 28/07/2016.
 */
public class TodosProjetosCenso extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_projetos_censo);
    }

    public void todos_projeto_censo(View v){
        Intent abre_todos_censo = new Intent(this, TodosProjetosCenso.class);
        startActivity(abre_todos_censo);
    }
}
