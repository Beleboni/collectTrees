package br.com.trees;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.dao.ProjetoCensoDAO;
import br.com.model.ProjetoCenso;

/**
 * Created by Fernando on 28/07/2016.
 */
public class TodosProjetosCenso extends ListActivity {

    //PEGANDO OS DADOS
    ProjetoCensoAdapter adapter;
    List<ProjetoCenso> projetoCensos;
    ProjetoCensoDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_projetos_censo);

        //INSTANCIANDO O DAO
        dao = new ProjetoCensoDAO(this);
        projetoCensos = dao.listar();

        //PEGANDO DADOS DO ADAPTER
        adapter = new ProjetoCensoAdapter(this, R.layout.activity_lista_projetos_censo, projetoCensos);

        //PASSANDO O ADAPTER
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent it = new Intent(this, OpcoesCenso.class);
        it.putExtra("idProjetoCenso", this.adapter.getItem(position).getId().toString());
        startActivity(it);
    }

}
