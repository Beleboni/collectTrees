package br.com.enums;

import android.content.Context;

import br.com.dao.ProjetoCensoDAO;

/**
 * Created by Fernando on 22/10/2016.
 */
public enum TipoProjeto {

    PROJETO_CENSO(0) {
        @Override
        public void alterarStatus(Context context, Long idProjeto, Status novoStatus) {
            new ProjetoCensoDAO(context).alterarStatus(idProjeto, novoStatus);
        }
    },
    PROJETO_AMOSTRAS(1) {
        @Override
        public void alterarStatus(Context context, Long idProjeto, Status novoStatus) {

        }
    };

    private int codigo;

    private TipoProjeto (int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoProjeto from(int codigo) {
        for (TipoProjeto tp : TipoProjeto.values()) {
            if (tp.getCodigo() == codigo) {
                return tp;
            }
        }
        return null;
    }

    public abstract void alterarStatus(Context context, Long idProjeto, Status novoStatus);

}
