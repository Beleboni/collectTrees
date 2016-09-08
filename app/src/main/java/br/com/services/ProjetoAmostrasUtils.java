package br.com.services;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.model.ProjetoAmostras;

/**
 * Created by Fernando on 31/08/2016.
 * Está classe monta a lista com as informações vindas do json
 */
public class ProjetoAmostrasUtils {

    //Recuperando o Json
    public List<ProjetoAmostras> getInformacao(String end){
        String json;
        ProjetoAmostras retorno;

        json = NetworkUtils.getJSONFromAPI(end);
        Log.i("TodosProjetosAmostras", json);

        return parseJson(json);
    }

    //Montando o objeto ao mesmo tempo de ler o json
    private List<ProjetoAmostras> parseJson(String json){
        List<ProjetoAmostras> projetoAmostras = new ArrayList<>();

        try{
            //Criando um novo obj do json Object
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("results");

            Log.i("Array", array.toString());

            for (int i = 0; i<array.length(); i++){
                //Criando um novo obj do tipo Projeto por Amostras
                ProjetoAmostras projetoAmostra = new ProjetoAmostras();
                //Pegando o primeiro registro do json
                JSONObject o = array.getJSONObject(i);
                //Populando o objeto em uma lista
                projetoAmostra.setNome(o.getString("nome"));
                projetoAmostra.setAreaInventariada(o.getDouble("areaInventariada"));
                projetoAmostra.setIndiceConfianca(o.getDouble("indiceConfianca"));
                projetoAmostra.setStatus(o.getString("status"));
            }
        }catch (JSONException e){
            e.printStackTrace();
            //Se acontecer algum erro ele retorna uma lista vazia
            return projetoAmostras;
        }

        //Retornando a lista populada
        return projetoAmostras;
    }


}
