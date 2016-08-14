package br.com.model;

import java.util.Date;

/**
 * Created by Fernando on 29/07/2016.
 */
public class DadosProjetoAmostra {

    private Long id;
    private Amostra idAmostra;
    private ProjetoAmostras idProjeto;
    private Arvore idArvore;
    private Float cap;
    private Float dap;
    private Date dataCadastro;

    public DadosProjetoAmostra() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Amostra getIdAmostra() {
        return idAmostra;
    }

    public void setIdAmostra(Amostra idAmostra) {
        this.idAmostra = idAmostra;
    }

    public ProjetoAmostras getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(ProjetoAmostras idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Arvore getIdArvore() {
        return idArvore;
    }

    public void setIdArvore(Arvore idArvore) {
        this.idArvore = idArvore;
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
