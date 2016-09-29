package br.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.BancoDados;
import br.com.model.Arvore;
import br.com.model.DadosProjetoAmostra;

/**
 * Created by Fernando on 01/09/2016.
 * Esta classe é responsavel por gerenciar os processos de cadastros, updates, selects no db
 */
public class DadosProjetoAmostraDAO {

    //ACESSO AO BANCO DE DADOS
    SQLiteDatabase db;

    ArvoreDAO arvoreDAO;

    public DadosProjetoAmostraDAO(Context context){
        //CHAMANDO A CLASSE DO BANCO
        db = BancoDados.getDB(context);
        this.arvoreDAO = new ArvoreDAO(context);
    }

    public void salvar(DadosProjetoAmostra dadosProjetoAmostra){
        ContentValues values = new ContentValues();
        values.put("id_arvore", dadosProjetoAmostra.getArvore().getId());
        values.put("id_projeto", dadosProjetoAmostra.getProjetoAmostras().getId());
        values.put("id_amostra", dadosProjetoAmostra.getAmostra().getId());
        values.put("cap", dadosProjetoAmostra.getCap());
        values.put("altura", dadosProjetoAmostra.getAltura());

        db.insert("dados_projeto_amostra", null, values);

    }

    public List<DadosProjetoAmostra> listarPorAmostra(String idAmostra){
        String[] colunas = new String[]{"id", "id_arvore", "altura", "cap", "id_amostra", "id_projeto"};
        String[] args = new String[]{idAmostra};

        Cursor c = db.query("dados_projeto_amostra", colunas, "id_amostra = ?", args, null, null, null);

        List<DadosProjetoAmostra>  dpcs = new ArrayList<>();

        if (c.moveToFirst()) {
            do {
                DadosProjetoAmostra dpc = new DadosProjetoAmostra();

                dpc.setAltura(c.getDouble(c.getColumnIndex("altura")));
                dpc.setCap(c.getDouble(c.getColumnIndex("cap")));

                Arvore arvore = arvoreDAO.buscar(c.getLong(c.getColumnIndex("id_arvore")));
                dpc.setArvore(arvore);

                dpcs.add(dpc);
            } while (c.moveToNext());
        }

        c.close();

        return dpcs;
    }

}
