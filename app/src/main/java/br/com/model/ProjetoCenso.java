package br.com.model;

import java.util.Date;

/**
 * Created by Fernando on 29/07/2016.
 */
public class ProjetoCenso {

    private Long id;
    private String nome;
    private Double areaInventariada;
    private String status;
    private Date dataCadastro;

    public ProjetoCenso() {
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAreaInventariada() {
        return areaInventariada;
    }

    public void setAreaInventariada(Double areaInventariada) {
        this.areaInventariada = areaInventariada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
