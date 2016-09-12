package br.com.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.banco.BancoDados;
import br.com.model.Amostra;

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
        ContentValues values = new ContentValues();
        values.put("nome", amostra.getNome());
        values.put("tamanho", amostra.getTamanho());
        values.put("id_projeto", amostra.getIdProjeto().toString());

        db.insert("amostra", null, values);
    }

//    public List<Amostra> listar(){
//
//        String[] colunas = new String[]{"id", "id_projeto", "nome", "tamanho"};
//        List<Amostra> amostras;
//        Cursor c = db.query("amostra", colunas, null, null, null, null, null);
//
//        amostras = new ArrayList<Amostra>();
//        if(c.moveToFirst()){
//            do{
//                Amostra a = new Amostra();
//                a.getNome()
//            }
//        }
//
//    }


}
