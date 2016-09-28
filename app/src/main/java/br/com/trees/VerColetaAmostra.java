package br.com.trees;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Fernando on 25/09/2016.
 */
public class VerColetaAmostra extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_amostra);

        Bundle extras = getIntent().getExtras();

        Long s = extras.getLong("idAmostra");
        Toast.makeText(this, s.toString(), Toast.LENGTH_LONG).show();
    }

}
