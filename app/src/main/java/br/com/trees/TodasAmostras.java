package br.com.trees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TodasAmostras extends Activity {
    //MENU DE NOVA AMOSTRA
    final int MENU_NOVA_AMOSTRA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_amostras);
    }


    //CRIANDO O MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_NOVA_AMOSTRA, 0, "Criar nova amostra");
        return true;
    }

    //PEGANDO AS AÇÕES DO MENU

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_NOVA_AMOSTRA:
                Intent it = new Intent(this, NovaAmostra.class);
                startActivity(it);
                break;
        }
        return true;
    }
}
