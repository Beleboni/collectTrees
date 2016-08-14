package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Fernando on 29/07/2016.
 */
public class DefineArvoreCenso extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_arvore_censo);
    }

    public void define_arvore_censo(View v){
        Intent abre_define_arvore_censo = new Intent(this, DefineArvoreCenso.class);
        startActivity(abre_define_arvore_censo);
    }
}
