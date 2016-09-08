package br.com.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Fernando on 30/08/2016.
 * Esta classe é responsavel por conectar no caminho do json e converter o arquivo em String
 */
public class NetworkUtils {

    //Metodo respnsavel por carregar o objeto JSON
    public static String getJSONFromAPI(String url){
        String retorno = "";

        try{
            //Passando a url vinda por meio de uma String -> url
            URL apiEnd = new URL(url);
            int codigoResposta;
            HttpURLConnection conexao;
            InputStream is;

            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST){
                is = conexao.getInputStream();
            }else{
                is = conexao.getErrorStream();
            }

            retorno = converterInputStreaToString(is);
            is.close();
            conexao.disconnect();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return retorno;
    }


    private static String converterInputStreaToString(InputStream is){
        StringBuffer buffer = new StringBuffer();

        try{
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null){
                buffer.append(linha);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
