package br.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.banco.BancoDados;
import br.com.model.ProjetoCenso;

/**
 * Created by Fernando on 02/08/2016.
 */
public class ProjetoCensoDAO {

    SQLiteDatabase db;

    public ProjetoCensoDAO(Context context){
        db = BancoDados.getDB(context);
    }

    public void salvar(ProjetoCenso projetoCenso){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ContentValues values = new ContentValues();
        values.put("nomeProjeto", projetoCenso.getNome());
        values.put("areaInvetariada", projetoCenso.getAreaInventariada());
        values.put("dataCadastro", dateFormat.format(projetoCenso.getDataCadastro()));

        db.insert("projeto_censo", null, values);
    }
}
