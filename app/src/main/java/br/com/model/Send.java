package br.com.model;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Fernando on 22/10/2016.
 */
public class Send implements ToSendInterface {

    private static final String EXTRA_ID_PROJETO = "idProjeto";
    private static final String EXTRA_TIPO_PROJETO = "tipoProjeto";
    private static final String EXTRA_ID_USUARIO = "idUsuario";

    private Long idProjeto;
    private TipoProjeto tipoProjeto;
    private Long idUsuario;
    private String url;
    private String[] params;

    public Send() {}

    public Send(Long idprojeto, TipoProjeto tipoProjeto, String... params) {
        this.idProjeto = idprojeto;
        this.tipoProjeto = tipoProjeto;
        this.params = params;
    }

    public Send(Long idProjeto, TipoProjeto tipoProjeto) {
        this.idProjeto = idProjeto;
        this.tipoProjeto = tipoProjeto;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idprojeto) {
        this.idProjeto = idprojeto;
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipoProjeto tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String... params) {
        this.params = params;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public Long getId() {
        return this.getIdProjeto();
    }

    @Override
    public TipoProjeto getTipo() {
        return this.getTipoProjeto();
    }

    @Override
    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public static Send fromExtra(Bundle extras) {
        TipoProjeto tp = TipoProjeto.from(extras.getInt(EXTRA_TIPO_PROJETO));
        Send send = new Send(extras.getLong(EXTRA_ID_PROJETO), tp);
        send.setIdUsuario(extras.getLong(EXTRA_ID_USUARIO));
        return send;
    }

    public static void putExtra(Intent intent, ToSendInterface projeto) {
        intent.putExtra(EXTRA_ID_PROJETO, projeto.getId());
        intent.putExtra(EXTRA_TIPO_PROJETO, projeto.getTipo().getCodigo());
        intent.putExtra(EXTRA_ID_USUARIO, projeto.getIdUsuario());
    }

}
