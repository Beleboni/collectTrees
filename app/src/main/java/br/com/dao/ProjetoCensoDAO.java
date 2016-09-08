package br.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.BancoDados;
import br.com.model.ProjetoCenso;

/**
 * Created by Fernando on 02/08/2016.
 * Esta classe é responsavel por gerenciar os processos de cadastros, updates, selects no db
 */
public class ProjetoCensoDAO {

    SQLiteDatabase db;

    public ProjetoCensoDAO(Context context){
        db = BancoDados.getDB(context);
    }

    public void salvar(ProjetoCenso projetoCenso){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ContentValues values = new ContentValues();
        values.put("nome", projetoCenso.getNome());
        values.put("area_inventariada", projetoCenso.getAreaInventariada());
        values.put("status", projetoCenso.getStatus());
        values.put("data_cadastro", dateFormat.format(projetoCenso.getDataCadastro()));

        db.insert("projeto_censo", null, values);
    }

    public List<ProjetoCenso> listar(){

        String[] colunas = new String[]{"id", "nome", "area_inventariada", "status"};
        List<ProjetoCenso> projetoCensos;
        Cursor c = db.query("projeto_censo", colunas, null, null, null, null, null);

        projetoCensos = new ArrayList<ProjetoCenso>();
        if(c.moveToFirst()){
            do {
                ProjetoCenso projetoCenso = new ProjetoCenso();
                projetoCenso.setNome(c.getString(c.getColumnIndex("nome")));
                projetoCenso.setAreaInventariada(c.getDouble(c.getColumnIndex("area_inventariada".toString())));
                projetoCenso.setStatus(c.getString(c.getColumnIndex("status")));

                projetoCensos.add(projetoCenso);
            }while (c.moveToNext());
        }
        c.close();
        return projetoCensos;
    }


}
