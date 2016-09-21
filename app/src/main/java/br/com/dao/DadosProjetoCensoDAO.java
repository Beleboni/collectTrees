package br.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;

import br.com.banco.BancoDados;
import br.com.model.DadosProjetoCenso;

/**
 * Created by Fernando on 20/09/2016.
 */
public class DadosProjetoCensoDAO {

    //ACESSO AO BANCO DE DADOS
    SQLiteDatabase db;

    public DadosProjetoCensoDAO(Context context){
        //CHAMANDO A CLASSE DO BANCO
        db = BancoDados.getDB(context);
    }

    public void salvar(DadosProjetoCenso dadosProjetoCenso){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ContentValues values = new ContentValues();
        values.put("id_projeto", dadosProjetoCenso.getProjetoCenso().getId());
        values.put("id_arvore", dadosProjetoCenso.getArvore().getId());
        values.put("cap", dadosProjetoCenso.getCap().toString());
        values.put("altura", dadosProjetoCenso.getAltura());
        values.put("data_cadastro", dateFormat.format(dadosProjetoCenso.getDataCadastro()));

        db.insert("dados_projeto_censo", null, values);
    }
}
