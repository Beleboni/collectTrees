package br.com.builder;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.dao.ArvoreDAO;
import br.com.model.Arvore;

/**
 * Created by Fernando on 11/09/2016.
 */
public class ArvoreBuilder {

    private static List<Arvore> arvores;

    static {
        arvores = new ArrayList<>();
        arvores.add(new Arvore("Sibipiruma", "Caesalpinia peltophoroides", "Leguminosae Caesalpinoideae", 0.5));
    }

    public static void build(Context context) {
        ArvoreDAO arvoreDAO = new ArvoreDAO(context);
        if (!arvoreDAO.hasArvores()) {
            for (Arvore a : arvores) {
                arvoreDAO.salvar(a);
            }
        }
    }

}
