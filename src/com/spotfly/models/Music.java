package com.spotfly.models;

public class Music implements Playable {
    private static int contadorMusicas = 0;
    private String titulo;
    private String artista;
    private String genero;
    private int duracaoSegundos;

    public Music(String titulo, String artista, String genero, int duracaoSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracaoSegundos = duracaoSegundos;
        contadorMusicas++; 
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }
    

    public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
    public void reproduzir() {
        System.out.println("Tocando agora: " + getTitulo());
    }

    public static int getContadorMusicas() {
        return contadorMusicas;
    }
}

