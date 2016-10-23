package br.com.trees;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import br.com.dao.DadosProjetoCensoDAO;
import br.com.dao.ProjetoCensoDAO;
import br.com.model.JSON;
import br.com.model.ProjetoCenso;
import br.com.model.Send;

public class EnviaProjetoActivity extends Activity {

    private ProjetoCensoDAO projetoCensoDAO;

    private DadosProjetoCensoDAO dadosProjetoCensoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        Send send = Send.fromExtra(extras);
        projetoCensoDAO = new ProjetoCensoDAO(this);
        dadosProjetoCensoDAO = new DadosProjetoCensoDAO(this);

        try {
            String str = this.convertInJSON(send);
            Log.i("JSON", str);
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String convertInJSON(Send send) throws JSONException {
        switch (send.getTipoProjeto()) {
            case PROJETO_AMOSTRAS:
                return  null;

            case PROJETO_CENSO: {
                ProjetoCenso projetoCenso = projetoCensoDAO.buscar(send.getIdProjeto());
                projetoCenso.setDadosProjetoCensos(dadosProjetoCensoDAO.listarPorProjeto(
                        projetoCenso.getId().toString()));
                projetoCenso.setIdUsuario(send.getIdUsuario());
                return JSON.toString(projetoCenso);
            }

            default:
                return null;
        }
    }
}
