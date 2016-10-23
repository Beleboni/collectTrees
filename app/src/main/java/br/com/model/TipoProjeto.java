package br.com.model;

/**
 * Created by Fernando on 22/10/2016.
 */
public enum TipoProjeto {

    PROJETO_CENSO(0),
    PROJETO_AMOSTRAS(1);

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

}
