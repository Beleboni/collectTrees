package br.com.trees;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.dao.ArvoreDAO;
import br.com.dao.ProjetoCensoDAO;
import br.com.model.Arvore;
import br.com.model.ProjetoCenso;

public class OpcoesCenso extends Activity {

    AutoCompleteTextView acBuscar;
    List<Arvore> arvores;
    ArrayAdapter<Arvore> adapter;
    ArvoreDAO arvoreDAO;
    private ProjetoCensoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_censo);

        //CONECTANDO AO BANCO
        dao = new ProjetoCensoDAO(this);
        //PEGANDO O ID PASSADO PELA TELA ANTERIOR
        Bundle extras = getIntent().getExtras();
        //PEGANDO O TEXTVIEW DA TELA
        TextView tvNomeProjeto = (TextView)findViewById(R.id.tv_nome_projeto);
        //CONSULTANDO O ID PASSADO NO BANCO E RETORNANDO O PROJETO ENCONTRADO
        ProjetoCenso projetoCenso = dao.buscar(extras.getString("idProjetoCenso"));
        //SETANDO O NOME DO PROJETO ENCONTRADO
        tvNomeProjeto.setText(projetoCenso.getNome().toString());
        //INFORMANDO O USUARIO DO PROJETO SELECIONADO
        Toast.makeText(this, projetoCenso.getId().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, projetoCenso.getNome().toString(), Toast.LENGTH_SHORT).show();

        //AUTO COMPLETE
        arvoreDAO = new ArvoreDAO(this);
        arvores = arvoreDAO.listar();
        adapter = new ArrayAdapter<>(this, R.layout.activity_search_arvore_item, arvores);

        acBuscar = (AutoCompleteTextView) findViewById(R.id.ac_buscar);
        acBuscar.setAdapter(adapter);
        acBuscar.setThreshold(1);

        acBuscar.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //PEGANDO AS INFORMAÇÕES DA ARVORE ESCOLHIDA PELO CLIENTE
                Arvore arvore = (Arvore)((ListView) parent).getAdapter().getItem(position);
                Toast.makeText(OpcoesCenso.this, arvore.getId().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(OpcoesCenso.this, arvore.getNomeCientifico(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
