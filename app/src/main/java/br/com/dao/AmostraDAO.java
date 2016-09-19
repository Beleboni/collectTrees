package br.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.BancoDados;
import br.com.model.Amostra;
import br.com.model.ProjetoAmostras;

/**
 * Created by Fernando on 01/09/2016.
 * Esta classe é responsavel por gerenciar os processos de cadastros, updates, selects no db
 */
public class AmostraDAO {

    //ACESSO AO BANCO
    SQLiteDatabase db;

    public AmostraDAO(Context context){
        //CHAMANDO A CLASSE BANCO
        db = BancoDados.getDB(context);
    }

    public void salvar(Amostra amostra){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ContentValues values = new ContentValues();
        values.put("nome", amostra.getNome());
        values.put("tamanho", amostra.getTamanho());
        values.put("id_projeto", amostra.getProjetoAmostra().getId());
        values.put("data_cadastro", dateFormat.format(amostra.getDataCadastro()));
        values.put("status", amostra.getStatus());

        db.insert("amostras", null, values);
    }


    public List<Amostra> listarPorProjeto(String idProjeto){
        String[] colunas = new String[]{"id", "nome", "tamanho", "status", "id_projeto"};
        String[] args = new String[]{idProjeto};

        Cursor c = db.query("amostras", colunas, "id_projeto = ?", args, null, null, null);

        List<Amostra>  amostras = new ArrayList<>();

        if (c.moveToFirst()) {
            do {
                Amostra amostra = new Amostra();
                amostra.setId(c.getLong(c.getColumnIndex("id")));
                amostra.setNome(c.getString(c.getColumnIndex("nome")));
                amostra.setTamanho(c.getDouble(c.getColumnIndex("tamanho")));
                amostra.setStatus(c.getString(c.getColumnIndex("status")));
                amostras.add(amostra);
            } while (c.moveToNext());
        }

        c.close();

        return amostras;
    }

    public Amostra buscar(String id){
        String[] colunas = new String[]{"id", "nome", "tamanho", "status", "id_projeto"};
        String[] args = new String[]{id};

        Cursor c = db.query("amostras", colunas, "id = ?", args, null, null, null);


        c.moveToFirst();
        Amostra amostra = new Amostra();
        amostra.setId(c.getLong(c.getColumnIndex("id")));
        amostra.setNome(c.getString(c.getColumnIndex("nome")));
        amostra.setTamanho(c.getDouble(c.getColumnIndex("tamanho")));
        amostra.setStatus(c.getString(c.getColumnIndex("status")));
        amostra.setProjetoAmostra(new ProjetoAmostras(c.getLong(c.getColumnIndex("id_projeto"))));
        return amostra;
    }


}
