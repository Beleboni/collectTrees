package br.com.trees;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.List;

import br.com.dao.ArvoreDAO;
import br.com.model.Arvore;

/**
 * Created by Fernando on 11/09/2016.
 */
public class DefineArvoreCenso extends Activity {

    AutoCompleteTextView acBuscar;

    List<Arvore> arvores;

    ArrayAdapter<Arvore> adapter;

    ArvoreDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_arvore_censo);

        dao = new ArvoreDAO(this);
        arvores = dao.listar();
        adapter = new ArrayAdapter<>(this, R.layout.activity_search_arvore_item, arvores);

        acBuscar = (AutoCompleteTextView) findViewById(R.id.ac_buscar);
        acBuscar.setAdapter(adapter);
        acBuscar.setThreshold(1);

        acBuscar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent abre_novo_censo = new Intent(this, NovoProjetoCenso.class);
//                startActivity(abre_novo_censo);
            }
        });
    }
}
