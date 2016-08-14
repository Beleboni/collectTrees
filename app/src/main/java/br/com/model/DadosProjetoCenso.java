package br.com.model;

import java.util.Date;

/**
 * Created by Fernando on 29/07/2016.
 */
public class DadosProjetoCenso {

    private Long id;
    private ProjetoCenso idProjeto;
    private Float cap;
    private Float dap;
    private Date dataCadastro;

    public DadosProjetoCenso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjetoCenso getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(ProjetoCenso idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Float getCap() {
        return cap;
    }

    public void setCap(Float cap) {
        this.cap = cap;
    }

    public Float getDap() {
        return dap;
    }

    public void setDap(Float dap) {
        this.dap = dap;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
