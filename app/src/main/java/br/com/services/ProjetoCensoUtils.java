package br.com.services;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.model.ProjetoCenso;

/**
 * Created by Fernando on 30/08/2016.
 * Está classe monta a lista com as informações vindas do json
 */
public class ProjetoCensoUtils {

    //Recuperando o Json
    public List<ProjetoCenso> getInformacao(String end){
        String json;
        ProjetoCenso retorno;

        json = NetworkUtils.getJSONFromAPI(end);
        Log.i("TodosProjetosCenso", json);

        return parseJson(json);
    }

    //Montado o objeto ao mesmo tempo de ler o json
    private List<ProjetoCenso> parseJson(String json){

        List<ProjetoCenso> projetoCensos  = new ArrayList<>();

        try{
            //Criando um novo obj do Json object
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("results");

            Log.i("Array", array.toString());


            for(int i = 0; i<array.length(); i++){
                //Criando um novo obj do tipo ProjetoCenso
                ProjetoCenso projetoCenso = new ProjetoCenso();
                //Pegando o primeiro registro do json
                JSONObject o = array.getJSONObject(i);
                //populando o objeto em uma lista
                projetoCenso.setNome(o.getString("nome"));
                projetoCenso.setAreaInventariada(o.getDouble("areaInventariada"));
                projetoCenso.setStatus(o.getString("status"));

                //Adcionando o projeto na lista
                projetoCensos.add(projetoCenso);
            }



        }catch (JSONException e){
            e.printStackTrace();
            //Se acontecer algum erro ele retorna uma lista vazia
            return projetoCensos;
        }

        //Retornando a lista populada
        return projetoCensos;
    }


}
