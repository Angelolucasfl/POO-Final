package com.spotfly.models;

import java.util.List;

public class Album {

	private String titulo;
	private String artista;
	private int ano;
	private List<Music> musicas;
	
	public Album(String titulo, String artista, int ano, List<Music> musicas) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.ano = ano;
		this.musicas = musicas;
	}
	
	public void addMusica(Music musica) {
		musicas.add(musica);
	}
	
	public void removerMusica(Music musica) {
		musicas.add(musica);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Music> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Music> musicas) {
		this.musicas = musicas;
	}
	
}
