package br.com.trees;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.dao.DadosProjetoAmostraDAO;
import br.com.dao.ProjetoAmostrasDAO;
import br.com.model.DadosProjetoAmostra;
import br.com.model.ProjetoAmostras;

/**
 * Created by Fernando on 25/09/2016.
 */
public class VerColetaAmostra extends ListActivity {

    ProjetoAmostrasDAO projetoAmostrasDAO;

    List<DadosProjetoAmostra> dadosProjetoAmostraList;
    DadosProjetoAmostraDAO dao;

    ColetaAmostraAdapter coletaAmostraAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coletadas_amostra);

        projetoAmostrasDAO = new ProjetoAmostrasDAO(this);
        dao = new DadosProjetoAmostraDAO(this);

        Bundle extras = getIntent().getExtras();

        String idAmostra = extras.getString("idAmostra");

        TextView tvNomeAmostra = (TextView)findViewById(R.id.txt_nome_amostra);
        ProjetoAmostras projetoAmostras = projetoAmostrasDAO.buscar(idAmostra);

        tvNomeAmostra.setText(projetoAmostras.getNome());
        Toast.makeText(this, projetoAmostras.getNome(), Toast.LENGTH_LONG).show();

        dadosProjetoAmostraList = dao.listarPorAmostra(idAmostra);

        //ADAPTER
        coletaAmostraAdapter = new ColetaAmostraAdapter(this, R.layout.activity_lista_dados_amostra, dadosProjetoAmostraList);

        setListAdapter(coletaAmostraAdapter);
    }

}
