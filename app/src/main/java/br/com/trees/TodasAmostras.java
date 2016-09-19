package br.com.trees;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.dao.AmostraDAO;
import br.com.dao.ProjetoAmostrasDAO;
import br.com.model.Amostra;
import br.com.model.ProjetoAmostras;

public class TodasAmostras extends ListActivity{

    //MENU DE NOVA AMOSTRA
    final int MENU_NOVA_AMOSTRA = 1;

    private ProjetoAmostrasDAO dao;
    private ProjetoAmostras projetoAmostras;

    //PEGANDO DADOS
    AmostrasAdapter adapter;
    List<Amostra> amostras;
    AmostraDAO amostraDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_amostras);

        //CONECTANDO AO BANCO
        dao = new ProjetoAmostrasDAO(this);
        //PEGANDO O ID PASSADO PELA TELA ANTERIOR
        Bundle extras = getIntent().getExtras();
        //PEGANDO O TEXTVIEW DA TELA
        TextView tvNomeProjeto = (TextView)findViewById(R.id.txt_nome_projeto);
        //CONSULTANDO ID PASSADO NO BANCO E RETORNANDO O POJETO ENCONTRADO
        projetoAmostras = dao.buscar(extras.getString("idProjetoAmostra"));
        //SETANDO O NOME DO PROJETO ENCONTRADO
        tvNomeProjeto.setText(projetoAmostras.getNome().toString());

        amostraDAO = new AmostraDAO(this);
        amostras = amostraDAO.listarPorProjeto(extras.getString("idProjetoAmostra"));

        adapter = new AmostrasAdapter(this,R.layout.activity_lista_amostras, amostras);

        setListAdapter(adapter);


        //INFORMANDO O NOME DO PROJETO ENCONTRADO
        //Toast.makeText(this, projetoAmostras.getId().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, projetoAmostras.getNome().toString(), Toast.LENGTH_SHORT).show();

    }


    //CRIANDO O MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_NOVA_AMOSTRA, 0, "Criar nova amostra");
        return true;
    }

    //PEGANDO AS AÇÕES DO MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_NOVA_AMOSTRA:
                Intent it = new Intent(this, NovaAmostra.class);
                it.putExtra("idProjetoAmostra", projetoAmostras.getId().toString());
                startActivity(it);
                break;
        }
        return true;
    }

    //PASSANDO O ID DA AMOSTRA PARA A OUTRA PAGINA

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent it = new Intent(this, OpcoesAmostra.class);
        it.putExtra("idAmostra", this.adapter.getItem(position).getId().toString());
        startActivity(it);
    }
}
