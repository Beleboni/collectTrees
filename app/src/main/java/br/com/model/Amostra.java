package br.com.model;

import java.util.Date;

/**
 * Created by Fernando on 29/07/2016.
 */
public class Amostra {

    private Long id;
    private ProjetoAmostras idProjeto;
    private String nome;
    private Float tamanho;
    private String status;
    private Date dataCadastro;

    public Amostra() {
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ProjetoAmostras getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(ProjetoAmostras idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
