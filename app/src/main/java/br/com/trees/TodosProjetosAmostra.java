package br.com.trees;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import br.com.dao.ProjetoAmostrasDAO;
import br.com.model.ProjetoAmostras;

/**
 * Created by Fernando on 28/07/2016.
 */
public class TodosProjetosAmostra extends ListActivity {

    //PEGANDO OS DADOS
    ProjetoAmostrasAdapter adapter;
    List<ProjetoAmostras> projetoAmostras;
    ProjetoAmostrasDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_projetos_amostras);

        //INSTANCIANDO O DAO
        dao = new ProjetoAmostrasDAO(this);
        projetoAmostras = dao.listar();

        //PEGANDO DADOS DO ADAPTER
        adapter = new ProjetoAmostrasAdapter(this, R.layout.activicty_lista_projetos_amostras, projetoAmostras);

        //PASSANDO O ADAPTER
        setListAdapter(adapter);

    }

    public void abre_todas_amostras(View v){
        Intent abre_todas_amostras = new Intent(this, TodasAmostras.class);
        startActivity(abre_todas_amostras);
    }
}
