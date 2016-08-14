package br.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.banco.BancoDados;
import br.com.model.ProjetoAmostras;

/**
 * Created by Fernando on 02/08/2016.
 */
public class ProjetoAmostrasDAO {

    SQLiteDatabase db;

    public ProjetoAmostrasDAO(Context context){
        db = BancoDados.getDB(context);
    }

    public void salvar(ProjetoAmostras projetoAmostras){
        ContentValues values = new ContentValues();
        values.put("nome", projetoAmostras.getNome());
        values.put("areaInventariada", projetoAmostras.getAreaInventariada());
        values.put("indiceConfianca", projetoAmostras.getIndiceConfianca());
        values.put("status", projetoAmostras.getStatus());

        db.insert("projeto_amostras", null, values);
    }
}
