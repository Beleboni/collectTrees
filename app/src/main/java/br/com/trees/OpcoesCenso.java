package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.dao.ProjetoCensoDAO;
import br.com.model.ProjetoCenso;

public class OpcoesCenso extends Activity {


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
    }

    public void define_arvore_censo(View v){
        Intent abre_define_arvore_censo = new Intent(this, DefineArvoreCenso.class);
        startActivity(abre_define_arvore_censo);
    }

}
