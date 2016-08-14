package br.com.model;

import java.util.Date;

/**
 * Created by Fernando on 29/07/2016.
 */
public class ProjetoAmostras {

    private Long id;
    private String nome;
    private Float areaInventariada;
    private Float indiceConfianca;
    private String status;
    private Date dataCadastro;

    public ProjetoAmostras() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getAreaInventariada() {
        return areaInventariada;
    }

    public void setAreaInventariada(Float areaInventariada) {
        this.areaInventariada = areaInventariada;
    }

    public Float getIndiceConfianca() {
        return indiceConfianca;
    }

    public void setIndiceConfianca(Float indiceConfianca) {
        this.indiceConfianca = indiceConfianca;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
