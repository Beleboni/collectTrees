package br.com.trees;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import br.com.dao.ProjetoCensoDAO;
import br.com.model.ProjetoCenso;

/**
 * Created by Fernando on 21/09/2016.
 */
public class VerColetaCenso extends Activity {

    ProjetoCensoDAO projetoCensoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coletadas_censo);

        projetoCensoDAO = new ProjetoCensoDAO(this);
        Bundle extras = getIntent().getExtras();

        Long s = extras.getLong("idProjetoCenso");

        TextView tvNomeProjeto = (TextView)findViewById(R.id.txt_nome_projeto_censo);
        ProjetoCenso projetoCenso = projetoCensoDAO.buscar(s);
        tvNomeProjeto.setText(projetoCenso.getNome());
        Toast.makeText(this, projetoCenso.getNome(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, extras.getString("idProjetoCenso"), Toast.LENGTH_LONG).show();
    }
}
