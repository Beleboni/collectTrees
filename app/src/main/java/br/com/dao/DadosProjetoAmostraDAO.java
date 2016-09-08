package br.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.banco.BancoDados;
import br.com.model.DadosProjetoAmostra;

/**
 * Created by Fernando on 01/09/2016.
 * Esta classe é responsavel por gerenciar os processos de cadastros, updates, selects no db
 */
public class DadosProjetoAmostraDAO {

    //ACESSO AO BANCO DE DADOS
    SQLiteDatabase db;

    public DadosProjetoAmostraDAO(Context context){
        //CHAMANDO A CLASSE DO BANCO
        db = BancoDados.getDB(context);
    }

    public void salvar(DadosProjetoAmostra dadosProjetoAmostra){
        ContentValues values = new ContentValues();
        values.put("idArvore", dadosProjetoAmostra.getIdArvore().toString());
        values.put("idProjeto", dadosProjetoAmostra.getIdProjeto().toString());
        values.put("idAmostra", dadosProjetoAmostra.getIdAmostra().toString());
        values.put("cap", dadosProjetoAmostra.getCap());
        values.put("altura", dadosProjetoAmostra.getAltura());

        db.insert("dados_projeto_amostra", null, values);
    }
}
