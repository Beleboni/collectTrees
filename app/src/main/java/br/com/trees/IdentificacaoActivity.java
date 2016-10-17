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
import br.com.validator.Validator;

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

    public void sendJson(View v){
        //VERIFICANDO SE OS CAMPOS ESTÃO VAZIOS
        if(Validator.validateEmptyField(this, txtLogin, txtSenha)) {
            Usuario usuario = new Usuario();
            usuario.setLogin(txtLogin.getText().toString());
            usuario.setSenha(txtSenha.getText().toString());
            String json = generateJSON(usuario);
            callServer("send-json", json);
        }
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

    private Usuario degenerateJSON(String data){
        Usuario usuario = new Usuario();

        try{
            JSONObject jo = new JSONObject(data);

            usuario.setId(jo.getLong("id"));
            usuario.setLogin(jo.getString("login"));
            usuario.setSenha(jo.getString("senha"));

            Log.i("usuario", usuario.toString());

        }catch (JSONException e){
            e.printStackTrace();
        }
        return (usuario);
    }

    @SuppressLint("NewApi")
    private void callServer(final String method, final String data){

        new Thread(){
            public  void run(){
                String answer = HttpConnection.getSetDataWeb("http://www.institutofernandobeleboni.com.br/" +
                        "florestsimulator/json/progressUsuario.php", method, data);
                Log.i("Script", "ANSWER: " + answer);
                degenerateJSON(answer);
            }
        }.start();
    }

}
