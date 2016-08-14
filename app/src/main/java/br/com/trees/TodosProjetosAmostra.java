package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Fernando on 28/07/2016.
 */
public class TodosProjetosAmostra extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_projetos_amostras);
    }

    public void todo_projeto_amaostra(View v){
        Intent todos_amostras = new Intent(this, TodosProjetosAmostra.class);
        startActivity(todos_amostras);
    }
}
