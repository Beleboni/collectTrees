package br.com.trees;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.dao.AmostraDAO;
import br.com.dao.ArvoreDAO;
import br.com.model.Amostra;
import br.com.model.Arvore;

/**
 * Created by Fernando on 18/09/2016.
 */
public class OpcoesAmostra extends Activity {

    AutoCompleteTextView acBuscar;
    List<Arvore> arvores;
    ArrayAdapter<Arvore> adapter;
    ArvoreDAO arvoreDAO;
    private AmostraDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_censo);

        //CONECTANDO AO BANCO
        dao = new AmostraDAO(this);
        //PEGANDO O ID PASSADO PELA TELA ANTERIOR
        Bundle extras = getIntent().getExtras();
        //PEGANDO O TEXTVIEW DA TELA
        TextView tvNomeProjeto = (TextView)findViewById(R.id.tv_nome_projeto);
        //CONSULTANDO O ID PASSADO NO BANCO E RETORNANDO O PROJETO ENCONTRADO
        Amostra amostra = dao.buscar(extras.getString("idAmostra"));
        //SETANDO O NOME DO PROJETO ENCONTRADO
        tvNomeProjeto.setText(amostra.getNome());
        //INFORMANDO O USUARIO DO PROJETO SELECIONADO
        Toast.makeText(this, amostra.getId().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, amostra.getNome(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, amostra.getProjetoAmostra().getId().toString(), Toast.LENGTH_SHORT).show();

        //AUTO COMPLETE
        arvoreDAO = new ArvoreDAO(this);
        arvores = arvoreDAO.listar();
        adapter = new ArrayAdapter<>(this, R.layout.activity_search_arvore_item, arvores);

        acBuscar = (AutoCompleteTextView) findViewById(R.id.ac_buscar);
        acBuscar.setAdapter(adapter);
        acBuscar.setThreshold(1);


    }
}
