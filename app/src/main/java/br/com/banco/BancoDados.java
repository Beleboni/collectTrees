package br.com.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoDados {

	// Nome do banco
	private static final String NOME_BANCO = "collect_trees";
	// Controle de versao
	private static final int VERSAO_BANCO = 1;
	// Script para fazer drop na tabela
	private static final String[] SCRIPT_DATABASE_DELETE = new String[] { "DROP TABLE IF EXISTS projeto_censo;"
																		 };

	
	// Cria a tabela com o "_id" sequencial
	private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
            "create table projeto_censo(_id integer primary key, nome text, areaInventariada float, dataCadastro date, status text);"
	};

	private static SQLiteDatabase db;

	public static SQLiteDatabase getDB(Context ctx) {
		if (db == null) {			
			SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
			db = dbHelper.getWritableDatabase();
		}
		return db;
		
	}
	
	

}
