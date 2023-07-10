package com.spotfly.models;

public class MusicOnline extends Music implements Playable {
	private String plataforma;

    public MusicOnline(String titulo, String artista, String genero, int duracao, String plataforma) {
        super(titulo, artista, genero, duracao);
        this.plataforma = plataforma;
    }


    @Override
    public void reproduzir() {
        System.out.println("Tocando Agora(online): " + getTitulo() + " da plataforma " + plataforma);
    }
}
