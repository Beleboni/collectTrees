package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Fernando on 28/07/2016.
 */
public class NovaAmostra extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amostra);
    }

    public void nova_amostra_amostra(View v){
        Intent abre_nova_amostra = new Intent(this, NovaAmostra.class);
        startActivity(abre_nova_amostra);
    }
}
