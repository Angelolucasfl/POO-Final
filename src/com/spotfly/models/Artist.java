package com.spotfly.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Artist {
    private String nome;
    private String nacionalidade;
    private List<Album> albuns;

    public Artist(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.albuns = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void adicionarAlbum(Album album) {
        albuns.add(album);
    }

    public void removerAlbum(Album album) {
        albuns.remove(album);
    }
}

