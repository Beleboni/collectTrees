package br.com.trees;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.model.Usuario;
import br.com.services.HttpConnection;

/**
 * Created by Fernando on 15/10/2016.
 * Está tela serve para identificar o usuario quando vai se conectar ao sistema web
 */
public class IdentificacaoActivity extends Activity {

    //PEGANDO AS VARIAVEIS
    EditText txtLogin, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin = (EditText) findViewById(R.id.txt_login);
        txtSenha = (EditText) findViewById(R.id.txt_senha);
    }

//    public void getIdentificacao(View v){
//        String login = txtLogin.getText().toString();
//        String senha = txtSenha.getText().toString();
//
//        // Instância
//        //AlertDialog.Builder dialogo = new AlertDialog.Builder(IdentificacaoActivity.this);
//        // setando título
//        //dialogo.setTitle("Resultado");
//        // setando mensagem
//        //dialogo.setMessage("Login: " + login + " Senha: " + senha);
//        // setando botão
//        //dialogo.setNeutralButton("OK", null);
//        // chamando o AlertDialog
//        //dialogo.show();
//
//
//    }

    public void sendJson(View v){
        Usuario usuario = new Usuario();
        usuario.setLogin(txtLogin.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());

        String json = generateJSON(usuario);

        callServer("send-json", json);
    }

    public String generateJSON(Usuario usuario){
        JSONObject jo = new JSONObject();

        try{
            jo.put("login", usuario.getLogin());
            jo.put("senha", usuario.getSenha());
        }catch (JSONException e){
            e.printStackTrace();
        }
        return (jo.toString());
    }

    @SuppressLint("NewApi")
    private void callServer(final String method, final String data){
        new Thread(){
            public  void run(){
                String answer = HttpConnection.getSetDataWeb("http://www.institutofernandobeleboni.com.br/florestsimulator/json/progressUsuario.php", method, data);
                Log.i("Script", "ANSWER: " + answer);
            }
        }.start();
    }
}
