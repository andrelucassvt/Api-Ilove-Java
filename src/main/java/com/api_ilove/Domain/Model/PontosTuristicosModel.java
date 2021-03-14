package com.api_ilove.Domain.Model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PontosTuristicos")
public class PontosTuristicosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private MunicipioModel municipioModel;

    @NotBlank
    @Size(min = 2,max = 40)
    private String nome;

    @NotBlank
    private String latitude;
    @NotBlank
    private String longitude;
    @NotBlank
    private String descricao;


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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public MunicipioModel getMunicipioModel() {
        return municipioModel;
    }

    public void setMunicipioModel(MunicipioModel municipioModel) {
        this.municipioModel = municipioModel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}